package p05Exception;

public class J05CustomException{
  public static void main(String[] args) {
    try {
      throw new MyExecption();
    } catch (MyExecption e) {
      System.out.println(e.getMessage());
    }

  }
}

class MyExecption extends Exception{
  public MyExecption(){
    super("나의 Exception 처리");
  }
}
