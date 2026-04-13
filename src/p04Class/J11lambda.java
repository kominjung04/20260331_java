package p04Class;
//JAVA 책 p479
public class J11lambda {
  public static void main(String[] args) {
    MyInterfaceLambda lambda = () -> {
      if(true){
        System.out.println("참");
      }
      else {
        System.out.println("거짓");
      }
    System.out.println("Lambda~!");
  };
    lambda.method();
    //FunctionInterface를 먼저 구현 후 사용
    MyFnc1 myFnc1 = () -> {};
    MyFnc2 myFnc2 = (int n) -> System.out.println("매개변수O,리턴타입x"); // 명령 하나일 때만 {}생략 가능
    MyFnc3 myFnc3 = () -> 1; //return 생략 가능
    MyFnc4 myFnc4 = n -> n; //매개변수 하나일 때 ()생략가능
    myFnc1.method();
    myFnc2.method(2);
    myFnc3.method();
    myFnc4.method(2);
  }
}

//일반 인터페이스는 추상 메소드가 여러개라서 람다식으로 변환 불가
interface MyInterface{
  void Method1();
  void Method2();
  void Method3();
}

// lambda 식을 사용하려면 메소드가 오직 하나만 있어야 한다.
@FunctionalInterface //JDK 8 이상
interface MyInterfaceLambda{
  void method();
  //lambda식 불가(static,default method)
  static void method2(String arg){ //static 람다식 불가
    System.out.println(arg + "hello!");
  }
  default void method3(int n1){ // default 람다식 불가
    System.out.println(n1);
  }
}

@FunctionalInterface
interface MyFnc1 {
  void method(); //매개변수 X,리턴타입 X
}

@FunctionalInterface
interface MyFnc2 {
  void method(int n); //매개변수 O,리턴타입 X
}

@FunctionalInterface
interface MyFnc3 {
  int method(); //매개변수 X,리턴타입 O
}

@FunctionalInterface
interface MyFnc4 {
  int method(int n); //매개변수 O,리턴타입 O
}