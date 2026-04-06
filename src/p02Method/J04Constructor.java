package p02Method;

public class J04Constructor {
  public static void main(String[] args) {
  Student s1 = new Student(); //생성자를 별도로 가지고 있으면 생성자를 생성안함
    s1.setStdNo(1);
    s1.setName("고길동");
    System.out.println(s1.getStdNo());
    System.out.println(s1.getName());
    Student[] students = new Student[13];
    students[0] = new Student(2,"김길동", "010-1234-1234", "a@a.a");
    students[1]=s1;
    students[2]=new Student();
    students[2].setStdNo(3);students[2].setName("박길동");students[2].setMobile("010-1111-3333");
  }
}

class Student{
  private int stdNo;
  String name;
  private String mobile;
  private String email;
  private LocalDate birthday;
  private int stdState = 1; //가입 : 1 , 퇴원 : 0
  //생성자도 메서드의 일종, 생성자도 오버로딩 적용 됨.
  public Student(){} //기본생성자: JVM이 자동 만들어주지만 다른 생성자가 생성시 자동 생성 안됨
  //매개변수가 있는 생성자는 인스턴스 초기화 시 멤버변수들을 초기화 가능

  public Student(int stdNo,String name,String mobile,String email){
    // this.stdNo(prviate int stdNo),stdNo(int stdNo)
    this.stdNo = (stdNo>0)?stdNo : 0;
    this.mobile = mobile;
    this.email = email;
  }
  public int getStdNo() {
    return stdNo;
  }

  public void setStdNo(int stdNo) {
    this.stdNo = stdNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public int getStdState() {
    return stdState;
  }

  public void setStdState(int stdState) {
    this.stdState = stdState;
  }
}

class LocalDate{

}
