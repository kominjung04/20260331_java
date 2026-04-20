package p07Collection;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class J06TreeSet {
  public static void main(String[] args) {
    // TreeSet은 데이터가 들어가는 순간 부터 정렬이 됨.
    TreeSet<Integer> set = new TreeSet<>();
    //1. 자연 정렬
    set.add(9);
    set.add(4);
    set.add(7);
    set.add(2);
    //set.add('A'); //Integer와 String이 서로 비교 불가 이기 때문 => 하나의 타입으로 통일
    System.out.println("자연정렬: " + set);
    Iterator<Integer> it = set.descendingIterator(); //역순 출력, TreeSet에만 있음
    while (it.hasNext()){
      System.out.println(it.next());
    }
    for (Integer n :set){
      System.out.println(n); //순차로 출력
    }

    //2. 사용자 정렬 Comparator::Collection에 구현
    Set<Integer> set2 = new TreeSet<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) { //두개를 비교
        return o2 - o1; //양수면 먼저, 음수면 뒤에, 0이면 그대로
      }
    });
    set2.add(10);
    set2.add(30);
    set2.add(20);
    System.out.println("사용자 정렬 Comparator: " + set2);

    //3. 사용자 정렬 Comparable::비교대상의 객체에 구현
    String[] colors = {"Yellow", "red","black","pink","blue" };
    Set<Ball> set3 = new TreeSet<>();
    while (set3.size()<5){
      int tmp = (int)(Math.random() * colors.length);
      set3.add(new Ball(tmp + 1 ,colors[tmp]));
    }
    System.out.println("사용자 정렬 Comparable: " + set3);

  }
}

//자신을 기준으로 다른 개체를 비교
class Ball implements Comparable {
  private int num;
  private String color;

  public Ball(int num, String color) {
    this.num = num;
    this.color = color;
  }

  @Override
  public int compareTo(Object o) {
    Ball tmp = null;
    if(o instanceof Ball) tmp = (Ball) o;
    //ball의 숫자를 비교 할 경우
    //return num - tmp.num;

    //ball의 color를 비교할 경우(String)
    //abc 순서로 정렬 (모든 문자를 대문자 or소문자로 통일 후 비교)
    return color.toLowerCase().compareTo(tmp.color.toLowerCase());
  }

  //color(num)
  public String toString(){
    return String.format("%s(%d)",color,num);
  }
}
