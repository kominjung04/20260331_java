package p12Network;

import java.net.*;
import java.io.*;
import java.util.*;

public class J01TcpipMultiChatServer {
  public static void main(String args[]) {
    new J01TcpipMultiChatServer().start(); //new로 초기화
  }

  HashMap clients;

  J01TcpipMultiChatServer() { //생성자
    //접속자의 목록을 담기 위한 Map을 선언
    clients = new HashMap();
    Collections.synchronizedMap(clients); //동기화 지정
  }

  public void start() {
    ServerSocket serverSocket = null; //다중 사용을 위한 전체소켓
    Socket socket = null;// 일대일 사용을 위한 개별 소켓

    try {
      serverSocket = new ServerSocket(7777);
      System.out.println("Server started...");

      while (true) { //무한반복:서버 끄기 전까지 돌아감
        // 누군가 접속을 하게 되면 socket을 생성하고
        socket = serverSocket.accept(); //서버 접속 시 소켓 생성
        System.out.println("Connected from ["
            + socket.getInetAddress() + ":" + socket.getPort() + "]");//소켓 id와 port가 출력
        // 사용자당 각각의 thread를 생성
        ServerReceiver thread = new ServerReceiver(socket);//접속마다 스레드가 만들어짐
        thread.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // start()

  // 메세지를 모두에게 보내줄 때 호출
  void sendToAll(String msg) {
    Iterator it = clients.keySet().iterator();

    while (it.hasNext()) {
      try {
        DataOutputStream out = (DataOutputStream) clients.get(it.next());
        out.writeUTF(msg);
      } catch (IOException e) {
      }
    } // while
  } // sendToAll

  class ServerReceiver extends Thread { //멤버변수와 같음
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    ServerReceiver(Socket socket) {
      this.socket = socket;
      try {
        //socket으로 부터 입출력 스트림이 각각 생성
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
      } catch (IOException e) {
      }
    }

    public void run() {
      String name = "";
      try {
        // 처음 입장하면 in으로 처음 받는 메시지가 이름임.
        name = in.readUTF();
        sendToAll("#" + name + " 님이 입장하셨습니다.");

        clients.put(name, out);//(이름,출력스트림)
        System.out.println("현재 접속자수: " + clients.size());
        // 사용자가 계속적으로 메시지를 보낼 수 있기에 보낼 때 모두에게 전송
        while (in != null) {
          sendToAll(in.readUTF());
        }
      } catch (IOException e) {
        // ignore
      } finally {
        sendToAll("#" + name + " 님이 나가셨습니다.");
        clients.remove(name); //접속 해제시 hashmap에서 해당 key 삭제
        System.out.println("Terminated from [" + socket.getInetAddress() + ":" + socket.getPort() + "]");
        System.out.println("현재 접속자수: " + clients.size());
      } // try
    } // run
  } // ReceiverThread
} // class