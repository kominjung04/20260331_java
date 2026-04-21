package p08Generic;

public class J02Generic클래스레벨 {
  public static void main(String[] args) {
  String[] heroes = {"소방관","CapA","IronMan","BatMam"};
  GenericEx<String> genHeroes = new GenericEx<>();
  genHeroes.setArr(heroes);
  genHeroes.listPrint();

  Box<Apple> appleBox = new Box<>();
  Box<Orange> OrangeBox = new Box<>();

  GenericKV<String,Integer> genericKV = new GenericKV<>();
  genericKV.set("홍길동",1111);

  IRepository<String> repository = new IRepository<String>() {
    @Override
    public void save(String item) {
      System.out.println("Saving...." + item);
    }

    @Override
    public String findById(String id) {
      return "#" + id;
    }
  };
    System.out.println(repository.findById("admin"));
  repository.save("hello");
  }
}

// 1. 클래스 레벨 제네릭 사용 T::type
class GenericEx<T> {
  T[] arr;

  public T[] getArr() {return arr;}
  public void setArr(T[] arr) {this.arr = arr;}

  void listPrint() {
    for(T hero:arr){
      System.out.println(hero);
    }
  }
}
class Apple{}
class Orange{}
class Box<T> {
  private T value;
  public void set(T value) {this.value = value;}
  public T get() {return value;}
}

//2. 클래스 레벨 제네릭 사용 K,V
class GenericKV<K,V> {
  K name;
  V id;
  void set(K name, V id) {
    this.name = name; this.id =id;
  }
  K getName(){return name;}
  V getId(){return id;}
}

//3. interface 레벨 제네릭 사용
interface IRepository<T> {
  void save(T item);
  T findById(T id);

}