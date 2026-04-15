package p07Collection;

import java.util.*;

public class J03StackQueue {
  public static void main(String[] args) {
    //LIFO(Last Input First Output): 맨 나중이 먼저 나간다.,push,pop,peek
    Stack stack = new Stack<>();

    //데이터 추가 add(),offer()
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(new String("3"));

    //데이터 접근
    for (int i = 0; i < stack.size(); i++) {
      if (i != 0) System.out.print(",");
      System.out.print(stack.get(i));
    }
    System.out.println();
    Iterator it = stack.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    it = stack.iterator(); // iterator 재사용시 반드시 초기화
    for (int i = 0; it.hasNext(); i++) {
      System.out.println(it.next());
    }

    for (Object o : stack) {
      System.out.println(o);
    }

    //데이터 크기
    System.out.println(stack.size());

    //데이터 포함 여부
    System.out.println(stack.contains(5));

    //stack의 상속 관계
    System.out.println(stack instanceof List);
    System.out.println(stack instanceof Object);
    System.out.println(stack instanceof Iterator
    );

    //데이터 삭제
    System.out.println(stack.remove(stack.size() - 1));
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);

    //데이터 끝부분 확인
    System.out.println(stack.get(stack.size() - 1));
    System.out.println(stack.peek());

    //Queue : FIFO(First Input First Output),offer,poll,peek
    Queue q = new LinkedList();

    //데이터 추가 add(),offer()
    q.add(0);
    q.add(1);
    q.offer(2);
    q.add(3);
    q.add(4);
    System.out.println("Queue: " + q);

    //데이터 접근 :: Queue에는 get이 없음. LinkedList이기 때문
    Iterator it2 = q.iterator();
    for (int i = 0; it2.hasNext(); i++) {
      if (i != 0) System.out.print(",");
      System.out.print(it2.next());
    }
    it2 = q.iterator();
    while (it2.hasNext()) {
      System.out.println(it2.next());
    }
    for (Object o : q) {
      System.out.println(o);
    }

    //데이터 포함여부
    System.out.println(q.contains(1));

    //데이터 크기
    System.out.println(q.size());

    //데이터 삭제
    System.out.println("삭제 전: " + q);
    System.out.println(q.poll());
    System.out.println("삭제 후: " + q);
    System.out.println(q.peek());
    System.out.println(q);

    //Collection 나오기 전 객체, 동기화 포함
    Vector v = new Vector();

    //데이터 추가
    v.add(0);
    v.add(1);
    v.add(2);
    v.add(3);

    //데이터 접근
    for (Object o : v) System.out.println(o);

    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      System.out.println(e.nextElement());
    }
    Iterator itv = v.iterator();
    while (itv.hasNext()) System.out.println(itv.next());


  }
}
