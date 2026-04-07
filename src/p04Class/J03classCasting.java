package p04Class;

//다중상속 혀용 불가
//class child extends Father,Mother{
//
//}
class Father {
  String lastName = "이";
  String firstName;
}

class Mother {
  String lastName = "김";
  String firstName;
}

public class J03classCasting {
  public static void main(String[] args) {
    Child c1 = new Child();
    Child c2 = new Child();
    System.out.println(c1);
    System.out.println(c2);
    Parents p = new Parents();
    System.out.println(c1 instanceof Child); //instanceof 상속관계연산자
    System.out.println(c1 instanceof Parents);
    System.out.println(c1 instanceof Object);
    System.out.println(p instanceof Child); // 역으로 상속관게는 false
  //System.out.println(c2 instanceof Car); //상속 관계 일때만
    System.out.println(p.age);
    System.out.println(p.firstName);
    p.call();
    System.out.println(c1.age);
    System.out.println(c1.firstName);
    c1.call();

    Parents p2 = new Child(); //자식 -> 부모 OK
    System.out.println("자식 -> 부모");
    System.out.println(p2.age + "/" + p2.firstName); //상속관계 속성 중복 시속성은 부모
    p2.call(); //상속관계 속성 중복 시 method는 자식
  //Child c3 = (Child)new Parents();//ClassCastException 부모 -> 자식 NO
    Child c4 = (Child) p2; // 자식 -> 부모 -> 자식 OK
    System.out.println("자식 -> 부모 -> 자식");
    System.out.println(c4.age + "/" + c4.firstName);
    c4.call();
  }
}

class Parents {
  int age = 50;
  String familyName;
  String firstName ="아부지";
  void call(){
    System.out.println("아버지");
  }
}

class Child extends Parents {
  int age = 16;
  String firstName = "아들";
  void call(){
    System.out.println("아버지를 아버지라...");
  }
}
