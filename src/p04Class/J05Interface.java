package p04Class;

public class J05Interface {
  public static void main(String[] args) {
    System.out.println(Attackable.LEVEL);
    System.out.println(Defensible.LEVEL);
    System.out.println(Defensible.LEVEL);
  }
}

// 클래스가 공통된 것을 상속받는 경우(상속)와
// 클래스가 직접 관련 없지만 공통된 것들을 구현하는 경우(interface)
class Attack {

  private int level;

  void attack() {
  }
}

class Defense {

  private int level;

  void defense() {

  }
}

// 자바에서는 다중 상속 허용 불가 : 공통된 속성에 대하여 접근이 애매모호
// class Fighter extends Attackable,Defensible {}

// 다중상속 부재에 대한 해결책으로 interface를 사용(다중상속의 장점을 일부 수용)
// 인터페이스에서는 미완성된 추상 메서드, 상수만 사용
// 코드에 표준화를 도모하며 개발의 속도에 이점 :: 바디만 구현하면 됨
interface Attackable {
  public static final int LEVEL = 10;

  void attack();
  //default,static은 잡 8버전부터 허용
  //default는 중복이 되면 재정의,안되면 override 없이 사용 가능
  public default void motion() {; //추상메소드 - 인스턴스 만들기 불가

  }
  //static 메서드는 클래스명.static메서드명으로 접근 가능하기 때문
  public static void shot(){}


}

interface Defensible {
  // 메서드 : public abstract, 상수: public static final 자동추가
  int LEVEL = 10;

  void defense();

  void motion();
  public static void shot(){

  }

}
class Gangster implements Attackable, Defensible {
  @Override
  public void defense() {}
  @Override
  public void attack() {}
  //default 메서드로 중복되어도 재정의하면 문제 없음
  @Override
  public void motion() {}
}

interface IRun{
  void run();
}
interface IBike{
  void ride();
}
interface ISwim{
  void swim();
}

class Triathlon implements IBike,IRun,ISwim{
  public void run(){};
  public void ride(){};
  public void swim(){};
}
// interface의 상속 발생
interface ITriathlon extends ISwim,IRun,IBike{ }