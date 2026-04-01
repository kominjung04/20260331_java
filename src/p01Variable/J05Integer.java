package p01Variable;
import static common.Util.*;

public class J05Integer {
  public static void main(String[] args) {
    byte b1;  // 1byte
    short s1; // 2byte
    int i1;   // 4byte
    long l1;  //8byte
    //지역변수는 초기화하지 않고 사용시 에러
    //System.out.println(b1);
    l1 = 1_000_000_000_000_000l; //l 또는 L 붙임, _(단위구분)
    System.out.println(l1);
    System.out.println(Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
    System.out.println(String.format("%d ~ %d" ,Short.MIN_VALUE,Short.MAX_VALUE));
    System.out.println(String.format("%d ~ %d" ,Integer.MIN_VALUE,Integer.MAX_VALUE));
    System.out.println(String.format("%d ~ %d" ,Long.MIN_VALUE,Long.MAX_VALUE));

    b1 = 10;
    s1 = 10;
    // 단항 연산일 경우 type 유지
    typeOf(++b1);
    // 이항 연산일 경우 int보다 타입은 int로 묵시적 형변환 발생
    common.Util.typeOf(b1+s1);
    typeOf(b1+s1); //int보다 작으면 int로 형변환
    i1 = 100;
    l1 = 200;
    System.out.println(i1+l1);
    typeOf(i1 + l1); //int보다 큰byte면 큰것으로 형변환

  }
}
