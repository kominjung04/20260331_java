package p13Database.ui;

import javax.swing.*;
import java.awt.*;

public abstract class FrmBasic extends JFrame {
  private String title;
  private int width,height;

  public FrmBasic(String title,String title1, int width, int height) {
    super(title);
    this.title = title1;
    this.width = width;
    this.height = height;
    init();
    arrange();
    inflate();
  }

  public abstract void init();// 멤버 변수 초기화
  public abstract void arrange(); //창의 디자인
  public void inflate(){
   setTitle(title);
   setSize(width,height);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(this);
   setVisible(true);
  }
}
