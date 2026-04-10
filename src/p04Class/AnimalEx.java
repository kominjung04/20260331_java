package p04Class;

// 개와 고양이의 관게를 클래스로 표현
// 상속,interface등의 관게와 각 클래스의 속성에 대한 게터세터,생성자등 여러 관계를 최대한 잘 표현
public class AnimalEx {
  public static void main(String[] args) {
  Dog dog = new Dog("시츄",5);
  Cat cat = new Cat("고양이",7);
    System.out.println(dog.getName());
    dog.speak();
    dog.swarm();
    System.out.println(cat.getName());
    cat.speak();
    cat.noswarm();

  }
}

abstract class Animal {
  private String name;
  private int age;
  abstract void speak();

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int ageAge(){return age;}
  public void setAge(int age){this.age = age;}

  public Animal(String name,int age) {
    this.name = name;
    this.age = age;
  }
}

class Dog extends Animal implements Life {
  public Dog(String name,int age) {
    super(name,age);
  }

  public void speak() {
    System.out.println("멍멍");
  }
  @Override
  public void swarm(){
    System.out.println("무리생활");
  }
}

class Cat extends Animal implements Nolife {
  public Cat(String name,int age){
    super(name,age);
  }

  public void speak(){
    System.out.println("야옹");
  }
  public void noswarm(){
    System.out.println("개인생활");
  }
}

interface Life{
  void swarm();
}

interface Nolife{
  void noswarm();
}