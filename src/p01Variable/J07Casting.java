package p01Variable;
import static common.Util.*;
public class J07Casting {
  public static void main(String[] args) {
    //type Casting (형변환) :: 명시적, 묵시적
    //묵시적 형변화 :: 이항연산일 경우 int이하는 int로, int 이상은 큰 범위!
    //형변환 생략가능
    char c1 = 'A';
    byte b1 = 1;
    short s1 = 100;
    int i1 = 200;
    long l1 = 1000l;
    float f1 = 0.1f;
    double d1 = 0.0;
    typeOf(b1 + s1); // Integer
    typeOf(s1 + i1);
    typeOf(c1 + b1);

    typeOf(c1 + l1); // Long
    typeOf(l1 + f1); // Float
    typeOf(f1 + d1); // Double

    // 명시적 형변환 :: 형변환 생략 불가
    // double => float => int => (byte,short,char)
    b1 = (byte)1000; System.out.println("b1:"+b1);
    b1 = (byte)i1;  System.out.println("b1:"+ b1);
    i1 = (short)l1;  System.out.println("i1:"+ i1);

    System.out.println(f1 + l1);
    typeOf(f1+l1);

    // 환형이 생기는 자료형 :: byte,short, int, long, char
    // float,double은 오버플로우 발생시 Infinity, - Infinity가 된다.
  }
}
