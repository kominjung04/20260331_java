package p05Exception;

public class J03ExceptionExtends {
  public static void main(String[] args) {

  }
}

class Parent{
  protected void method() throws ArithmeticException,ClassCastException{};
}

class Child extends Parent{
  @Override
  // Override 할 때 접근 제어자 :: 같거나 더 넓게
  // Override 할 때 예외(throws) :: 같거나 좁게, 넓으면 에러
  public void method() throws ArithmeticException,ClassCastException {
    super.method();
  }
}
