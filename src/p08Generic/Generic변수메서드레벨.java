package p08Generic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Generic변수메서드레벨 {
  //var value = 10; //var는 반드시 지역변수에서만 사용
  public static void main(String[] args) {
    // Generic 사용의 이점: 형 변환 생략 가능, 타입의 안정성 도모

    //변수 레벨 제네릭 사용
    //T vlaue = 10;
    //var val; //var는 반드시 초기화까지 해야 선언할 수 있음
    var num = 100; // 컴파일 시점에 타입 지정
    var list = new ArrayList<Integer>();
    var map = new HashMap<Integer,String>();
    List<String> strList = new ArrayList<>();

    var str = identity("hello");
    System.out.println(str);
    var str2 = identity(true);
  }

  //2. 메서드 레벨 제네릭 사용 T::type
  public static <T> T identity(T value) { //value값에 따라 리턴타입이 바뀜
    return value;
  }

//  void buy(Product p){//자 -> 부 (형변환)
//    if(money < p.getPrice()) System.out.println("구매 불가");
//    else{money -= p.getPrice();
//      System.out.println("남은돈 : " + money);
//      list[cnt++] = p.getName();
//    }



}
