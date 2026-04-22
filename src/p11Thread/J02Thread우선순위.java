package p11Thread;

public class J02Thread우선순위 {
  public static void main(String[] args) {
    Thread t1 = new Thread(){
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("t1 Started");
        for (int i = 0; i < 300; i++) {
          System.out.print("|");}
          System.out.println("t1 terminated" + (System.currentTimeMillis() - startTime));
      }
    };

    Thread t2 = new Thread(){
      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("t2 Started");
        for (int i = 0; i < 300; i++) {System.out.print("-");}
        System.out.println("t2 terminated" + (System.currentTimeMillis() - startTime));
      }
    };
    //priority는 기본 값이 5, 범위는 1~10
    //운영체제에 따라서 우선순위가 7까지 줄 수 있음
    //우선순위 숫자가 높을 수록 높다. 7이상 주의
    t1.setPriority(7);
    t2.setPriority(2); // 현재 대부분의 컴퓨터는 멀티 코어라서 생각과 다름
    t1.start();
    t2.start();
  }
}
