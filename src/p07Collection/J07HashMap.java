package p07Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class J07HashMap {
  public static void main(String[] args) {
    Map<String,Integer> map = new HashMap<>();
    //map은 중복을 허용하지 않기에 같은 키는 덮어씀
    map.put("admin",1234);
    map.put("admin",1111);
    map.put("user1",1234);
    System.out.println(map);

    //1. key & value 동시에 가져올 때
    Iterator itEntry = map.entrySet().iterator();
    while (itEntry.hasNext()){
      Map.Entry entry = (Map.Entry)itEntry.next();
      System.out.println(
          entry.getKey() +" "+entry.getValue());
    }

    Iterator itKey = map.keySet().iterator();
    while(itKey.hasNext()){
      String key = (String) itKey.next();
      System.out.println(key +" " + map.get(key));
    }

    Iterator itValue = map.values().iterator();
    while (itValue.hasNext()) {
      Integer tmp = (Integer) itValue.next();
      System.out.println(tmp);
    }
    // var는 타입을 잡기 애매할 경우 사용 장점
    for (var entry : map.entrySet()){
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
    
    System.out.println(map.keySet());
    System.out.println(map.values());
    System.out.println(map.entrySet());
    if(!map.containsKey("roo")) map.put("root",1234);
    if(!map.containsKey("1111")) map.put("admin",1234);
    map.remove("root"); // key값을 비교하여 삭제
    map.remove("user1","1111"); //일치하는 값이 없으면 삭제 안됨.
    System.out.println(map);
    addPhone("친구","김길동","010-1111-1111");
    addPhone("친구","이길동","010-1111-1112");
    addPhone("회사","박길동","010-1111-1113");
    addPhone("친구","홍길동","010-1111-1114");
    addPhone("동네세탁소","051-111-1111");
    printPhoneBook(phoneBook);
  }

  static Map phoneBook = new HashMap();
  static void addPhone(String group, String name, String tel){
    addGroup(group);
    HashMap book = (HashMap) phoneBook.get(group);
    book.put(name,tel);
  }

  static void addPhone(String name,String tel){
    addPhone("기타",name,tel);
  }

  static void addGroup(String group){
    if(!phoneBook.containsKey(group)) phoneBook.put(group,new HashMap<>());
  }

  static void printPhoneBook(Map map){
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()){
      Map.Entry e = (Map.Entry) it.next(); //k,v 한 쌍을 들고 올 때
      Map book = (HashMap)e.getValue();
      System.out.printf("== %s [ %d 개] == %n",e.getKey(),book.size());

      Iterator itb = book.entrySet().iterator(); //book을 위한 반복자
      while(itb.hasNext()){
        Map.Entry eb = (Map.Entry) itb.next(); //k,v 한 쌍을 들고 올 때
        System.out.printf("이름: %s tel: %s %n",eb.getKey(),eb.getValue());
      }
      System.out.println();
    }
  }


}
