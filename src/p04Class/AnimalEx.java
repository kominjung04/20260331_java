package p04Class;

// 개와 고양이의 관게를 클래스로 표현
// 상속,interface등의 관게와 각 클래스의 속성에 대한 게터세터,생성자등 여러 관계를 최대한 잘 표현
public class AnimalEx {
  public static void main(String[] args) {
  Dog dog = new Dog("시츄",5);
  Cat cat = new Cat("고양이",7);
    System.out.println(dog.getName());
    dog.speak();
    System.out.println("---------------");
    System.out.println(cat.getName());
    cat.speak();
    cat.climbable();

  }
}

abstract class Animal {
  private String name;
  private int age;
  abstract void speak(); //구현 강제

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int ageAge(){return age;}
  public void setAge(int age){this.age = age;}

  public Animal(String name,int age) {
    this.name = name;
    this.age = age;
  }
}

class Dog extends Animal  {
  public Dog(String name,int age) {
    super(name,age);
  }

  public void speak() {
    System.out.println("멍멍");
  }
}

class Cat extends Animal implements Climb  {
  public Cat(String name,int age){
    super(name,age);
  }

  public void speak(){
    System.out.println("야옹");
  }

  @Override
  public void climbable() {
    System.out.println("나무오르기");
  }
}

interface Climb{
  void climbable();
}
