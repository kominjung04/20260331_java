package p04Class;

public class J04classCastingEx {
  public static void main(String[] args) {
    //Tv,Computer,Audio 인스턴스를 만들고,
    //Buyer가 tv,computer,audio를 구매하도록 한다.이때 돈이 차감된다
    Audio audio = new Audio();
  }
}

//class 4개(Buyer,Tv,Computer,Audio)1000,300,400,300
//Buyer : money,method:buy
//Tv,Computer,Audio (Name,Price)
class Buyer {
  int money = 1000;
  void buy(){

  }
}

class Tv extends Buyer{
  String name = "Tv";
  int price = 300;
}

class Computer extends Buyer{
  String name = "Computer";
  int price = 400;
}

class Audio extends Buyer{
  public Audio(){
//    super("Audio",300);
  }
//  String name = "Audio";
//  int price = 300;
}

