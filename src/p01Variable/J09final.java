package p01Variable;

import java.util.Scanner;

public class J09final {
  public static void main(String[] args) {
    final float PI = 3.141592f;
    //PI = 3.14; 상수는 재없뎃 불가
    System.out.println(); //다음줄 넘어가기가 포함 :: 빈 행간
    System.out.println(""); //다음줄 넘어가기 불포함 :: 출력 내용 필수

    Scanner scan = new Scanner(System.in);
    System.out.print("반지름의 길이: ");
    int radius = scan.nextInt();
    System.out.println("원의 넓이 : " + (PI * radius * radius));
  }
}
