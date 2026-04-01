package p01Variable;

public class J08VariableScope {
  // 전역 변수(Global Variable)
  //instance Variagle :: 멤버 변수, 전역변수, 인스턴스 별로 각각의 값을 가짐
  int instVar =10;

  //static Variagle :: 멤버 변수, 전역변수,전역변수 레벨 안에서만 선언, 모든 인스턴스가 값을 공유
  static int statVar = 20;

  // === 지역 변수(Local Variable) ===
  // 지역변수는 static 변수 선언불가, 메서드 블록 안에서만 유효
  void instMethod (){
    int localInstVar = 30; // 인스턴스 지역변수 선언 가능
    //static int localStatVar = 40; //static은 지역변수 선언 불가
    System.out.println(instVar); //인스턴스 멤버 변수 사용가능
    System.out.println(statVar);//static 멤버 변수 사용가능
    statMethod(); // static 메서드 호출 가능
    instMethod2(); //instance 메서드 호출 가능
  }

  void instMethod2(){}

 static void statMethod (){
    int localInstVar = 30; // 인스턴스 지역변수 선언 가능
    //static int localStatVar = 40; //static 지역변수 선언 불가
   // System.out.println(instVar); // 스태틱안에서는 인스턴스 사용 불가
   System.out.println(statVar); // 스태틱안에서 스태틱변수 사용 가능
   //instMethod(); //인스턴스 메서드 호출 불가 :: 시점의 차이
   //main(new String[]{"hello"}); // 순환참조사용불가 :: main의 안됨.
 }
  void statMethod2(){}

  public static void main(String[] args) {
  int localInsVar = 30;
  //static int localStatVar = 40;
  statMethod();
  }

  //Java는 callByValue 방식을 사용: 실제값, 참조형 변수도 주소를 값으로 이동

}
