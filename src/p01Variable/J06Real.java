package p01Variable;

public class J06Real {
  public static void main(String[] args) {
    float f1 = 0.0f; //f,F
    double d1 = 0.0; //d,D,없어도 됨

    System.out.println(String.format("%f ~ %f", Float.MIN_VALUE,Float.MAX_VALUE));
    System.out.println(String.format("%f ~ %f", Double.MIN_VALUE,Double.MAX_VALUE));

    float f2 = 0.123456789f;
    //float type은 (32bit 부동소수점) 정밀도가 7째자리
    System.out.println(f2); //float type은 (32bit 부동소수점) 정밀도가 7째자리

    double d2 = 0.1234567890123456789;
    //double은 (64bit 부동소수점) 정밀도가 16째자리
    System.out.println(d2);
    //컴터 내부에서 0.1을 이진수로 정확하게 표현할 수 없어서 무한소수가 되며, 저장방식의 차이로 발생
    System.out.println(0.1f == 0.1);
    System.out.println(0.1f == (float)0.1); //명시적 형변환 발생
    System.out.println((double)0.1f == 0.1); //명시적 형변환 발생
    System.out.println(String.format("%.16f",0.1f)); //명시적 형변환 발생
    System.out.println(String.format("%.16f",0.1)); //명시적 형변환 발생
  }
}
