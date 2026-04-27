package p13Database.ui;

import p13Database.controller.MainController;
import p13Database.dao.DAOMember;
import p13Database.vo.MemberVO;

import javax.swing.*;
import java.awt.*;

public class FrmJoin extends FrmBasic{
  private JPanel pnlCenter, pnlSouth;
  private JTextField tfId,tfName,tfMobile;
  private JPasswordField pfPass,pfRePass;
  private JButton btnJoin, btnlogin;
  private JLabel[] lbArr;
  private String[] strArr;

  public FrmJoin() throws HeadlessException {
    super("회원 가입", 270, 280);
  }

  @Override
  public void init() {
    pnlCenter = new JPanel(new GridLayout(5,2,10,10));
    pnlSouth = new JPanel();
    strArr  = new String[]{"ID","Password","Repass","Name","Mobile"};
    lbArr = new JLabel[5];
    for (int i = 0; i < lbArr.length; i++) {
      lbArr[i] = new JLabel(strArr[i]);
    }
    tfId = new JTextField();
    tfName = new JTextField();
    tfMobile = new JTextField();
    pfPass = new JPasswordField();
    pfRePass = new JPasswordField();
    btnJoin = new JButton("등록");
    btnlogin = new JButton("로그인");
    btnJoin.addActionListener(e->{
      //유효성검사
      String id = tfId.getText().trim();
      String pass = new String(pfPass.getPassword()).trim();
      String repass = new String(pfRePass.getPassword()).trim();

      if (tfId.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(null,"ID를 입력해주세요");
        tfId.setText("");
        tfId.requestFocus();
      }
      if (new String(pfPass.getPassword()).trim().equals("")) {
        JOptionPane.showMessageDialog(null,"password를 확인해주세요");
        pfPass.setText("");
        pfPass.requestFocus();
        return;
      }
      if(!new String(pfRePass.getPassword()).trim().equals(new String(pfPass.getPassword()).trim())){
        JOptionPane.showMessageDialog(null,"password가 다릅니다.");
        pfRePass.setText("");
        pfRePass.requestFocus();
        return;
      }
      System.out.println(id + "/" + pass + "/" +repass);

      Long mno = new DAOMember().insertMembersMno(new MemberVO(
          null, //새로 회원가입을 할 경우 mno를 알지 못하기 때문
          tfId.getText(),new String(pfPass.getPassword()),
          tfName.getText(),tfMobile.getText()
      ));
      if ( mno != null && mno > 0) {
        JOptionPane.showMessageDialog(null,mno + "번 회원님이 등록되었습니다");
        tfId.setText("");
        pfPass.setText("");
        pfRePass.setText("");
        tfName.setText("");
        tfMobile.setText("");
      }

    });
    btnlogin.addActionListener(e->{
      dispose();
      MainController.getInstance().dispatch("Login",null);
    });
  }

  @Override
  public void arrange() {
    pnlCenter.add(lbArr[0]);pnlCenter.add(tfId);
    pnlCenter.add(lbArr[1]);pnlCenter.add(pfPass);
    pnlCenter.add(lbArr[2]);pnlCenter.add(pfRePass);
    pnlCenter.add(lbArr[3]);pnlCenter.add(tfName);
    pnlCenter.add(lbArr[4]);pnlCenter.add(tfMobile);
    add(pnlCenter,"Center");
    pnlSouth.add(btnJoin);pnlSouth.add(btnlogin);
    add(pnlSouth,"South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
