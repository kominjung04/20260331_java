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
    list.add(new Item(Long.valueOf(i),"title"+i,"imgName","작성자",LocalDateTime.now(),LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
    System.out.println(list.get(i));
    }

    System.out.println();

    List<Writer> wlist = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
    wlist.add(new Writer(i,"작성자"+i,"user"+i,1,LocalDateTime.now(),LocalDateTime.now()));
    }
    for (int i = 0; i < 10; i++) {
    System.out.println(wlist.get(i));
    }


  }
}

class Item{
  private Long no;
  private String title;
  private String imgName;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  @Override
  public String toString() {
    return String.format("%d / %s",no,title);
  }

  public Item(Long no, String title, String imgName, String writer, LocalDateTime regDate, LocalDateTime modDate){
    this.no = no;
    this.title = title;
    this.imgName = imgName;
    this.writer = writer;
    this.regDate = regDate;
    this.modDate = modDate;
  }
  public Long getNo() {return no;}
  public void setNo(Long no) {this.no = no;}

  public String getTitle() {return title;}
  public void setTitle(String title) {this.title = title;}

  public String getImgName() {return imgName;}
  public void setImgName(String imgName) {this.imgName = imgName;}

  public String getWriter() {return writer;}
  public void setWriter(String writer) {this.writer = writer;}

  public LocalDateTime getRegDate() {return regDate;}
  public void setRegDate(LocalDateTime regDate) {this.regDate = regDate;}

  public LocalDateTime getModDate() {return modDate;}
  public void setModDate(LocalDateTime modDate) {this.modDate = modDate;}


}

class Writer{
  private int wno;
  private String name;
  private String id;
  private int pass;
  LocalDateTime regDate;
  LocalDateTime modDate;

  public Writer(int wno, String name, String id, int pass, LocalDateTime regDate, LocalDateTime modDate) {
    this.wno = wno;
    this.name = name;
    this.id = id;
    this.pass = pass;
    this.regDate = regDate;
    this.modDate = modDate;
  }

  @Override
  public String toString() {
    return String.format("%d / %s / %s ",wno,name,id);
  }

  public int getWno() {return wno;}
  public void setWno(int wno) {this.wno = wno;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getId() {return id;}
  public void setId(String id) {this.id = id;}

  public int getPass() {return pass;}
  public void setPass(int pass) {this.pass = pass;}

  public LocalDateTime getRegDate() {return regDate;}
  public void setRegDate(LocalDateTime regDate) {this.regDate = regDate;}

  public LocalDateTime getModDate() {return modDate;}
  public void setModDate(LocalDateTime modDate) {this.modDate = modDate;}
}

//product,purchase테이블 제작
//basic상속관계
//prduct :: pno,name.regDate,modDate
//purchase :: puno,wirter,name.regDate,modDate