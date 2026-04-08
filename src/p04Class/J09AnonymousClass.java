package p04Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class J09AnonymousClass {
  public static void main(String[] args) {
    // interface를 사용하는 방법
    //1. 인터페이스를 implements로 사용
    //2. 익명클래스로 사용
    new GeneralClass();// instance 생성만 하고 끝남(익명개체 아님)
    new IAnonymous() { // interface를 instance 만들고 끝남, 익명객체임
      @Override
      public void youCanDoIt() {

      }
    };
    //익명객체가 인터페이스로 형변환(Flyable flyable = new Bat())
    IAnonymous iAnonymous = new IAnonymous() {
      @Override
      public void youCanDoIt() {

      }
    };
    // 익명 객체가 클래스로 형변환 안됨(상속, interface 관계 아님)
//    GeneralClass generalClass=new IAnonymous(){
//      @Override
//      public void youCanDoIt() {
//
//      }
//    };
    new MyFrame();
  }
}

interface IAnonymous {
  void youCanDoIt();
}

//1. 인터페이스를 implements로 사용
class GeneralClass implements IAnonymous {
  @Override
  public void youCanDoIt() {
    System.out.println("doit");
  }
}

class MyFrame extends JFrame {
  public MyFrame() throws HeadlessException {
    setSize(300, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("My Frame");
    setLocationRelativeTo(this); //화면 가운데
    JButton btn = new JButton("확인");
    //interface를 임플리먼트한 클래스르 정의 후 사용
    class BtnListener implements  ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    }
    btn.addActionListener(new BtnListener()); //형변환(익명객체 -> 인터페이스)
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"hello");
      }
    });
    add(btn);
    setVisible(true);
  }
}