package p04Class;

// 개와 고양이의 관게를 클래스로 표현
// 상속,interface등의 관게와 각 클래스의 속성에 대한 게터세터,생성자등 여러 관계를 최대한 잘 표현
public class AnimalEx {
  public static void main(String[] args) {
  Dog dog = new Dog("시츄");
  Cat cat = new Cat("고양이");
    System.out.println(dog.getName());
    dog.speak();
    System.out.println(cat.getName());
    cat.speak();

  }
}

abstract class Animal {
  private String name;

  abstract void speak();

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public Animal(String name) {
    this.name = name;
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  public void speak() {
    System.out.println("멍멍");
  }
}

class Cat extends Animal {
  public Cat(String name){
    super(name);
  }

  public void speak(){
    System.out.println("야옹");
  }
}