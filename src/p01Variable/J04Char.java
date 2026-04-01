package p01Variable;

public class J04Char {
  static private  char c;

  public static void main(String[] args) {
  // static은 같은 static끼리만!
    did();
    System.out.println(c);
    J04Char ex = new J04Char();
    System.out.println(ex);
    //c가 private이지만 같은 클래스 내부에서 사용되면 허용
    System.out.println(ex.c);
    ex.did();
    char c2 = 'A'; //Char는 '만 가능
    // c2 = "B" //"는 문자열일 때만
    // c2 = '' //비어있는 문자 선언 불가
    // Unicode 문자 입력 가능 역슬래시u 유니코드 문자 시작, 0000 16진수(hex) 값
    c2='\u0000'; // 공백
    c2='\u0041'; // A


    System.out.println(++c2); //단항연산자일 경우 타입을 보존
    System.out.println(c2+2); //이항연산자는 연산 시 형변환 발생
    System.out.println(String.format("%c ~ %c" ,Character.MIN_VALUE,Character.MAX_VALUE));

  }
  static void did() {
    J04Char ex = new J04Char();

  }
}

class Other {
  private char c1;
  void otherMethod(){
    J04Char ex = new J04Char();
    J04Char.did();
    //static이지만 private이라서 외부에서 접근 불가
    //System.out.println(J04Char.c);
  }
}

