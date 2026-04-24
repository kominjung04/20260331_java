package p12Network;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class J02TcpipMultiChatClient {
  public static void main(String[] args) {
    new MyChat();
  }
}

//class MyChat extends JFrame{
//  private JTextArea textArea;
//  private JScrollPane sp;
//  private JTextField jf;
//  public MyChat() throws HeadlessException {
//    textArea = new JTextArea(); //채팅창
//    jf = new JTextField(); //입력창
//    jf.setPreferredSize(new Dimension(500,50));//채팅창 크기
//    sp = new JScrollPane(textArea);
//    add(sp, BorderLayout.CENTER);
//    add(jf, BorderLayout.SOUTH);
//
//    setSize(500, 700);
//    setTitle("Chat");
//    setLocationRelativeTo(this);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setVisible(true);
//  }
//}
class MyChat extends JFrame{
  JTextArea ta = new JTextArea();
  JScrollPane scp = new JScrollPane(ta);
  JTextField tf = new JTextField();
  String ip = "";
  String id = "";
  DataOutputStream out = null;
  DataInputStream in = null;

  public MyChat() throws HeadlessException {
    //init
    ip = JOptionPane.showInputDialog("Server IP","10.100.105.4");
    if(ip.trim().equals("")) return;
    id = JOptionPane.showInputDialog("당신의 ID를 입력하세요");
    if(id.trim().equals("")) return;
    try {
      Socket socket = new Socket(ip,7777);
      out = new DataOutputStream(socket.getOutputStream());
      new Thread(new Reciver(socket)).start();
      out.writeUTF(id);//접속되자 마자 자신의 입장을 서버로 접속
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //style
    ta.setEditable(false);
    ta.setFont(new Font("맑은고딕",Font.PLAIN,20));
    tf.setFont(new Font("맑은고딕",Font.PLAIN,20));

    //arrange
    add(scp,"Center"); //내부적으로 정의되어 있음 Center,South
    add(tf,"South");

    //event
    tf.addActionListener(e->{
      if(tf.getText().trim().length()>0){
        String msg = tf.getText();
        try {
          out.writeUTF("[" + id + "]" + msg);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        tf.setText("");
      }
    });

    //common
    setSize(500,700);
    setTitle("Chatting Room");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
    setVisible(true);
    tf.requestFocus();

  }

  class Reciver extends Thread {
    DataInputStream in;

    public Reciver(Socket socket) {
      try {
        in = new DataInputStream (socket.getInputStream());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void run() {
      while (in != null){
        try {
          String msg =in.readUTF();
          ta.append(msg + "\n");
          ta.setCaretPosition(ta.getDocument().getLength());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }

  }

}