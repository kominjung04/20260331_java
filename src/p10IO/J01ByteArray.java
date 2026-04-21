package p10IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class J01ByteArray {
  public static void main(String[] args) {
    // Byte기반 조상클래스는 InputStream,OutputStream

    byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
    byte[] outsrc = null;

    ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    System.out.println(Arrays.toString(inSrc));

    int data;
    while ((data = input.read()) != -1) {
      output.write(data);
    }
    outsrc = output.toByteArray();
    System.out.println(Arrays.toString(outsrc));

    // 입출력의 효율을 높이기 위해 buffer 개념을 적용
    byte[] tmp = new byte[4];//Buffer
    input = new ByteArrayInputStream(inSrc);
    output = new ByteArrayOutputStream();

    while (input.available() > 0) {
      int len = 0;
      try {
        len = input.read(tmp); //읽을 때 tmp만큼만 읽어들임.그리고 길이값이 len
       // output.write(tmp);
        output.write(tmp,0,len);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    outsrc = output.toByteArray();
    System.out.println("tmp: " + Arrays.toString(tmp));
    System.out.println("outSrc: " + Arrays.toString(outsrc));

  }
}
