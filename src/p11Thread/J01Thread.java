package p11Thread;

public class J01Thread {
  public static void main(String[] args) {
    //Thread는 각각의 흐름을 가지고 있다.main() 쓰레드임
    //Thread 생성 방법 2가지
    //1. Thread class
    MyThread t1 = new MyThread();
    t1.start();
    //2. Runnable class
    MyRunnable r1 = new MyRunnable();
    Thread t2 = new Thread(r1);
    t2.start();




  }
}

class MyThread extends Thread {

  @Override
  public void run() {
    System.out.println("MyThread started");
    try{Thread.sleep(1000);} catch (InterruptedException e){}
    System.out.println("MyThread terminated");
  }
}

class MyRunnable implements Runnable{

  @Override
  public void run() {
    System.out.println("MyThread started");
    try{Thread.sleep(1000);} catch (InterruptedException e){}
    System.out.println("MyThread terminated");

  }
}
