package p08Generic;

public class J03Generic타입제한 {
  public static void main(String[] args) {
    Gen1 gen1 = new Gen1();
    Gen2 gen2 = new Gen2();
    Gen3 gen3 = new Gen3();
    //<? super type>,<? extends type> 매개변수의 타입을 제한하는 목적
    //<? super Gen2>는 매개변수의 타입이 Gen2인 조상인 Gen1을 허용
    GenType<?super Gen2> genSuper1 = new GenType<>(gen2);
    //Gen3 g3 = (Gen3) genSuper1.get(); //ClassCastException
    Gen2 g2 = (Gen2) genSuper1.get();
    Gen1 g1 =(Gen1) genSuper1.get();

    GenType<?extends Gen2> genSuper2 = new GenType<>(gen2);
    //Gen3 g3 = (Gen3) genSuper1.get(); //ClassCastException
    Gen2 g21 = (Gen2) genSuper1.get();
    Gen1 g11 =(Gen1) genSuper1.get();

    GenType<?super Gen2> genSuper3 = new GenType<>(gen3);
    Gen3 gen3a = (Gen3) genSuper3.get();
    System.out.println(gen3a.getName());

  }
}
class  Gen1 {
  String name = "Gen1";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

   class Gen2 extends Gen1 {
    public Gen2() {
      setName("Gen2");
    }
  }

   class Gen3 extends Gen2{
    public Gen3(){
      setName("Gen3");
    }
  }

  class GenType<T>{
    T obj;
    public GenType(T obj) {this.obj = obj;}
    public void set(T obj) {this.obj = obj;}
    public T get() {return obj;}
  }

