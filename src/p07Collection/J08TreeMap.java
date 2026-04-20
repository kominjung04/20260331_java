package p07Collection;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class J08TreeMap {
  public static void main(String[] args) {
    TreeMap<Integer,String> treeMap = new TreeMap<>();
    treeMap.put(5,"Apple");
    treeMap.put(3,"Banana");
    treeMap.put(4,"Orange");
    treeMap.put(1,"Grape");
    treeMap.put(2,"Mango");

    //1.key&value 출력
    Iterator<Integer> it = treeMap.keySet().iterator();
    while (it.hasNext()){
      Integer key = it.next();
      System.out.println(String.format("%s : %s",key,treeMap.get(key)));
    }

    Iterator itEntry = treeMap.entrySet().iterator();
    while (itEntry.hasNext()){
      Map.Entry entry = (Map.Entry) itEntry.next();
      System.out.println(String.format("%s : %s",entry.getKey(),entry.getValue()));
    }

    for (Map.Entry e : treeMap.entrySet()){
      System.out.println(e.getKey() + " " +  e.getValue());
    }

    //그외 메서드
    System.out.println("Value: " + treeMap.get(2));
    System.out.println("contain key: " + treeMap.containsKey(6));
    System.out.println("contain values: " + treeMap.containsValue("Grape"));
    treeMap.remove(5);
    System.out.println(treeMap);
    System.out.println(treeMap.keySet());
    System.out.println(treeMap.values());
    System.out.println(treeMap.entrySet());
  }
}
