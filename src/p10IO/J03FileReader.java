package p10IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class J03FileReader {
  public static <str> void main(String[] args) {
    // char 기반 스트림 Reader, Writer
    String fileName = "test.txt";
    String content = """
        Hello World!
        안녕 세상아!
        """;

    try (
        //byte기반 주스트림,순서 중요 쓰가 먼저이면 쓰기부터 초기화
        FileOutputStream fos = new FileOutputStream(fileName);
        FileInputStream fis = new FileInputStream(fileName);

        //char기반 주스트림
        FileWriter fw = new FileWriter(fileName);
        FileReader fr = new FileReader(fileName);
    ) {
      //File저장
      fos.write(content.getBytes(StandardCharsets.UTF_8));
      fw.write(content);

      int data;
      while ((data = fis.read()) != -1) {
        System.out.print((char) data);
      }
      while ((data = fr.read()) != -1) { //char기반 글자 안깨짐
        System.out.print((char) data);
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
