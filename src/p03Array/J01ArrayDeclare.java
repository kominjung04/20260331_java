package p03Array;

public class J01ArrayDeclare {
  public static void main(String[] args) {
    // 1. 배열의 크기를 먼정 정할 때
    double[] score = new double[10];
    for (int i = 0; i < score.length; i++) {
      System.out.println(score[i]);
    }
    double[] score2;
    score2 = new double[10]; //빈배열
    String[] greets = new String[5];
    for (int i = 0; i < greets.length; i++) {
      System.out.println(greets[i]);
    }

    //2. 배열 선언과 초기화를 동시에 진행할 때
    int[] arr = new int[]{1, 2, 3, 4, 5};
    int[] arr2 = {1, 2, 3}; //단축형 :선언과 초기화 분리 안됨.
    int[] arr3;
    arr3 = new int[]{}; //빈배열 (String=""와 같은 형태)
    // Object는 모든 참조형변수의 조상
    Object objs[] = new Object[]{true, 1, "Hello"};
    objs[0] = new String("hello");
    String str = new String("world");
    char[] chars = new char[]{'w', 'o', 'r', 'l', 'd'};
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i]);
    }
    System.out.println();
    for (char c : chars) {
      System.out.print(c);
    }

    //2차원 배열
    int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println();
    int sum = 0;
    for (int i = 0; i < arr2d.length; i++) {
      for (int j = 0; j < arr2d[i].length; j++) {
        System.out.print(arr2d[i][j]);
        sum += arr2d[i][j];
      }
      System.out.println();
    }
    System.out.println(sum);

    int[][] arrs = new int [4][4];
    for (int i = 0; i < arr2d.length; i++) {
      for (int j = 0; j < arr2d[i].length; j++) {
        arrs[i][j] = arr2d[i][j];
        arrs[i][arr2d[i].length]+=arr2d[i][j];
        arrs[i][arr2d[i].length]+=arr2d[i][j];
        System.out.print(arrs[i][j]);
      }
      System.out.println();
    }
    for (int i = 0; i < arrs.length; i++) {
      for (int j = 0; j < arrs.length; j++) {
        System.out.print(arrs[i][j]);
      }
      System.out.println();
    }
  }
}
// 출력해보기
// 1  2  3  9
// 4  5  6  15
// 7  8  9  24
// 12 15 18 45