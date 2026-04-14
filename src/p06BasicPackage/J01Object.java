package p06BasicPackage;

import java.util.Objects;

public class J01Object {

  public static void main(String[] args) {
    // BasicPackage는 기본패키지. 별도의 import 없이 사용
    // getClass,toString,hashCode,equals,clone,쓰레드관련4개 총9개
    Object obj = new Object();
    System.out.println(obj);
    //getClass().getName()+"@"+Integer.toHexString(hashCode());
    System.out.println("toString(): "+obj.toString());
    System.out.println("hashCode(): "+obj.hashCode());
    System.out.println("getClass(): "+obj.getClass());

    MyObject myObj1 = new MyObject();
    System.out.println(myObj1.getClass());
    System.out.println(myObj1); // toString 재정의
    String s = new String("hello");
    System.out.println(s);
    MyObject myObj2 = new MyObject();
    System.out.println(myObj1.hashCode());
    System.out.println(myObj2.hashCode());
    System.out.println(myObj1 == myObj2);
    System.out.println(myObj1.equals(myObj2)); //equals 인스턴스비교

    // 인스턴스 복제
    try {
      MyObject myObj3 = (MyObject) myObj1.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }
}

class MyObject implements Cloneable {
  // 인스턴스 복제 : implements Cloneable, clone()과 hashCode()재정의
  @Override
  protected Object clone() throws CloneNotSupportedException {
    Object obj = null;
    try {
      obj = super.clone();
    } catch (CloneNotSupportedException e) { }
    return null;
  }

  @Override
  public int hashCode() {
    // Objects :: Object의 확장을 위한 별도의 객체.
    // hash() :: 입력 값 시퀀스를 활용한 해쉬 코드를 생성하여 제공
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "MyObject";
  }
  int value = 10;

  // 두개의 인스턴스 비교할 때 특별히 지정한 값으로 비교가능
  @Override
  public boolean equals(Object obj) {
    MyObject tmp = null;
    if(obj instanceof MyObject) tmp = (MyObject) obj;
    return tmp.value == this.value;
  }
}
