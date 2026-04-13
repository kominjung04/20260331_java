package p04Class;

class Direction{
  static final int NORTH = 0;
  static final int EAST = 1;
  static final int SOUTH = 2;
  static final int WEST = 3;
  private Direction(){}
}
abstract class ADirection{
  static final int NORTH = 0;
  static final int EAST = 1;
  static final int SOUTH = 2;
  static final int WEST = 3;
}
interface IDirection{
  int NORTH = 0;
  int EAST = 1;
  int SOUTH = 2;
  int WEST = 3;
}
public class J14Enum {
  public static void main(String[] args) {
    // 상수를 사용하려고 할 때 class 인스턴스 없이 직접 사용하고자 할 때
    System.out.println(Direction.NORTH);
    System.out.println(ADirection.NORTH);
    System.out.println(IDirection.NORTH);
    System.out.println(EDirection.NORTH);
    System.out.println(EDirection.NORTH.ordinal()); //숫자로 나옴
    System.out.println(EDirection3.EAST.name());
    System.out.println(EDirection2.EAST.getVal());
    System.out.println(EDirection2.EAST.ordinal());
    System.out.println(EDirection3.EAST.name());
    System.out.println(EDirection3.EAST.getSymbol());
    System.out.println(EDirection3.EAST.getVal());
    System.out.println(EDirection3.EAST.ordinal());
  }
}

enum EDirection{
  NORTH,EAST,SOUTH,WEST
}

enum EDirection2{
  NORTH(10),EAST(20),SOUTH(30),WEST(40);
  private final int val;
  EDirection2(int val) {this.val = val;}
  public int getVal() {return val;} // 상수라서 setVal() 안됨.
}

enum EDirection3{
  NORTH(10,"^"),EAST(20,">"),SOUTH(30,"v"),WEST(40,"<");
  private final int val;
  private final String symbol;
  EDirection3(int val,String symbol) {this.val = val;this.symbol = symbol;}
  public int getVal() {return val;} // 상수라서 setVal() 안됨.
  public String  getSymbol() {return symbol;}
}