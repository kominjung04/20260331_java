package p10IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class J05Serializable {
  public static void main(String[] args) {
    User u1 = new User("홍길동",10);
    User u2 = new User("이도",20);
    System.out.println(u1);
    System.out.println(u2);
    List<User> list = new ArrayList<>();
    list.add(u1);
    list.add(u2);

    String exportFile = "info.ser";
    // 1.  인스턴스를 입출력 스트림으로 export
    try(
        FileOutputStream fos = new FileOutputStream(exportFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        ){
      oos.writeObject(u1);
      oos.writeObject(u2);
      oos.writeObject(list);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //2.export된 Serializable file을 다시 인스턴스로 만듦
    try(
        FileInputStream fis = new FileInputStream(exportFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
    ){
      User get1 = (User) ois.readObject();
      User get2 = (User)ois.readObject();
      ArrayList<User> get3 = (ArrayList<User>)ois.readObject();
      System.out.println(get1);
      System.out.println(get2);
      System.out.println(get3);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

// 인스턴스를 입출력 할 경우 해당 객체는 반드시Serializable 구현
class User implements Serializable {
  private String name;
  private int age;

  @Override
  public String toString() {
    return String.format("%s / %d",name,age);
  }

  public User() {
    this("unknow",20); //this() 현재 생성자를 가르킴
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  public int getAge() {return age;}
  public void setAge(int age) {this.age = age;}

}
