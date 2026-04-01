package p01Variable;

class Scope {
  // === 전역 변수(Global Variable) ===
  // Instance Variable::멤버 변수, 전역변수, 인스턴스 별로 각각의 값을 가짐
  int instVar = 10;
  // Static Variable::멤버 변수, 전역변수레벨에서만 선언, 모든 인스턴스가 값을 공유
  static int statVar = 20;

  int getStatVar(){
    return statVar;
  }
  void setStatVar(int num){
    statVar = num;
  }

  // === 지역 변수(Local Varialbe) ===
  // 지역변수는 static 변수 선언불가, 메서드 블록 안에서만 유효.
  void instMethod() {
    int localInstVar = 30; // 인스턴스 지역변수 선언 가능
    // static int localStatVar = 40; //static 지역변수 선언 불가
    System.out.println(instVar); // 인스턴스 멤버 변수 사용가능
    System.out.println(statVar); // 스태틱 멤버 변수 사용가능
    statMethod(); // 스태틱 메서드 호출 가능
    instMethod2();// 인스턴스 메서드 호출 가능
  }

  void instMethod2() {
  }

  static void statMethod() {
    // static은 같은 static변수, 메서드 끼리만 사용가능
    int localInstVar = 30; // 인스턴스 지역변수 선언 가능
    // static int localStatVar = 40; //static 지역변수 선언 불가
    //System.out.println(instVar);// 스태틱안에서 인스턴스 사용 불가
    System.out.println(statVar);// 스택틱안에서 스태틱변수 사용 가능
    // instMethod(); // 인스턴스 메서드 호출 불가:: 시점의 차이
    //main(new String[]{"hello"}); // 순환참조사용불가:: main의 안됨.
    statMethod2();
  }

  static void statMethod2() {
  }
  // Java는 CallByValue 방식을 사용: 실제값, 참조형 변수도 주소를 값으로 이용
}

public class J08VariableScope {
  public static void main(String[] args) {
    Scope vs1 = new Scope();
    Scope vs2 = new Scope();

    System.out.println(vs1.instVar);
    System.out.println(vs2.instVar);
    vs1.instVar = 10000;
    System.out.println(vs1.instVar);
    System.out.println(vs2.instVar);

    System.out.println("==============Static==============");
    System.out.println(Scope.statVar);
    vs1.setStatVar(200);
    System.out.println(vs1.getStatVar()); // static 값은 공유, instance 값은 각각
    System.out.println(vs2.getStatVar());

  }
}