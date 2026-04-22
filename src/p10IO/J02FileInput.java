package p10IO;

import java.io.*;

public interface J02FileInput {
  public static void main(String[] args) {
    //파일 오픈을 위한 변수 선언
    FileInputStream fis = null; // 주스트림
    InputStreamReader reader = null; //보조스트림
    BufferedReader br = null; //보조 스트림
    String str = "src//p10IO//J02FileInput.java"; // 파일 경로
    try {
      //스트림 초기화
      fis = new FileInputStream(str);
      reader = new InputStreamReader(fis);
      br = new BufferedReader(reader);
      //파일 읽어드리다
      int data;
      while ((data=br.read())!=-1){
        System.out.print((char)data);
      }
    }catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }finally {
      try {
        //다 일고 난뒤 스트림 닫기
        br.close();
        reader.close();
        fis.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    //tryWithResource
    try (
        FileInputStream fis2 = new FileInputStream(str);
        InputStreamReader reader2 = new InputStreamReader(fis2);
        BufferedReader br2 = new BufferedReader(reader2);
    ) {
      int data;
      while ((data = br2.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }





  }
}
