package p02Method;

import javax.swing.*;
import java.util.Scanner;

public class J06Condition {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("점수입력:");
    int score = sc.nextInt();
    String result = "";
    int remain = score % 10;

    if (score > 100) result = "0 ~ 100사이 점수를 입력하세요";
    else if (score == 100) result = "A+";
    else if (score >= 60) {
      if (score >= 90) result = "A";
      else if (score >= 80) result = "B";
      else if (score >= 70) result = "C";
      else result = "D";

      if (score % 10 >= 7) result += "+";
      else if (score % 10 >= 4) result += "0";
      else result += "-";
    } else{
      result = "F";
    }
    System.out.println(result);


    String input = JOptionPane.showInputDialog("당신의 태이난 달은?(1-12)");
    int month = Integer.parseInt(input);
    switch (month) {
      case 12,1,2 -> result = "겨울";
      case 3,4,5 -> result = "봄";
      case 6,7,8 -> result = "여름";
      case 9,10,11 -> result = "가을";
      default -> result = "1-12사이를 입력하세요";
    }
    System.out.println("당신이 태어난 계절은 " + result+ "입니다.");
  }
}
