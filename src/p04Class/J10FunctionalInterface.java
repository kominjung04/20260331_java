package p04Class;

public class J10FunctionalInterface {
  public static void main(String[] args) {
    MyFunctionalInterface myFnc1 = new MyFunctionalInterface() {
      @Override
      public void myMethod() {
        System.out.println("myfnc");
      }
    };
    MyFunctionalInterface myFnc2 = () -> System.out.println();
  }
}

//FuctionalInterface :: 인터페이스 안에 추상메서드가 오직 하나만 존재

@FunctionalInterface //함수형 인터페이스
interface MyFunctionalInterface{
  void myMethod(); // 오직 하나만!
  //void myMethod2(); // 다른 메소드 추가 불가
  default void myDefault(){ }; //static 메소드 람다식 불가
  static void myStatic(){ };
}

//annotation 없으면 일반 interface
interface MyInterface2{
  void myMethod(); // 오직 하나만!
  void myMethod2(); // 다른 메소드 추가 가능
  default void myDefault(){ };
  static void myStatic(){ };
}
