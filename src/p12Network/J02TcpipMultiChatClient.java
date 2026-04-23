package p12Network;

import javax.swing.*;
import java.awt.*;

public class J02TcpipMultiChatClient {
  public static void main(String[] args) {
    new MyChat();
  }
}

class MyChat extends JFrame{
  private JTextArea textArea;
  private JScrollPane sp;
  private JTextField jf;
  public MyChat() throws HeadlessException {
    textArea = new JTextArea(); //채팅창
    jf = new JTextField(); //입력창
    jf.setPreferredSize(new Dimension(500,50));//채팅창 크기
    sp = new JScrollPane(textArea);
    add(sp, BorderLayout.CENTER);
    add(jf, BorderLayout.SOUTH);

    setSize(500, 700);
    setTitle("Chat");
    setLocationRelativeTo(this);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}