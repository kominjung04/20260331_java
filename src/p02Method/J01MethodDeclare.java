package p02Method;

public class J01MethodDeclare {
  public static void main(String[] args) {
  Calculator cal = new Calculator();
  cal.add1();
  cal.add2(1,1);
  System.out.println(cal.add3());
  System.out.println(cal.add4(1,1));
  }
}

class Calculator {
  //method 유형
  /*리턴타입의 종류(기본형 8가지,참조형1가지,void)
  returntype, 메소드명(매개변수) {
    명령들...
   */

  //1. 매개변수 X, 리턴타입 X
  void add1() {
    System.out.println("매개변수 X, 리턴타입 X");
  }

  //2. 매개변수 O, 리턴타입 X
  void add2(int n1, int n2) {
    System.out.println(n1 + n2);
  }

  //3. 매개변수 X, 리턴타입 O
  String add3() {
    return "매개변수 X, 리턴타입 O";
  }

  //4. 매개변수 O, 리턴타입 O
  int add4(int n1, int n2) {
    return n1+ n2 ;
  }
}