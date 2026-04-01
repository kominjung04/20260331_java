package p01Variable;

public class J03Boolean {
  public static void main(String[] args) {
    boolean b1 = true;
    boolean b2 = false;
    // 논리형 변수는 사칙연산 불가
     System.out.println(b1 || b2); // 논리형 변수는 논리곱, 논리합, 논리부정 연산 가능
   // b1 = 100;,정적 타입이라서 다른 타입 변환 불가

    //boolean 형식의 문자 true 외의 모든문자열은 false가 된다.
    System.out.println(Boolean.valueOf("TruE")); //true
    System.out.println(Boolean.valueOf("true")); //true
    System.out.println(Boolean.valueOf("false")); //false
    System.out.println(Boolean.valueOf("1")); //false
    System.out.println(Boolean.valueOf("0")); //false
    System.out.println(Boolean.valueOf("")); //false
    //System.out.println(Boolean.valueOf(0)); //매개변수로 문자만 가능
    //System.out.println(Boolean.parseBoolean(1)); //매개변수로 문자만 가능
    System.out.println(Boolean.parseBoolean("1"));
    System.out.println(Boolean.parseBoolean("0"));
    System.out.println(Boolean.parseBoolean("tRue"));

    Tv tv = new Tv();
    //class의 속성이 private일 경우 class 밖에서는 접근 불가
    //System.out.println(tv.power);
    //tv.power = true;
    tv.turnPower();
    tv.turnPower();
  }
}

class Tv {
  private boolean power;
  void turnPower(){
    power = !power;
    System.out.println(power?"켜졌습니다":"꺼졌습니다.");
  }
}