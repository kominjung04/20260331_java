package p04Class;

public class J02classExtends {
  public static void main(String[] args) {

    Marine marine1 = new Marine();
    System.out.println(marine1.getName());
    System.out.println(marine1.getTribes());
    //아래의 인스턴스는 생성불가, 기본생성자가 모두 없기 때문
    //Unit unit = new Unit(10);
    //Terran terran = new Terran();

    //class앞에 abstract가 붙으면 스스로 인스턴스 생성 불가
    // Unit unit = new Unit(10,"Unit","Unit");
  }
}
  //상속관계라고 해서 모든 것을 상속 불가(private, 생성자, 초기화블럭 제외)
  //멤버변수(속성)와 public메서드(기능)만 상속 가능
  abstract class Unit { //인스턴스를 못만듬,상속 받아야 가능
    private int hp;
    private int armor;
    private String name;
    private String tribes;


    public Unit(int hp, String name, String tribes) {
      super(); // 모든 참조 변수의 조상 Object를 가리킴
      this.hp = hp;
      this.name = name;
      this.tribes = tribes;
    }

    public String getTribes() {return tribes;}
    public void setTribes(String tribes) {this.tribes = tribes;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}

    public int getArmor() {return armor;}
    public void setArmor(int armor) {this.armor = armor;}

    void move() {
    }

    void stop() {
    }
  }

  abstract class Terran extends Unit {
    //private String tribes = "Terran"; //종족이 Terran이라서 값을 넣으면 인스턴스는 인식 불가
    public Terran(int hp, String name) {
      super(hp, name, "Terran");
      //  setTribes("Terran");// 1.setter(메서드)를 이용한 속성 초기화 방법
    }
  }

  class Marine extends Terran {
    public Marine() {
      super(60, "Marine"); //나의 조상을 가리킴
      //setName("Marine");// 1.setter(메서드)를 이용한 속성 초기화 방법
    }
  }