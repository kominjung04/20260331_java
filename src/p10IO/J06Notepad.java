package p10IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class J06Notepad {
  public static void main(String[] args) {
    new MyFrame();

  }
}

class MyFrame extends JFrame {
  private JMenuBar menuBar;
  private JTextArea textArea;
  private JScrollPane sp;
  private JMenu menuF, menuE, menuO, menuV, menuH;
  private JMenuItem miNew, miOpen, miSave, miExit, miInfo;
  private JFileChooser fc;

  public MyFrame() throws HeadlessException {
    // 화면 초기화
    fc = new JFileChooser();
    miNew = new JMenuItem("새로만들기(N)");
    miOpen = new JMenuItem("열기(O)");
    miSave = new JMenuItem("저장(S)");
    miExit = new JMenuItem("끝내기(X)");
    miInfo = new JMenuItem("정보(A)");
    menuF = new JMenu("파일(F)");
    menuE = new JMenu("편집(E)");
    menuO = new JMenu("서식(O)");
    menuV = new JMenu("보기(V)");
    menuH = new JMenu("도움말(H)");
    menuBar = new JMenuBar();
    // 이벤트 처리
    miOpen.addActionListener(e -> {
      // 글의 내용이 있을 경우
      if (!textArea.getText().trim().equals("")) {
        int result = JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
        //저장을 할 경우
        if (result == JOptionPane.YES_OPTION) fileSave();
        //저장을 하지 않을 경우
        else textArea.setText("");
      }
      fileOpen();
    });
    miSave.addActionListener(e -> {fileSave();});
    miNew.addActionListener(e -> {fileNew();});
    miExit.addActionListener(e -> {fileExit();});
    miInfo.addActionListener(e -> {new InfoDialog(this,true);});
    // 화면 구성
    menuF.add(miNew);
    menuF.add(miOpen);
    menuF.add(miSave);
    menuF.add(miExit);
    menuF.add(miInfo);

    menuBar.add(menuF);
    menuBar.add(menuE);
    menuBar.add(menuO);
    menuBar.add(menuV);
    menuBar.add(menuH);

    textArea = new JTextArea();
    setJMenuBar(menuBar);
    sp = new JScrollPane(textArea);
    add(sp);


    setSize(500, 300);
    setTitle("메모장 ver 0.5");
    setLocationRelativeTo(this);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void fileOpen() {
    int ret = fc.showOpenDialog(miOpen);
    if (ret == 0) {
      String selectedFile = fc.getSelectedFile().toString();
      System.out.println(selectedFile);
      try (FileReader fr = new FileReader(selectedFile);
           BufferedReader br = new BufferedReader(fr);) {
        textArea.setText("");
        int data;
        while ((data = br.read()) != -1) {
          textArea.append(String.valueOf((char) data));
        }
        ;
      } catch (FileNotFoundException ex) {
        throw new RuntimeException(ex);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  private void fileSave() {
    int ret = fc.showSaveDialog(miSave);
    if (ret == 0) {
      String saveFileName = fc.getSelectedFile().toString();
      try (FileWriter fw = new FileWriter(saveFileName);
           BufferedWriter bw = new BufferedWriter(fw);
      ) {
        bw.write(textArea.getText());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void fileNew() {
    if (!textArea.getText().trim().equals("")) {
      fileSave();
      textArea.setText("");
    }
  }

  private void fileExit() {
    if (!textArea.getText().trim().equals("")) {fileSave();}
    dispose();

  }


}

class InfoDialog extends JDialog{
  public InfoDialog(Frame owner, boolean modal) {
    super(owner, modal);
    JLabel lbInfo = new JLabel("배경");
    JLabel lbImg = new JLabel(new ImageIcon("./Image/배경.jpg"));
    add(lbInfo,"North");
    add(lbImg,"Center");
    setTitle("정보");
    setSize(300,100);
    setLocationRelativeTo(this);
    setVisible(true);
  }
}