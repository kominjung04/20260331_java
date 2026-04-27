package p13Database.controller;

import p13Database.ui.FrmJoin;
import p13Database.ui.FrmLogin;
import p13Database.ui.FrmMain;
import p13Database.ui.FrmModify;
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

  // MainController에서 관리하는 속성: 다른 인스턴스에서도 접근이 가능해야함.
  private MemberVO session; // 로그인한 정보를 가지는 객체: 세션
  private HashMap<String,Object> map = null;

  public MemberVO getSession(){return session;}
  public void setSession(MemberVO session){this.session = session;}
  public HashMap<String, Object> getMap() {return map;}
  public void setMap(HashMap<String, Object> map) {this.map = map;}


  // 요청에 대한 처리 메서드
  public void dispatch(String request, HashMap<String,Object> map) {
    this.map = map;
    if (request.equals("Join")) {
      new FrmJoin();
    } else if (request.equals("Main")) {
      new FrmMain();
    } else if (request.equals("Modify")) {
      new FrmModify();
    } else {
      new FrmLogin();
    }

  }

}
