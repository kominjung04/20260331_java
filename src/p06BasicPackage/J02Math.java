package p06BasicPackage;

public class J02Math {
  public static void main(String[] args) {
    // Math math = new Math(); 생성자가 private
    System.out.println(Math.abs(-10));
    System.out.println(Math.ceil(10.1)+""+Math.ceil(-10.1)); // 절상
    System.out.println(Math.floor(10.6)+""+Math.floor(-10.6)); //절삭
    // round() 리턴타입이 정수
    System.out.println("round(1.2): "+Math.round(1.2));
    System.out.println("round(1.5): "+Math.round(1.5));
    System.out.println("round(-1.2): "+Math.round(-1.2));
    System.out.println("round(-1.5): "+Math.round(-1.5));
    // rint() 리턴타입이 실수, 가장 가까운 실수로 대체, 반올림과 다름
    System.out.println("rint(1.2): "+Math.rint(1.2));
    System.out.println("rint(1.5): "+Math.rint(1.5));
    System.out.println("rint(-1.2): "+Math.rint(-1.2));
    System.out.println("rint(-1.5): "+Math.rint(-1.5));
    System.out.println(Math.random()); // rand >= 0 && rand < 1 실수
    System.out.println(Math.max(10, 20));
    System.out.println(Math.min(10, 20));
    System.out.println("Math.pow(2, 3): "+Math.pow(2, 3)); //2의 3승
    System.out.println("Math.sqrt(16): " + Math.sqrt(16)); //16에 루트씌운 결과
    System.out.println("Math.sin(Math.PI / 2): "+Math.sin(Math.PI / 2));
    System.out.println("Math.cos(0): "+Math.cos(0));
    System.out.println("Math.tan(Math.PI/4): "+Math.tan(Math.PI / 4));
    System.out.println("Math.log(10): "+Math.log(10));
    System.out.println("Math.exp(2): "+Math.exp(2));
    System.out.println("Math.toRadians(180): " + Math.toRadians(180));
    System.out.println("Math.toDegrees(Math.PI: " + Math.toDegrees(Math.PI));
    System.out.println(Math.signum(-10.0));// 음수는 -1.0
    System.out.println(Math.signum(0.0)); // 0은 0
    System.out.println(Math.signum(23.0));// 양수는 1.0
    System.out.println(Math.PI);
    System.out.println(Math.E);
  }
}
