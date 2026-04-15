package p07Collection;

import java.util.*;
import java.util.function.Predicate;

public class J01ArrayList {
  public static void main(String[] args) {
    //모든 컬렉션의 원소 타입은 Object 이다.
    //List :: interface, 순서 O, 중복 O, 크기에 자유롭다. 동기화 가능
    //List의 종류는 ArrayList,LinkedList,stack,queue
    List list = new ArrayList<>();
    //1. 데이터 추가
    list.add(true);
    list.add('A');
    list.add(10);
    list.add(3.14);
    list.add("hello");
    list.add(new Date());
    list.add(new Member("admin", "1234", "관리자"));
    //2. 데이터 조회
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(4));
    System.out.println(list.get(5));
//    Member mem = list.get(6).getId(); //형변환 해줘야 함
    Member mem = (Member) list.get(6); //자부자, 명시적 형변환 함수
    System.out.println(mem.getId());

    //3.전체 크기
    System.out.println(list.size());

    //4. 수정
    list.set(0,false);
    System.out.println(list);

    //5. 삭제
    // char A를 리스트에서 지우는 방법 3가지
    list.remove((Object) 'A'); //원소로 삭제
    list.remove(1); // char A는 index로 삭제
    list.removeIf(o -> "A".equals(o)); // Char A 삭제
    //list.remove(false); //원소로 삭제
    list.removeIf(o -> o instanceof Date);
    System.out.println("삭제 후 : " + list);

    //6. 포함여부
    System.out.println("포함여부: " + list.contains("hello"));


    //7. 비어 있는지 여부
    System.out.println("isEmpty: " + list.isEmpty());

    //8. 전체 삭제
    list.removeAll(list);
    List removeList = new ArrayList();
    removeList.add(3.14);
    list.removeAll(removeList); //다른 컬렉션으로 지울 때
    System.out.println("removeAll: "+ list);
    list.clear(); //완전 비울 때
    System.out.println("Clear: "+ list);


    //Collection의 generics 활용하여 형변환 번거로움 줄임.
    List<Member> mList = new ArrayList<>();
    mList.add(new Member("admin", "1234", "관리자"));
    mList.add(new Member("user0", "1234", "사용자1"));
    mList.add(new Member("user1", "1234", "사용자2"));
    System.out.println(mList.get(0).getId()); //형변환 없이 사용가능
    System.out.println(mList.get(1).getId());
    System.out.println(mList.get(2).getId());

    // 전체 추가, 접근
    List<Integer> listInt = new ArrayList<>();
    for(int i = 0 ; i < 6; i++){
      listInt.add((int) (Math.random()*45));
    }
    System.out.println(listInt);

    System.out.println("====for====");
    for (int i = 0 ; i < listInt.size();i++){
      if(i!=0) System.out.print(",");
      System.out.print(listInt.get(i));
    }

    System.out.println();
    System.out.println("====forEach====");
    for(int i : listInt){
      System.out.print(i+ " ");
    }

    System.out.println();
    System.out.println("====interator====");
    Iterator it = listInt.iterator();
    while (it.hasNext()){
      System.out.print(it.next()+ " ");
    }

    System.out.println();
    System.out.println("====중복방지====");
    List lotto = new ArrayList<>();
    for( ; lotto.size() < 6; ){
      int ball = (int)(Math.random()*45);
      if(!lotto.contains(ball)) lotto.add(ball);
    }
    System.out.println(lotto);

    System.out.println("===Collections.shuffle(),sort()===");
    Collections.shuffle(lotto);
    System.out.print(lotto);
    Collections.sort(lotto);
    System.out.println(lotto);
  }
}

class Member {
  String id, pw, name;

  public Member(String id, String pw, String name) {
    this.id = id;
    this.pw = pw;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Member{id=%s, pw=%s, name=%s}", id, pw, name);
  }
}