package p04Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class J13MethodReference {
  public static void main(String[] args) {
    Consumer<String> consumer1 = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };
    Consumer<String> consumer2 = s -> System.out.println(s);
    Consumer<String> consumer3 = System.out::println; //Method Reference
    consumer1.accept("hello");
    consumer2.accept("hello");
    consumer3.accept("hello");


// 메서드레퍼런스 유형
// 1)정적 메서드 참조 Math::abs
// 2)특정 객체의 메서드 참조 System.out::println
// 3)클래스의 인스턴스 메서드 참조 String::compareToIgnoreCase
// 4)생성자 참조 ArrayList::new
    List<String> companies = Arrays.asList("SamSung", "Hyundai", "Doosan");
    companies.forEach(consumer3);//foreach(인터페이스를implement한 클래스) 인터페이스를 클래스로 구현한 객체
    companies.forEach(company -> System.out.println("Amazing" + company)); //익명개체
    companies.forEach(System.out::println); //메서드레퍼런스

    List<String> upperCompanies = companies.stream().map(new Function<String, String>() {
      @Override
      public String apply(String s) {
        return s.toUpperCase();
      }
    }).toList();
    upperCompanies = companies.stream().map(s -> s.toUpperCase()).toList();
    upperCompanies.forEach(System.out::println);
    List<String> lowerCompanies = companies.stream().map(s -> s.toLowerCase()).toList();
    lowerCompanies.forEach(System.out::println);

    Supplier<ArrayList<String>> listSupplier = new Supplier<ArrayList<String>>() {
      @Override
      public ArrayList<String> get() {
        return new ArrayList<>();
      }
    };
    listSupplier = () -> new ArrayList<>();
    listSupplier = ArrayList::new;

    Function<Integer,Integer> f = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer a) {
        return Math.abs(a);
      }
    };
    f = a ->Math.abs(a); //lambda expression
    f = Math::abs; // method reference
    System.out.println(f.apply(-10));// 사용할 때


  }
}