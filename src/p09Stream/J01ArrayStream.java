package p09Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class J01ArrayStream {
  public static void main(String[] args) {
    // Java8+, 배열 또는 컬렉션을 다루기 위해서 만듦.
    // 배열또는 컬렉션을 스트림으로 변환해서
    // Elements(원소)를 일일히 다루지 않고
    // 처리해야 할 내용을 함수형 인터페이스로 정의해주면
    // 내부적으로 처리후 결과를 반영함. 뿐만 아니라 다른 스트림으로 연결도 가능
    // 기술적으로는 Fork와 Join을 활용
    // stream은 한번 열고 다시 열때는 초기화 필수
    // forEach, map, flatMap, distinct, sorted, removeIf, removeAll...

    //stream을 활용하여 단순 출력
    String[] arr1 = {"abc", "def", "ghi"};

    Stream<String> stream = Arrays.stream(arr1);
    stream.forEach(s -> System.out.print(s + " "));
    System.out.println();

    //배열의 원소를 대문자로 변경 후 새로운 배열 생성
    String[] arr2 = Arrays.stream(arr1).map(new Function<String, Object>() {
      @Override
      public Object apply(String s) {
        return s.toUpperCase();
      }
    }).toArray(new IntFunction<String[]>() {
      @Override
      public String[] apply(int value) {
        return new String[value];
      }
    });
    print(arr2);

    // 2개의 배열을 스트림을 통하여 합하기
    String[] unionArr = Stream.of(arr1, arr2).flatMap(new Function<String[], Stream<?>>() {
      @Override
      public Stream<?> apply(String[] strings) {
        return Arrays.stream(strings);
      }
    }).toArray(String[]::new);
    print(unionArr);

    // 합한 배열의 중복을 소문자로 변경하여 중복 배제하기
    String[] distinctArr = Arrays.stream(unionArr)
        .map(s -> s.toLowerCase()).distinct().toArray(String[]::new);
    print(distinctArr);

    //배열을 정렬하기
    String[] sortedArr = Arrays.stream(unionArr).sorted((o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase())).toArray(String[]::new);
    print(sortedArr);
  }

  //출력 메소드
  static void print(String[] arr) {
    Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
    System.out.println();
  }
}
