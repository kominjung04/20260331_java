package p08Generic;

public class J03Generic타입제한 {
  public static void main(String[] args) {

  }
}
class  Gen1{
  String name = "Gen1";
  public String getName(){return name;}
  public void setName(String name){this.name =name;}

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

}
