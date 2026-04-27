package p13Database.ui;

import p13Database.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class FrmMain extends FrmBasic{
  private JPanel pnlNorth, pnlCenter, pnlSouth;
  public FrmMain() throws HeadlessException {
    super("회원 관리 :: " +
            MainController.getInstance().getSession().getName()
            +"님 환영합니다.",
        500, 400);
  }

  @Override
  public void init() {
    pnlNorth = new JPanel();
    pnlCenter = new JPanel();
    pnlSouth = new JPanel();
  }

  @Override
  public void arrange() {

  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
