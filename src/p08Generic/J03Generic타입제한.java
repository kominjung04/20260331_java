package p08Generic;

import java.util.ArrayList;
import java.util.List;

public class J03Generic타입제한 {
  public static void main(String[] args) {
    // 와일드카드는 ‘가능성 전체’를 기준으로 검사한다
    // <? super T>는 T와 T의 부모 타입만 허용, 입력전용
    List<? super Dog> listSuper1 = new ArrayList<Object>();//확정된 타입이 아니라 가능한 타입의 집합
    List<? super Dog> listSuper2 = new ArrayList<Animal>();
    List<? super Dog> listSuper3 = new ArrayList<Dog>();
    //List<? super Dog> listSuper4 = new ArrayList<Poodle>(); //<? super Dog> - dog 또는 dog의 조상만 가능

    List<? super Dog> listSuper = new ArrayList<Animal>();
    //<>,<Animal>,<Object>를 넣더라도 Dog 이하만 넣음
    //listSuper.add(new Object());//Object나 Animal을 담을 수 있다는 보장은 없기 때문
    //listSuper.add(new Animal());//컴파일러는 최악의 경우를 가정함:
    listSuper.add(new Dog());// 모든 가능한 타입에서 안전해야만 허용된다::자부자
    listSuper1.add(new Dog());
    listSuper2.add(new Dog());
    listSuper3.add(new Dog());
    listSuper.add(new Poodle());
    listSuper1.add(new Poodle());
    listSuper2.add(new Poodle());
    listSuper3.add(new Poodle());

    // <? extends T>는 T와 T의 자식 타입만 허용, 상한 경계, 읽기전용
    //List<? extends Dog> listExtends1 = new ArrayList<Object>();
    //List<? extends Dog> listExtends2 = new ArrayList<Animal>();
    List<? extends Dog> listExtends3 = new ArrayList<Dog>();
    List<? extends Dog> listExtends4 = new ArrayList<Poodle>();

    // 정확한 타입을 모르는 리스트라서 아무 것도 안전하게 넣을 수 없기 때문에 add 자체를 막아버림
    List<? extends Poodle> listExtends = new ArrayList<Poodle>();
    //<>,<Poodle>,<Object>를 설정하더라도 아무것도 못 넣음
    //listExtends.add(new Object());
    //listExtends.add(new Animal());
    //listExtends.add(new Dog());
    //listExtends.add(new Poodle());
    //listExtends3.add(new Dog());
    //listExtends4.add(new Dog());
    //listExtends3.add(new Poodle());
    //listExtends4.add(new Poodle());
  }
  // Dog, Poodle타입 둘중에 어느 하나로 고정할 수 없다.이 코드가 가능한 모든 타입 경우에서 100% 안전한가?
  //static void process(List<? extends Poodle> list) {
  //  Poodle p = list.get(0); // ✅ 안전
  //}
  static void process(List<? extends Dog> list) {
    Poodle p = (Poodle) list.get(0); //명시적 형변환이 없으면 에러
  }

  //? :: 모든 참조형 타입이 가능
  GenType<?> genType1 = new GenType<>();
  GenType<?> genType2 = new GenType<Object>();
  GenType<?> genType3 = new GenType<Animal>();
  GenType<?> genType4 = new GenType<Integer>();
}
class Animal {
  String name = "Animal";
  public String getName(){return name;}
  public void setName(String name){this.name = name;}
  public String toString(){return name;}
}

class Dog extends Animal {
  public Dog(){setName("Dog");}
}

class Poodle extends Dog {
  public Poodle() {setName("Poodle");}
}

class GenType<T> {
  T obj;
}
