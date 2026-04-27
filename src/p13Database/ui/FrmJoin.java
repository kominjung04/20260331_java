package p13Database.ui;

import javax.swing.*;
import java.awt.*;

public class FrmJoin extends FrmBasic{
  private JPanel pnlNorth, pnlCenter, pnlSouth;
  public FrmJoin() throws HeadlessException {
    super("회원 가입", 270, 280);
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
