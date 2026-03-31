package p01Variable;

/*
* 멤버변수와 메서드는 클래스 없이는 선언될 수 없다.
* 클래스는 생성연산자를 new를 만나서 인스턴스를 생성해야 사용가능.
* 프로그램의 시작은 main()에서 시작한다.모든 클래스에 선언 가능.
*/

// file을 대표하는 클래스에는 반드시 public을 붙이고, 파일명과 클래스명 동일
public class J01VariableDeclare {
  //변수의 선언, 값이 없으면 기본값으로 초기화
  int num; // 0

  //메서드 선언
  void add() {
  }

  //  main()은 자바 프로그램 실행하기 위한 Entry Point
  //  main()이 들어 있는 클래스는 실행 가능
  //  main()의 실행은 JVM이 한다.
  //  main() 안에 내용들이 순차적으로 진행됨
  public static void main(String[] args) {
    System.out.println("hello");
    //선언                  =  주소값으로 초기화 :: 할당
    J01VariableDeclare j01 = new J01VariableDeclare(); //instance
    System.out.println(j01.num);
    j01.add();
    J01VariableDeclare j02 = new J01VariableDeclare();
    j02.num = 100;
    System.out.println(j02.num);
    Student s1 = new Student();
    Apple a1 = new Apple();
    s1.eatApple(a1);

    //선언 = 초기화 :: 할당
    int a = 10;
  }
}


// 변수 명명 규칙(Naming Convention)
// 대소문자가 구분되며 길이에 제한 없다.
// 예약어 사용 안됨.
// 숫자로 시작 안됨
// 특수문자는 ‘_’ 와 ‘$’ 만 사용가능
// 클래스 항상 대문자로 시작, 변수와 메서드는 항상 영문소문자로 시작
// Pascal Expression 파스칼 표기법 사용
// 상수의 이름은 대문자. 단어 사이는 ‘_’

//선언 = 실제 값으로 초기화 :: 할당


class Student {
  void eatApple(Apple apple){
    System.out.println(apple + "먹다");
  }
}

class Apple {
  @Override
  public String toString() {
    return "사과";
  }
}

// 단축키
// shift + enter : 자리에서 엔터
//ctrl + shift + enter:자동 중괄호 생성
//ctrl + alt + L :자동 정렬
//alt + shift + f10 : run
//ctrl + / : 주석
//ctrl + d : 줄복사
//shift + f6 :파일명 바꾸기