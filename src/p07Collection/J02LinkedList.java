package p07Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J02LinkedList {
  public static void main(String[] args) {
    List al = new ArrayList();
    List ll = new LinkedList();

    System.out.println("== 순차적 추가 ==");
    System.out.println("ArrayList: " + addSequentially(al));
    System.out.println("LinkedList: " + addSequentially(ll));

    System.out.println("== 중간에 추가 ==");
    System.out.println("ArrayList: " + addMiddle(al));
    System.out.println("LinkedList: " +addMiddle(ll));

    System.out.println("== 중간에 삭제 ==");
    System.out.println("ArrayList: " + removeMiddle(al));
    System.out.println("LinkedList: " +removeMiddle(ll));

    System.out.println("== 순차적 삭제 ==");
    System.out.println("ArrayList: " + removeSequentially(al));
    System.out.println("LinkedList: " +removeSequentially(ll));

  }
  //순차적으로 값넣기
  static long addSequentially(List list) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1_000_000; i++) {
      list.add(i);
    }
    return System.currentTimeMillis() - start;
  }

  // 중간 값 넣기
  static long addMiddle(List list){
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1_000; i++) {
      list.add(5000,i);
    }
    return System.currentTimeMillis() - start;
  }
 //중간  값 삭제
  static long removeMiddle(List list){
    long start = System.currentTimeMillis();
    for (int i = 5000; i < 6_000; i++) {
      list.remove(i);
    }
    return System.currentTimeMillis() - start;
  }

  static long removeSequentially(List list){
    long start = System.currentTimeMillis();
    //끝에서부터 지우기
//   0
    // 0번째만 지우기 :: 중간삭제와 동일한 효과
    for (int i = 0 ; i<list.size();){
      list.remove(i);
    }
    return System.currentTimeMillis() - start;
  }
}
