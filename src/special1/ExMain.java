package special1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class ExMain {
  public static void main(String[] args) {
//    Item i1 = new Item();
//    i1.setNo(10l);
//    System.out.println(i1.getNo());
    List<Item> list = new ArrayList<>();
    System.out.println("======= Item 테이블 :: 번호,제목,이미지,작성자,등록일,수정일======");
    for (int i = 0; i < 10; i++) {
      list.add(new Item(Long.valueOf(i), "title" + i, "imgName", "작성자", LocalDateTime.now(), LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(list.get(i));
    }
    System.out.println();

    System.out.println("======= Writer 테이블 :: 번호,작성자,아이디,비번======");
    List<Writer> wlist = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      wlist.add(new Writer(i, "작성자" + i, "user" + i, "1", LocalDateTime.now(), LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(wlist.get(i));
    }
    System.out.println();
//product :: pno,name.regDate,modDate

    System.out.println("======= Product 테이블 :: 번호,상품명,상품갯수,등록일,수정일======");
    List<Product> pdlist = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      pdlist.add(new Product(i,"상품명"+i,i,LocalDateTime.now(),LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(pdlist.get(i));
    }
    System.out.println();

    System.out.println("======= Purchase 테이블 ::번호,작성자,구매상품갯수,등록일,수정일 ======");
    List<Purchase> prlist = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      prlist.add(new Purchase(i,"작성자"+i,"상품명"+i,i,LocalDateTime.now(),LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(prlist.get(i));
    }
    System.out.println();



  }
}

//Basic : regDate,modDate
class Basic {
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return String.format("%s / %s",regDate.format(formatter),modDate.format(formatter));
  }

  public Basic(LocalDateTime regDate, LocalDateTime modDate) {
    this.regDate = regDate;
    this.modDate = modDate;
  }

  public LocalDateTime getRegDate() {return regDate;}
  public void setRegDate(LocalDateTime regDate) {this.regDate = regDate;}

  public LocalDateTime getModDate() {return modDate;}
  public void setModDate(LocalDateTime modDate) {this.modDate = modDate;}
}

//Item :: no,title,imgName,writer
class Item extends Basic{
  private Long no;
  private String title;
  private String imgName;
  private String writer;

  @Override
  public String toString() {
    return String.format("%d / %s / %s / %s / %s" , no, title,imgName,writer,super.toString());
  }

  public Item (Long no, String title, String imgName, String writer, LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate,modDate);
    this.no = no;
    this.title = title;
    this.imgName = imgName;
    this.writer = writer;
  }

  public Long getNo() {return no;}
  public void setNo(Long no) {this.no = no;}

  public String getTitle() {return title;}
  public void setTitle(String title) {this.title = title;}

  public String getImgName() {return imgName;}
  public void setImgName(String imgName) {this.imgName = imgName;}

  public String getWriter() {return writer;}
  public void setWriter(String writer) {this.writer = writer;}

}

//Writer :: wno,name,id,pass,regDate,modDate
class Writer extends Basic{
  private int wno;
  private String name;
  private String id;
  private String pass;

  @Override
  public String toString() {
    return String.format("번호:%d 이름:%s 아이디:%s 비밀번호:%s",wno,name,id,pass);
  }

  public Writer(int wno, String name, String id, String pass, LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate,modDate);
    this.wno = wno;
    this.name = name;
    this.id = id;
    this.pass = pass;

  }

  public int getWno() {return wno;}
  public void setWno(int wno) {this.wno = wno;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getId() {return id;}
  public void setId(String id) {this.id = id;}

  public String getPass() {return pass;}
  public void setPass(String pass) {this.pass = pass;}

}


//product :: pno,pname,countpd,regDate,modDate
class Product extends Basic {
  private int pno;
  private String pname;
  private int countpd;

  public Product( int pno, String pname,int countpd,LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate, modDate);
    this.pno = pno;
    this.pname = pname;
    this.countpd = countpd;
  }

  @Override
  public String toString() {
    return String.format("%d / %s / %d / %s ",pno,pname,countpd,super.toString());
  }

  public int getPno() {return pno;}
  public void setPno(int pno) {this.pno = pno;}

  public String getPname() {return pname;}
  public void setPname(String name) {this.pname = name;}

  public int getCountpd(){return countpd;}
  public void setCountpd(int countpd){this.countpd =countpd;}
}


//purchase :: puno,writer,name.regDate,modDate
class Purchase extends Basic {
  private int puno;
  private String writer;
  private String name;
  private int countpr;

  @Override
  public String toString() {
    return String.format("%d/ %s / %s / %d /%s",puno,writer,name,countpr,super.toString());
  }

  public Purchase(int puno, String writer, String name,int countpr, LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate, modDate);
    this.puno = puno;
    this.writer = writer;
    this.name = name;
    this.countpr = countpr;
  }

  public int getPuno() {return puno;}
  public void setPuno(int puno) {this.puno = puno;}

  public String getWriter() {return writer;}
  public void setWriter(String writer) {this.writer = writer;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int getCountpr() {return countpr;}
  public void setCountpr(int countpr){this.countpr = countpr;}
}