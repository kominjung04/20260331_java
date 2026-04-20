package p01Variable;

import common.Util;

public class J02VariableType {
  public static void main(String[] args) {
    // Primitive Type(기본형) 변수 : 실제 값을 가짐
    boolean bool1 = false; // 논리형 1 byte :: true, false(기본)
    char c1 = '\u0000';   // 문자형 2 byte :: 오직 한글자만 할당, ' '(기본)
    byte b1 = 100;   // 정수형 1 byte :: -128 ~ 127, 0(기본)
    short s1 = 10;   // 정수형 2 byte :: -32768 ~ 32767, 0(기본)
    int num1 = 10;   // 정수형 4 byte :: -2147483648 ~ 2147483647, 0(기본)
    long l1 = 100L; // 정수형 8 byte :: 대략 -9백경 ~ 9백경, 0(기본)
    float f1 = 0.1f; // 실수형 4 byte :: 소수 7자리 ,0.0(기본)
    double d1 = 0.1; // 실수형 8 byte :: 소수 13자리, 0.0(기본)

    //java 10+ 생김:: 코드를 간결,간소가 장점, 잘못된 타입추론, 코드분석의 어려움 발생 가능
    var value = 10;
    Util.typeOf(value);

    // Reference Type(참조형) 변수 : 주소값을 가짐,null(기본)
    Car car = new Car();
    System.out.println(car.price);
    System.out.println(car.maker);
    System.out.println(car.sidong);
    System.out.println(car.fuel);
    car.drive();
    System.out.println(car);
  }
}
class Car{
  int price;
  String maker;
  boolean sidong;
  long fuel;
  void drive(){
  System.out.println("brrrr~!");
  }
}
