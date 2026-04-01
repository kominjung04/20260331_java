package p02Method;

import java.sql.SQLOutput;

public class J03Gettersetter {
  public static void main(String[] args) {
    Tv tv = new Tv();
    tv.power();
  }
}

class Tv{
  private boolean power;
  int channel;
  int voulum;

  public boolean isPower(){
  return power;
  }

  public int getChannel(int channel){
    return channel;
  }

  public int getVoulum(int voulum){
    return voulum;
  }

  public void power(){
    power = power; //자기자신이 속한 클래스를 가르킴
    System.out.println(power?"켜졌습니다":"꺼졌습니다.");
  }

  public void setChannel(int channel){
    if(channel >= 0 && channel < 1000){
      this.channel = channel;
    }
    System.out.println("채널범위 : 0 ~ 999");
  }

  public void setVoulum(int voulum){
    if(voulum >= 0 && voulum <= 100){
      this.voulum = voulum;
    }
    System.out.println("볼륨의 범위는(0 ~ 100)사이 입니다.");
  }

}
