package p11Thread;

import javax.swing.*;

public class J04Bomb {
  public static void main(String[] args) {
    Bomb bomb = new Bomb();
    bomb.start();
    String input = JOptionPane.showInputDialog("빨간선(0)과 파란선(1)중 선택");
    bomb.setLife(Integer.parseInt(input));
  }
}

class Bomb extends Thread {
  private int life = (int) (Math.random() * 2);
  private boolean state = false;

  public void setLife(int input) {
    if (life == input) {
      System.out.println("살았다.");
    } else {
      System.out.println("Bomb!!!");
    }
    state = true;
  }

  @Override
  public void run() {
    for (int i = 10; i > 0; i--) {
      if(state) break;
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    if(state == false) System.out.println("Bomb!!!");
  }
}

