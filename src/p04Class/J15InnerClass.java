package p04Class;

public class J15InnerClass {
  public static void main(String[] args) {
    Outer outer = new Outer();
    System.out.println(outer.iv);

    // 인스턴스 내부클래스 생성
    Outer.InstanceInner oi = new Outer().new InstanceInner();
    System.out.println(oi.iiv); oi.instanceInner();
    Outer.InstanceInner.sii(); // 인스턴스 내부클래스의 스태틱 메서드 접근.

    // static 내부클래스 생성
    Outer.StaticInner os = new Outer.StaticInner();
    System.out.println(os.siv); os.staticInner();
    Outer.StaticInner.sii(); // static 내부클래스의 스태틱 메서드 접근.

    // 초기화 블럭
    Outer o1 = new Outer();
    Outer o2 = new Outer();
    Outer o3 = new Outer();
  }
}

class Outer {
  int iv;
  {
    // 인스턴스 초기화 블럭 :: new를 만날 때마다 생성
    System.out.println("Outer 인스턴스 초기화 블럭");
  }
  static {
    // static 초기화 블럭 :: 프로그램 시작전에 한번만 생성
    System.out.println("Outer static 초기화 블럭");
  }
  // 내부 클래스는 곧 변수이다.
  class InstanceInner {
    int iiv = 10;
    void instanceInner() {
      System.out.println("InstanceInner() iiv: " + iiv);
    }
    static void sii() {
      System.out.println("InstanceInner sii()");
    }
  }
  static class StaticInner {
    int siv = 10;
    void staticInner() {
      System.out.println("StaticInner() siv: " + siv);
    }
    static void sii() {
      System.out.println("StaticInner sii()");
    }
  }
}