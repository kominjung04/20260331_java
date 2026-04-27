package p13Database.controller;

import p13Database.ui.FrmJoin;
import p13Database.ui.FrmLogin;
import p13Database.ui.FrmMain;
import p13Database.vo.MemberVO;

import java.util.HashMap;

public class MainController {
  private MainController(){};// new로 인스턴스 생성 불가

  // MainController에 대해서 Singleton 패턴 적용
  private static MainController mainController;
  public static MainController getInstance(){
    if (mainController == null) {//인스턴스 한번만 생성
      mainController = new MainController();
    }
    return mainController;
  }

  private MemberVO session; // 로그인한 정보를 가지는 객체: 세션

  public MemberVO getSession(){return session;}
  public void setSession(MemberVO session){this.session = session;}

  // 요청에 대한 처리 메서드
  public void dispatch(String request, HashMap<String,Object> map) {
    HashMap<String,Object> requestMap = map;
    if (request.equals("Join")) {
      new FrmJoin();
    } else if (request.equals("Main")) {
      new FrmMain();
    } else if (request.equals("Modify")) {
      //new FrmModify();
    } else {
      new FrmLogin();
    }

  }

}
