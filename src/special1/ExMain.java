package special1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExMain {
  public static void main(String[] args) {
//    Item i1 = new Item();
//    i1.setNo(10l);
//    System.out.println(i1.getNo());
    List<Item> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new Item(Long.valueOf(i), "title" + i, "imgName", "작성자", LocalDateTime.now(), LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(list.get(i));
    }

    System.out.println();

    List<Writer> wlist = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      wlist.add(new Writer(i, "작성자" + i, "user" + i, 1, LocalDateTime.now(), LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(wlist.get(i));
    }


  }
}
//basic상속관계
class Basic {
  private LocalDateTime regDate;
  private LocalDateTime movDate;

  public Basic(LocalDateTime regDate, LocalDateTime movDate) {
    this.regDate = regDate;
    this.movDate = movDate;
  }

  public LocalDateTime getRegDate() {return regDate;}
  public void setRegDate(LocalDateTime regDate) {this.regDate = regDate;}

  public LocalDateTime getMovDate() {return movDate;}
  public void setMovDate(LocalDateTime movDate) {this.movDate = movDate;}
}


class Item extends Basic{
  private Long no;
  private String title;
  private String imgName;
  private String writer;

  @Override
  public String toString() {
    return String.format("%d / %s", no, title);
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


class Writer extends Basic{
  private int wno;
  private String name;
  private String id;
  private int pass;


  public Writer(int wno, String name, String id, int pass, LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate,modDate);
    this.wno = wno;
    this.name = name;
    this.id = id;
    this.pass = pass;

  }

  @Override
  public String toString() {return String.format("%d / %s / %s ", wno, name, id);}

  public int getWno() {return wno;}
  public void setWno(int wno) {this.wno = wno;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getId() {return id;}
  public void setId(String id) {this.id = id;}

  public int getPass() {return pass;}
  public void setPass(int pass) {this.pass = pass;}

}


//prduct :: pno,name.regDate,modDate
class Prduct extends Basic {
  private int pno;
  private String name;

  public Prduct(LocalDateTime regDate, LocalDateTime modDate, int pno, String name) {
    super(regDate, modDate);
    this.pno = pno;
    this.name = name;
  }

  public int getPno() {return pno;}
  public void setPno(int pno) {this.pno = pno;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
}


//purchase :: puno,wirter,name.regDate,modDate
class Purchase extends Basic {
  private int puno;
  private String wirter;
  private String name;


  public Purchase(int puno, String wirter, String name, LocalDateTime regDate, LocalDateTime modDate) {
    super(regDate, modDate);
    this.puno = puno;
    this.wirter = wirter;
    this.name = name;

  }

  public int getPuno() {return puno;}
  public void setPuno(int puno) {this.puno = puno;}

  public String getWirter() {return wirter;}
  public void setWirter(String wirter) {this.wirter = wirter;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
}