package p04Class;

public class J07abstract {
  public static void main(String[] args) {
    ;
  }
}

// 추상클래스는 스스로 인스턴스 생성 불가
// 추상클래스는 abstract만 붙어도 추상클래스가 된다.
abstract class Items {
  private int price;
  private String cate;
  private String name;

  public Items(int price, String name, String cate) {
    this.price = price;
    this.cate = cate;
    this.name = name;
  }
}

abstract class Empty {
}

abstract class AbstractClass1 {
  abstract void done();

  void doing() {
    System.out.println("doing");
  }
}

abstract class Grocery extends Items {
  final int SUBNO = 1;

  public Grocery(int price, String name) {
    super(price, name, "채소류");
  }
}

class Onions extends Grocery {
  public Onions(int price) {
    super(price, "양파");
  }
}

abstract class Instance extends Items {
  final int SUBNO = 2;

  public Instance(int price, String name) {
    super(price, name, "인스턴트류");
  }

  public abstract void instant();
}

class Ramyeon extends Instance {
  public Ramyeon(int price) {
    super(price, "라면");
  }

  @Override
  public void instant() {

  }
}

