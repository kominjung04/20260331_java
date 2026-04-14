package p06BasicPackage;
import  common.Util;

import java.util.ArrayList;
import java.util.List;

import static common.Util.*;
public class J03WrapperClass {
  public static void main(String[] args) {
    //Boolean,Character,Byte,Short,Integer,Long,Float,Double 8가지
    //공통적으로 가지는 매서드 parseXXX(), valueOf()
    int i = 10;
    Object obj = 10; // 기본형=>Integer=>Object :: autoboxing
    System.out.println(i == (int)obj); //unboxing
    Integer integer = Integer.valueOf(i);
    Integer integer1 = 100; // 기본형 => Integer  ::autoboxing
    int i2 = integer1; //integer => 기본형 => unboxing
    System.out.println(integer);
    typeOf(integer1); typeOf(i);

    // wrapper의 메서드
    System.out.println("parseBoolean:" + Boolean.parseBoolean("123"));
    System.out.println("parseBoolean:" + Boolean.parseBoolean("true")); // true만 true 나머지는 false
    typeOf(Boolean.parseBoolean("123"));
    typeOf(Integer.parseInt("123"));
    typeOf(Byte.parseByte("123"));
    typeOf(Double.parseDouble("123.456"));

    System.out.println("valueOf(): " + Integer.valueOf("123"));
    typeOf(Integer.valueOf("123"));
    System.out.println("valueOf(): " + Boolean.valueOf("tRuE"));
    typeOf(Boolean.valueOf("TruE"));
    //valueOf()와 parseInt()의 차이점
    int x = Integer.parseInt("10"); // x는 int
    Integer integer2 = Integer.valueOf("10");//integer2는 Integer
    List<Integer> list = new ArrayList<>();
    list.add(Integer.valueOf("10"));
  }
}
