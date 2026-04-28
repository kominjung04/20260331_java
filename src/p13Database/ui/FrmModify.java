package p13Database.ui;

import p13Database.controller.MainController;
import p13Database.dao.DAOMember;
import p13Database.vo.MemberVO;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.String.valueOf;

public class FrmModify extends FrmBasic{
  private JPanel pnlCenter, pnlSouth;
  private JTextField tfMno,tfId,tfName,tfMobile;
  private JPasswordField pfPass,pfRePass;
  private JButton btnCheck, btnClose;
  private JLabel[] lbArr;
  private String[] strArr;
  private HashMap<String, Object> map = null;
  private MemberVO vo;

  public FrmModify() throws HeadlessException {
    super("회원 수정", 270, 280);
    //MainController의 Map을 가져와서
    vo =(MemberVO) MainController.getInstance().getMap().get("vo");

    if (vo != null) {
      tfMno.setText(String.valueOf(vo.getMno()));
      tfId.setText(vo.getId());
      pfPass.setText(vo.getPass());
      tfName.setText(vo.getName());
      tfMobile.setText(vo.getMobile());

      tfMno.setEditable(false);
      tfId.setEditable(false);
    }

  }

  @Override
  public void init() {
    pnlCenter = new JPanel(new GridLayout(6,2,10,10));
    pnlSouth = new JPanel();
    strArr  = new String[]{"Mno","ID","Password","Repass","Name","Mobile"};
    lbArr = new JLabel[6];
    for (int i = 0; i < lbArr.length; i++) {
      lbArr[i] = new JLabel(strArr[i]);
    }
    tfMno = new JTextField();
    tfId = new JTextField();
    tfName = new JTextField();
    tfMobile = new JTextField();
    pfPass = new JPasswordField();
    pfRePass = new JPasswordField();



    btnCheck = new JButton("확인"); //join -> check
    btnClose = new JButton("닫기"); //login ->close

    btnCheck.addActionListener(e->{
      //유효성검사
      String pass = new String(pfPass.getPassword()).trim();
      String repass = new String(pfRePass.getPassword()).trim();

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

      vo.setPass(pass);
      vo.setName(tfName.getText());
      vo.setMobile(tfMobile.getText());

      boolean result = new DAOMember().modifyMembers(vo);

      if(result){
        JOptionPane.showMessageDialog(null, "수정 완료");
        FrmMain frmMain = (FrmMain) MainController.getInstance().getMap().get("frmMain"); //frm객체 가져오기

        frmMain.setTableModel(new DAOMember().getListMembers()); //다시 테이블 생성
      } else {
        JOptionPane.showMessageDialog(null, "수정 실패");
      }

    });

    btnClose.addActionListener(e->{
      dispose();
    });
  }

  @Override
  public void arrange() {
    pnlCenter.add(lbArr[0]);pnlCenter.add(tfMno);
    pnlCenter.add(lbArr[1]);pnlCenter.add(tfId);
    pnlCenter.add(lbArr[2]);pnlCenter.add(pfPass);
    pnlCenter.add(lbArr[3]);pnlCenter.add(pfRePass);
    pnlCenter.add(lbArr[4]);pnlCenter.add(tfName);
    pnlCenter.add(lbArr[5]);pnlCenter.add(tfMobile);
    add(pnlCenter,"Center");
    pnlSouth.add(btnCheck);pnlSouth.add(btnClose);
    add(pnlSouth,"South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
