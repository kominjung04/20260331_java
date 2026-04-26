package p13Database.ui;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends FrmBasic{
  private JPanel pnlNorth, pnlCenter, pnlSouth;
  private JLabel lbId, lbPass;
  private JTextField tfId;
  private JPasswordField pfPass;
  private JButton btnLogin, btnJoin;

  public FrmLogin() throws HeadlessException {
    super("Login", 270, 180);
  }

  @Override
  public void init() {
    pnlNorth = new JPanel();
    pnlCenter = new JPanel();
    pnlSouth = new JPanel();
    lbId = new JLabel("ID");
    lbPass = new JLabel("Pass");
    tfId = new JTextField(10);
    pfPass = new JPasswordField(10);
    tfId.setFont(new Font("Consolas", Font.PLAIN, 18));
    pfPass.setFont(new Font("Consolas", Font.PLAIN, 18));
    btnLogin = new JButton("로그인");
    btnJoin = new JButton("가입");
    btnLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
    btnJoin.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
    btnLogin.addActionListener(e -> {

    });
    btnJoin.addActionListener(e -> {

    });
  }

  @Override
  public void arrange() {
    pnlNorth.add(lbId);pnlNorth.add(tfId);
    pnlCenter.add(lbPass);pnlCenter.add(pfPass);
    pnlSouth.add(btnLogin);pnlSouth.add(btnJoin);
    add(pnlNorth, "North");
    add(pnlCenter, "Center");
    add(pnlSouth, "South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
