package p04Class;

import java.util.Arrays;

public class J04classCastingEx {
  public static void main(String[] args) {
    //Tv,Computer,Audio 인스턴스를 만들고,
    //Buyer가 tv,computer,audio를 구매하도록 한다.이때 돈이 차감된다
    Buyer buyer = new Buyer();
    Tv tv = new Tv();
    Computer com = new Computer();
    Audio aud = new Audio();
    buyer.buy(tv);
    buyer.buy(com);
    buyer.buy(aud);
    buyer.buy(aud);
    System.out.println("산 목록: " + Arrays.toString(buyer.getList()));

//    buyer.buyTv(new Tv());
//    buyer.buyCom(new Computer());
//    buyer.buyAud(new Audio());
//    buyer.buyTv(new Tv());
    //buyer.buyAud(new Audio("Audio",300) //

  }
}

//class 4개(Buyer,Tv,Computer,Audio)1000,300,400,300
//Buyer : money,method:buy
//Tv,Computer,Audio (Name,Price)
class Buyer {
  private int money = 1000;
  public int getMoney() {return money;}
  private int cnt =0;
  private String[] list = new String[3];

  public String[] getList() {return list;}

  void buy(Product p){//자 -> 부 (형변환)
    if(money < p.getPrice()) System.out.println("구매 불가");
    else{money -= p.getPrice();
      System.out.println("남은돈 : " + money);
      list[cnt++] = p.getName();
    }
  }
//  void buy(Computer com){
//    if(money < com.getPrice()) System.out.println("구매 불가");
//    else {money -= com.getPrice();
//    System.out.println("남은돈 : " + money);}
//
//  }
//  void buy(Audio aud){
//    if(money < aud.getPrice()) System.out.println("구매불가");
//    else {money -= aud.getPrice();
//      System.out.println("남은돈 : " + money);}
//
//  }

//  void buyTv(Tv tv){
//    if(money<tv.price) System.out.println("돈 부족");
//    else{ money -= tv.price;
//    System.out.println("tv구매 " + "남은돈: " + money);}
//  }
//  void buyCom(Computer com){
//    if(money<com.price) System.out.println("돈 부족");
//    else {money -= com.price;
//    System.out.println("com구매 " + "남은돈: " + money);}
//
//  }
//  void buyAud(Audio aud){
//    if(money<aud.price) System.out.println("돈 부족");
//    else {money -= aud.price;
//    System.out.println("aud구매 " + "남은돈: " + money);}
//
//  }

}

class Product{
  private String name;
  private int price;

  //getter,setter를 써서 접근할 수 있게 만들기
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int getPrice() {return price;}
  public void setPrice(int price) {this.price = price;}

  public Product(String name, int price){
    this.name = name;
    this.price = price;
  }
}

class Tv extends Product{
  public Tv(){
  super("Tv",300);
  }
//  String name = "Tv";
//  int price = 300;
}

class Computer extends Product{
  public Computer() {
    super("computer", 400);
  }
//  String name = "Computer";
//  int price = 400;
}

class Audio extends Product{
  public Audio(){ //값이 class내에 설정
  super("Audio",300);
  }
  //  String name = "Audio";
  //  int price = 300;
}

//class Audio extends Product{
//  public Audio(String name,int price){ //값을 main에 직접 전달
//    super();
//  }
//  //  String name = "Audio";
//  //  int price = 300;
//}

