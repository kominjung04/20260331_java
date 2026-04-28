package p13Database.ui;

import p13Database.controller.MainController;
import p13Database.dao.DAOMember;
import p13Database.vo.MemberVO;

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
      //유효성 검사
      String id = tfId.getText().trim();
      String pass = new String(pfPass.getPassword()).trim();

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
      System.out.println(id + "/" + pass);
      MemberVO vo = new DAOMember().checkId(id);
      //MemberVO vo = new MemberVO(1L,"admin","1","관리자","010-1111-1111");
      if (vo != null) { // 그런 ID가 DB로부터 들고 왔으니 비밀번호를 비교
        if (vo.getPass().equals(pass)) {
          //아이디,비번이 정확할 경우 세션 저장
          MainController.getInstance().setSession(vo);
          new FrmMain(); dispose();
        }else{
          JOptionPane.showMessageDialog(null,"ID,비밀번호가 올바르지 않습니다");
        }
      } else {
        JOptionPane.showMessageDialog(null,"ID를 확인하세요");
      }


    });

    btnJoin.addActionListener(e -> {
      new FrmJoin(); dispose();
    });
  }

  @Override
  public void arrange() {
    pnlNorth.add(lbId);
    pnlNorth.add(tfId);
    pnlCenter.add(lbPass);
    pnlCenter.add(pfPass);
    pnlSouth.add(btnLogin);
    pnlSouth.add(btnJoin);
    add(pnlNorth,"North");
    add(pnlCenter,"Center");
    add(pnlSouth,"South");

  }

  @Override
  public void inflate() {
    super.inflate();
  }

}
