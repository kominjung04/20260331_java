package p04Class;

public class J06Interfacecasting {
  public static void main(String[] args) {
    Mammals[] mArr = new Mammals[]{new Elephants(), new Human(), new Bat()};
    Birds[] bArr = new Birds[]{new Parrot(), new Eagle(), new Chicken()};
    Groudable[] gArr = new Groudable[]{new Elephants(), new Human(), new Chicken()};
    Flyable[] fArr = new Flyable[]{new Bat(), new Parrot(), new Eagle(), new Chicken()};
    for (int i = 0; i < fArr.length; i++) {
      fArr[i].fly();
    }
  }
}

class Mammals {
}

class Birds {
}


class Elephants extends Mammals implements Groudable {
}

class Human extends Mammals implements Groudable {
}

class Bat extends Mammals implements Flyable {
  public void fly() {
    System.out.println("박쥐 날다");
  }
}

class Parrot extends Birds implements Flyable {
  public void fly() {
    System.out.println("앵무새 날다");
  }
}

class Eagle extends Birds implements Flyable {
  String name = "독수리";
  public void fly() {
    System.out.println(name+" 날다"); //자신이 속한 클래스 변수, 메서드 사용 가능
  }
}

class Chicken extends Birds implements Groudable, Flyable {
  public void fly() {
    System.out.println("닭 날다?");
  }
}

interface Groudable {
}

interface Flyable {
  void fly();
}

