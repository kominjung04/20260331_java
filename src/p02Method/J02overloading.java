package p02Method;

public class J02overloading {
  public static void main(String[] args) {
    System.out.println("Hello");
    System.out.println("True");
    System.out.println("100");
    // Overloading: 같은 클래스에서 같은 이름의 메서드를 중복해서 사용하는 경우
    // 매 : 매개변수의 타입과 순서, 갯수가 달라야 한다.
    // 리 : 리턴 타입은 상관 없다.
    // 이 : 이름은 같아야 한다.
  }
}

class Add{
  String add(String s1, String s2){
    return s1 + s2;
  }
  String add(String s1, String s2,String s3){
    return s1 + s2 + s3; //매개변수의 갯수가 다르다
  }
  String add(int s1, String s2){
    return s1 + s2; //매개변수의 타입순서가 다르다
  }
  String add(String s1, int s2){
    return s1 + s2; //매개변수의 타입순서가 다르다
  }
//  String add(String s2, String s1){
//    return s1 + s2; //매개변수의 타입순서가 같으면 안된다.
//  }
  int add(int s1,int s2){
    return s1 + s2; //리턴값은 상관없다
  }

}
