package p11Thread;

public class J03Daemon {
  static boolean autoSave = false;
  public static void main(String[] args) {
    MyDeamon myDeamon = new MyDeamon();
    myDeamon.setDaemon(true); //Deamon은 메인스레드가 종료되면 같이 종료됨
    myDeamon.start();

    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
        myDeamon.setAutoSave(autoSave);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      if(i==5) autoSave = true;
    }

  }
}

class MyDeamon extends Thread{
  boolean autoSave = false;

  public void setAutoSave(boolean autoSave) {
    this.autoSave = autoSave;
  }

  @Override
  public void run() {
    while (true) {
      try {Thread.sleep(1000*3);} catch (InterruptedException e) {}
      if(autoSave) System.out.println("Saved...");
    }
  }

}
