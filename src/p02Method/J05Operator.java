package p02Method;

public class J05Operator {
  public static void main(String[] args) {
        System.out.println("산술연산");
        System.out.println("+,-,*,/,%");
        //int n = 2 ** 2; // **는 없음

        System.out.println("비교연산");
        System.out.println("==,>,<,>=,<=, !=");

        System.out.println("논리연산");
        System.out.println("||, &&, !, ^");
        // 베타적 논리합(Exclusive Or)
        System.out.println( true ^ false );
        System.out.println( true ^ true ); //서로 다른 값일때 true

        System.out.println("비트 연산");
        System.out.println("&, |, ^, >>, <<, >>> 우측 이동 부호없는 경우");
        System.out.println(8>>>2); //Unsigned Right Shift, <<<는 없음


        System.out.println("대입연산");
        System.out.println("+=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>= , >>>=");

        System.out.println("단항 연산");
        System.out.println("++,--");

        System.out.println("삼항연산자");
        System.out.println("조건?참:거짓");
      }
    }


