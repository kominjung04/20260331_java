package p13Database;

import p13Database.controller.MainController;
import p13Database.ui.FrmLogin;

public class MainStart {
  public static void main(String[] args) {
    MainController.getInstance().dispatch("Login",null);//controller에서 작업
  }
}
