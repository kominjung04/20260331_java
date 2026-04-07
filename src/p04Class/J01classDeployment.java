package p04Class;

public class J01classDeployment {
  public static void main(String[] args) {
    //class를 시스템에서 설계할 경우 클래스의 중복을 배제, 재사용 극대화하기 위해 2가지 개념
    //Has-a 관계 :: 포함관계

    //Is-a 관계 :: 상속관계
  }
}
class Car{
  String maker;
  String model;
  int wheel;
  int price;
  Engine engine; // has-a 관계
}

class Engine{
  int gitong;
  int fuelAmount;
}

class FireCar extends Car { //Is-a
  void shootWater(){}
}