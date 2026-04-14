package p05Exception;

import java.security.spec.ECField;

public class J01trycatch {
  // Checked Exception :: 컴파일 시점에 검사하는 예외 (반드시 처리해야 함) 컴파일러가 강제 체크
  // 대표 예외 : IOException, SQLException, ClassNotFoundException, IllegalAccessException
  // Unchecked Exception :: 실행 시점에 발생하는 예외 (컴파일러가 체크 안 함) 개발자의 실수(버그)이기 때문에 컴파일러가 강제하지 않는다
  // 대표 예외 : ArithmeticException,NullPointerException,ArrayIndexOutOfBoundsException,ClassCastException

  public static void main(String[] args) {
    System.out.println(1);
    System.out.println(2);
    System.out.println(3);
    try {
      System.out.println(10 / (int) (Math.random() * 2));
      System.out.println(4);
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
      System.out.println(0);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println(5);
    } finally {
      System.out.println(6);
    }
    System.out.println(7);

  }
}
