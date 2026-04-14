package p05Exception;

public class J02throws {
  public static void main(String[] args) {
    try {
      method1();
    } catch (Exception e) {
      try {
        System.out.println(e.getMessage());
        e.printStackTrace();
      } catch (Exception e1) {

      }
    }

  }

  static void method1() throws Exception {
    method2();
    System.out.println("method1");
  }

  static void method2() throws Exception {
    method3();
    System.out.println("method2");
  }

  static void method3() throws Exception {
//    try{
//      System.out.println("오류");
//    } catch (Exception e) {
//      System.out.println("method3");
//    }
//
    try {//ctrl+alt+t
      throw new Exception();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
