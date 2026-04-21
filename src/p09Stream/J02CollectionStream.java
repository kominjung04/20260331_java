package p09Stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class J02CollectionStream {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    // ArrayList<Integer> 원소에 0~9까지의 원소를 반복문으로 넣어보시오
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    System.out.println(list);
    list.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * n).forEach(System.out::println);

    int cnt = (int) list.stream().filter(n -> n % 3 == 0).count();
    System.out.println(cnt);
    int tot = list.stream().reduce(0, (a, b) -> a + b);
    // mapToInt :: Stream<Integer> 를 IntStream으로 변환
    tot = list.stream().mapToInt(new ToIntFunction<Integer>() {
      @Override
      public int applyAsInt(Integer integer) {
        return integer.intValue();
      }
    }).sum();
    double avg = list.stream().mapToInt(Integer::intValue)
        .average().orElse(0);
    int max = list.stream().mapToInt(Integer::intValue)
        .max().orElse(0);
    int min = list.stream().mapToInt(Integer::intValue)
        .min().orElse(0);
    IntSummaryStatistics stats = list.stream()
        .filter(n -> n % 2 == 0)
        .mapToInt(Integer::intValue)
        .summaryStatistics();
    System.out.println(stats.getSum());
    System.out.println(stats.getAverage());
    System.out.println(stats.getMax());
    System.out.println(stats.getMin());
    System.out.println(stats.getCount());
    System.out.println(stats);

    // ArrayList<String> 원소에 0~9까지의 원소를 반복문으로 넣어보시오
    ArrayList<String> listStr = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      //listStr.add(String.valueOf(i));
      final int tmp = i; // 지역변수가 익명객체안으로 들어갈 때 상수로 변환필
      Supplier sup = new Supplier<String>() {
        @Override
        public String get() {
          return String.valueOf(tmp);
        }
      };
      //listStr.add((String)sup.get());
      Function<Integer, String> fnc = new Function<Integer, String>() {
        @Override
        public String apply(Integer tmp) {
          return tmp + "";
        }
      };
      listStr.add(fnc.apply(i));
    }

    System.out.println("===== 새로운 ArrayList를 생성할 때 =====");
    ArrayList<Integer> list1 = IntStream.range(0, 10)
        .boxed() // int->Integer로 변환(컬렉션에 넣으려면 필요)
        .collect(Collectors.toCollection(
            new Supplier<ArrayList<Integer>>() {
              @Override
              public ArrayList<Integer> get() {
                return new ArrayList<Integer>();
              }
            }
        ));

    System.out.println("===== 기존 ArrayList에 데이터를 추가할 때 =====");
    list1.clear(); // list1의 모든 데이터 지우기
    IntStream.range(0, 10).forEach(new IntConsumer() {
      @Override
      public void accept(int e) {
        list1.add(e);
      }
    });
    System.out.println(list1);

    System.out.println("===== map :: 각 원소가 1:1로 변환 =====");
    list1.stream().map(n->n*n).forEach(System.out::println);

    System.out.println("===== flatMap :: 구조 펼치기 리스트안의 리스트 평탄화 =====");
    List<String> words = List.of("hello", "world");
    words.stream()
        .flatMap(word -> Arrays.stream(word.split("")))
        .forEach(System.out::println);

    List<List<Integer>> listFlat = List.of(List.of(1, 2), List.of(3, 4));
    listFlat.stream().map(inner -> inner.stream()).forEach(System.out::println); //X
    listFlat.stream().flatMap(inner -> inner.stream()).forEach(System.out::println); //O
    System.out.println();

    System.out.println("===== collect =====");
    List<Integer> result = IntStream.rangeClosed(1, 5)
        .boxed()
        .collect(Collectors.toList());
    Set<Integer> set = List.of(1, 1, 2, 2, 3)
        .stream()
        .collect(Collectors.toSet());
    String joined = List.of("A", "B", "C")
        .stream()
        .collect(Collectors.joining(","));
    Map<Integer, List<String>> grouped =
        List.of("apple", "banana", "kiwi")
            .stream()
            .collect(Collectors.groupingBy(String::length));
    List<Integer> result2 =
        IntStream.rangeClosed(1, 10)
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .boxed()
            .collect(Collectors.toList());

    System.out.println("===== removeIf =====");
    list1.removeIf(new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 0;
      }
    });
    System.out.println(list1);

    System.out.println("===== replaceAll =====");
    list1.replaceAll(new UnaryOperator<Integer>() {
      @Override
      public Integer apply(Integer integer) {
        return integer * integer;
      }
    });
    System.out.println(list1);


    List<String> strList = new ArrayList<>();
    strList.add("손흥민");
    strList.add("차범근");
    strList.add("박지성");
    strList.add("이강인");
    // Collection은 그자체로 스트림으로 연결 가능.
    strList.forEach(System.out::println);

    System.out.println("===== map :: 각 원소가 1:1로 변환 =====");
    strList.stream().map(name -> name.length())
        .forEach(s -> System.out.println(s));

    // parallelStream 성능을 극대화하기 위해 사용,순서가 섞일 수 있음.
    strList.parallelStream().forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });

    Map<String, String> map = new HashMap<>();
    map.put("a", "97");
    map.put("A", "65");
    map.put("0", "48");
    map.put("1", "49");
    map.forEach(new BiConsumer<String, String>() {
      @Override
      public void accept(String s, String s2) {
        System.out.printf("%s:%s%n", s, s2);
      }
    });

    // range 관련
    IntStream.range(1, 5).forEach(System.out::println);
    IntStream.rangeClosed(1, 5).forEach(System.out::println);
    int sum = IntStream.rangeClosed(1, 100).sum();
    System.out.println(sum);
    IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0)
        .forEach(System.out::println);
    int[] arr = IntStream.range(0, 5).toArray();
    IntStream.rangeClosed(1, 10).parallel().forEach(System.out::println);

  }
}
