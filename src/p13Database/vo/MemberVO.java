package p13Database.vo;

public class MemberVO {
  private Long mno;
  private String id;
  private String pass;
  private String name;
  private String mobile;

  @Override
  public String toString() {
    return String.format("%d / %s / %s / %s / %s",mno,id,pass,name,mobile);
  }

  public MemberVO(Long mno, String id, String pass, String name, String mobile) {
    this.mno = mno;
    this.id = id;
    this.pass = pass;
    this.name = name;
    this.mobile = mobile;
  }


  public Long getMno() {return mno;}
  public void setMno(Long mno) {this.mno = mno;}

  public String getId() {return id;}
  public void setId(String id) {this.id = id;}

  public String getPass() {return pass;}
  public void setPass(String pass) {this.pass = pass;}

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public String getMobile() {return mobile;}
  public void setMobile(String mobile) {this.mobile = mobile;}

}
