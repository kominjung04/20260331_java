package p02Method;

import javax.swing.*;
import java.util.Scanner;

public class J07Loop {
  public static void main(String[] args) {
    System.out.println("묵찌빠 게임을 시작합니다. 끝내기 : q");
    while (true) {
      System.out.println(" 묵 : 0 ,찌 : 1 , 빠 : 2");
      String input = new Scanner(System.in).nextLine();
      if (input.equals("q") || input.equals("Q")) break;// equals
      else {
        int my = Integer.parseInt(input);
        int you = (int) (Math.random() * 3);

        int game = my - you;
        String result = "";

        switch (game) {
          case -1, 2 -> result = "승리";
          case 0 -> result = "무승부";
          case 1, -2 -> result = "패배";
          default -> System.out.println("올바르지 않은 숫자를 입력했습니다.");
        }
        System.out.println("나: " + rcp(my) + " 너: " + rcp(you));
        System.out.println("결과 : " + result);
      }
    }
    System.out.println("묵찌빠 종료");
  }

  static String rcp(int pae) {
    return (pae == 0) ? "묵" : (pae == 1) ? "찌" : "빠";
  }

}
