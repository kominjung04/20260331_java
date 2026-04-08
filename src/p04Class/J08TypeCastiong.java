package p04Class;

public class J08TypeCastiong {
  public static void main(String[] args) {
    //java는 call by value, call by reference 중에 call by value.
    //이유: 기본형의 실제값과 참조형의 객체 대한 참조(주소)를 값으로 처리
    Data d = new Data();
    d.setVlaue(10);
    System.out.println("1.Data d.value: " + d.getValue()); //0

    J08TypeCastiong ex = new J08TypeCastiong();
    ex.show(50); //⭐ 2번호출 : 값이 넘어감
    System.out.println("Data d.value: " + d.getValue()); //0

    ex.show(d); //⭐ 3번 호출: 같은타입 클래스의 주소값이 넘어감
    System.out.println("Data d.value: " + d.getValue()); //200

    ex.show((Object) d);//⭐ 4번 호출: 상속관계 클래스 주소값이 넘어감 //자식->부모
    System.out.println("Data d.value: " + d.getValue());//300

    ex.show((Datable) d);//⭐ 5번 호출: interface관계 클래스 주소값이 넘어감
    System.out.println("Data d.value: " + d.getValue());//400

  }

  void show(int value) {//순수한 값
    value = 100; //매개변수(기본형변수) value의 값만 갱신
    System.out.println("2. 지역변수 value: " + value);
  }

  void show(Data d) {//같은 타입
    d.value = 200; // 매개변수(참조형변수) Data value 갱신
    System.out.println("3. 참조변수: d.value: " + d.value);
  }

  void show(Object obj) { //상속관계(종적)
    Data d = (Data)obj; // 부모 ->자식 (결론:자->부->자)
    d.value = 300;
    System.out.println("4. 참조변수(상속관계) d.value: " + d.value);
  }
  void show(Datable datable) { //인터페이스(이산적) 관계
    datable.setVlaue(400);
    System.out.println("5. 참조변수(interface관계) d.value: " + datable.getValue());
  }
}

interface Datable {
  void setVlaue(int value);

  int getValue();
}

class Data implements Datable {
  int value;

  @Override
  public void setVlaue(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }
}

class Coffee {
  int caffeine;
  String onesanji;

  public int getCaffeine() {
    return caffeine;
  }

  public int setCaffeine() {
    return this.caffeine = caffeine;
  }

  public String getOnesanji() {
    return onesanji;
  }

  public String setOnesanji() {
    return this.onesanji = onesanji;
  }
}
