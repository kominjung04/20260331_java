package p04Class;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class J12FunctionalPackage {
  public static void main(String[] args) {
    // 람다식과 함께 쓰라고 만든 표준 함수형 인터페이스 모음
    // 1. 입력 O / 반환 X
    Consumer c = new Consumer() {
      @Override
      public void accept(Object o) {
        System.out.println(o);
      }
    };//설계
    c = o -> System.out.println(o); //설계
    c.accept(10); //사용 , wrapper class 의 integer로 오토 형변환

    // 2. 입력 X / 반환 O
    Supplier s =new Supplier() {
      @Override
      public Object get() {
        return null;
      }
    };
    s = () -> "hello!";
    System.out.println(s.get());
    //예제
    Supplier<Integer> randomValue = () -> (int) (Math.random()*45);
    System.out.println("randomValue: " + randomValue.get());

    // 3. 입력 O / 반환 O
    Function<Integer,String> f = new Function<Integer, String>() {
      @Override
      public String apply(Integer integer) {
        return "";
      }
    };
    f = num -> "hello" + num;
    f.apply(100);
    //예제
    Function<Integer,Integer> square = x -> x*x;
    System.out.println("square: " + square.apply(3));

    // 4. 입력 O / 반환 O
    Predicate<Integer> p = new Predicate<Integer>() {
      @Override
      public boolean test(Integer n) {
        return n%2 == 0?true:false;
      }
    };
    p = n -> n%2 == 0?true:false;
    //예제
    Predicate<Integer> isEven = n -> n%2==0?true:false;
    System.out.println("isEven: "+ isEven.test(3));
    Predicate<Integer>evenAndPosition=isEven.and( integer -> integer > 0);
    System.out.println("evenAndPosition: "+ evenAndPosition.test(3));
    Predicate<Integer>TenEven=isEven.or( integer -> integer % 10 == 0);
    System.out.println("TenEven: "+ TenEven.test(5));
    Predicate<Integer>notEven=isEven.negate();
    System.out.println("notEven: "+ notEven.test(5));


    List<String> list = Arrays.asList("java","Python","C++");
    //자 -> 부 -> 자 일 경우,<>안에 타입을 정해서 형변환을 줄일 수 있다.
    Consumer<String> print = s3 -> System.out.println("언어: "+ s3);
    list.forEach(print);
    for(int i =0 ; i < list.size();i++){
      System.out.println("for문 :: 언어: " + list.get(i));
    }



  }
}


