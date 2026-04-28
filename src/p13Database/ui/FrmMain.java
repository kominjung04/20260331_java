package p13Database.ui;

import p13Database.controller.MainController;
import p13Database.dao.DAOMember;
import p13Database.vo.MemberVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class FrmMain extends FrmBasic{
  private JTable tbl;
  private JLabel lb;
  private DefaultTableModel model;
  private JScrollPane scp;
  private JPanel pnlSouth;
  private JButton btnModify, btnDelete, btnClose;

  public FrmMain() throws HeadlessException {
    super("회원 관리 :: " +
            MainController.getInstance().getSession().getName()
            +"님 환영합니다.",
        500, 400);
  }
  public void setTableModel(List<MemberVO> list){
    model.setRowCount(0); //이 메서드가 호출 될 때 마다 기존꺼 지우고 재호출
    for (int i = 0; i < list.size(); i++) {
      MemberVO vo = list.get(i);
      model.addRow(new String[]{
          vo.getMno()+"",vo.getId()+"",vo.getPass()+"",vo.getName()+"",
          vo.getMobile()
      });
    }
    tbl.setModel(model);
  }

  @Override
  public void init() {
    lb = new JLabel("Member List");
    lb.setFont(new Font("consolas",Font.PLAIN,20));
    lb.setHorizontalAlignment(JLabel.CENTER);
    lb.setOpaque(true);
    lb.setBackground(Color.PINK);
    lb.setBorder(new EmptyBorder(20,10,5,10));
    tbl = new JTable();
    model = new DefaultTableModel(new String[]{"No","ID","Pass","Name","Mobile"},0);
    tbl.setModel(model);
    setTableModel(new DAOMember().getListMembers());
    scp = new JScrollPane(tbl);
    pnlSouth = new JPanel();
    btnModify = new JButton("수정");
    btnDelete= new JButton("삭제");
    btnClose = new JButton("닫기");
    btnModify.addActionListener(e->{
      int selectedRow = tbl.getSelectedRow();
      if (selectedRow == -1) {
      JOptionPane.showMessageDialog(null,"회원을 먼저 선택후 버튼을 누르세오");
      return;
      }
      //선택된 행으로 부터 MemberVO의 인스턴스 생성
      MemberVO vo = new MemberVO(
        Long.parseLong(model.getValueAt(selectedRow,0).toString()),
          model.getValueAt(selectedRow,1).toString(),
          model.getValueAt(selectedRow,2).toString(),
          model.getValueAt(selectedRow,3).toString(),
          model.getValueAt(selectedRow,4).toString()
      );
      System.out.println(vo);
      HashMap<String,Object> map = new HashMap<>();
      map.put("vo",vo);
      map.put("frmMain",this);
      MainController.getInstance().dispatch("Modify",map);
    });
    btnDelete.addActionListener(e->{
      //yse 버튼 클릭 시 daomember.delete이용
      int selectedRow = tbl.getSelectedRow();
      if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null,"삭제할 회원번호를 먼저 선택하세요");
        return;
      }
      int confirm = JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","삭제 완료",JOptionPane.YES_NO_OPTION);
      if(confirm == JOptionPane.YES_OPTION){
      Long mno = Long.parseLong(model.getValueAt(tbl.getSelectedRow(), 0).toString());
      new DAOMember().deleteMember(mno);}
      setTableModel(new DAOMember().getListMembers());

    });
    btnClose.addActionListener(e->{new FrmLogin(); dispose();});

  }

  @Override
  public void arrange() {
    add(lb,"North");
    add(scp,"Center");
    pnlSouth.add(btnModify);
    pnlSouth.add(btnDelete);
    pnlSouth.add(btnClose);
    add(pnlSouth,"South");
  }

  @Override
  public void inflate() {
    super.inflate();
  }
}
