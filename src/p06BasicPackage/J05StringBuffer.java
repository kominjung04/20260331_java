package p06BasicPackage;

public class J05StringBuffer {
  public static void main(String[] args) {
    System.out.println("======== String ========");
    String str = "hello";
    System.out.println(str.hashCode());
    str += " world";
    System.out.println(str.hashCode());

    System.out.println("======== StringBuffer ========");
    // 주어진 텍스트가 가변적이며 빈번할 경우
    StringBuffer sb = new StringBuffer("hello");
    System.out.println(sb.hashCode());
    sb.append(" world");
    System.out.println(sb.hashCode());
    System.out.println(sb.length());
    System.out.println(sb.capacity());
    System.out.println(sb.delete(5,6));
    System.out.println(sb.insert(5, " "));
    System.out.println(sb.reverse());

    // StringBuffer 클래스를 언제 사용하느냐? => 주어진 텍스트가 가변적일 경우
    long startTime = System.nanoTime();
    StringBuffer sb2 = new StringBuffer();
    for (int i = 0; i < 100000; i++) {
      sb2.append("Java ");
    }
    long endTime = System.nanoTime();
    System.out.println((endTime - startTime) / 1_000_000_000.0);

    // StringBuilder 가변적인데 변화가 매우 빈번할 경우
    StringBuilder builder = new StringBuilder();
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      builder.append("Java ");
    }
    endTime = System.currentTimeMillis();
    System.out.println((endTime - startTime) / 1_000.0);
  }
}
