package p09Stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class J02CollectionStream {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    // ArrayList 원소에 0~9까지의 원소를 반복문으로 넣어보세요
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    System.out.println(list);

    ArrayList<String> listStr = new ArrayList<>();
    // ArrayList 원소에 0~9까지의 원소를 반복문으로 넣어보세요
    for (int i = 0; i < 10; i++) {
      //listStr.add(String.valueOf(i)); //숫자를 문자를
      //listStr.add(i+"");

      final int TMP = i; //지역변수가 익명개체안으로 들어갈 때 상수로 변환필수
      listStr.add(new Supplier<String>(){
        @Override
        public String get() {
          return String.valueOf(TMP);
        }
      }.get());

      Function<Integer,String> fnc = new Function<Integer, String>() { //바로 값을 넣기에 지역변수로 가능
        @Override
        public String apply(Integer tmp) {
          return tmp+"";
        }
      };
      listStr.add(fnc.apply(i));
    }

    // 새로운 ArrayList에 생성할 때
    ArrayList<Integer> list1 = IntStream.range(0,10)
        .boxed() //int -> Integer로 변환(컬렉션에 넣으려면 필요)
        .collect(Collectors.toCollection(
            new Supplier<ArrayList<Integer>>() {
              @Override
              public ArrayList<Integer> get() {
                return new ArrayList<Integer>();
              }
            }
        ));

    // 기존 ArrayList에 데이터를 추가할 때
    list1.clear(); //list1의 모든 데이터 지우기
    IntStream.range(0,10).forEach(e -> list1.add(e));
    System.out.println(list1);
  }
}
