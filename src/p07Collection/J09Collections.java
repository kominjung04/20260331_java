package p07Collection;

import java.util.*;

public class J09Collections {
  public static void main(String[] args) {
    List<Rich> list = new ArrayList<>();
    Rich[]arr = new Rich[4];
    arr[0]= new Rich("일런 머스크",1,100,2000,3000);
    Rich rc = new Rich("이부자",1,100,2000,3000);
    Rich rc2 = new Rich("김부자",2,150,3000,2000);
    Rich rc3 = new Rich("박부자",3,200,1050,1000);
    Rich rc4 = new Rich("강부자",4,50,4000,2500);
    list.add(rc);
    list.add(rc2);
    list.add(rc3);
    list.add(rc4);
    for(Rich r :list) System.out.println(r);
    System.out.println();

    //총자산(getAsset())이 큰 순서로 정렬
    Collections.sort(list, new Comparator<Rich>() {
      @Override
      public int compare(Rich o1, Rich o2) {
        return o1.getAsset() - o2.getAsset();
      }
    });
    for(Rich r :list) System.out.println(r);

    System.out.println();
    Collections.shuffle(list);
    for(Rich r :list) System.out.println(r);


  }
}

class Rich{
  private String name;
  private int no,cash,real,stock;

  public Rich(String name, int no, int cash, int real, int stock) {
    this.name = name;
    this.no = no;
    this.cash = cash;
    this.real = real;
    this.stock = stock;
  }

  public String getName() {return name;}

  public void setName(String name) {this.name = name;}

  public int getNo() {return no;}

  public void setNo(int no) {this.no = no;}

  public int getCash() {return cash;}

  public void setCash(int cash) {this.cash = cash;}

  public int getReal() {return real;}

  public void setReal(int real) {this.real = real;}

  public int getStock() {return stock;}

  public void setStock(int stock) {this.stock = stock;}

  int getAsset(){//real,stock,cash 합한 값
    return cash + real + stock;
  }

  //이건희/1/총금액 문자열
  @Override
  public String toString() {
    return name + "/" + no + "/" +getAsset();
  }
}