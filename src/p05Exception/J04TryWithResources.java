package p05Exception;

import java.io.*;

public class J04TryWithResources {
  public static void main(String[] args) {
    FileInputStream fis = null;
    InputStreamReader isr = null;

    String filePath = ".\\src\\p05Exception\\J04TryWithResources.java";

    try {
      fis = new FileInputStream(filePath);
      isr = new InputStreamReader(fis,"UTF-8");
      int data = 0;
      while ((data = isr.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        isr.close();
        fis.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    try (
        //복수 문장 허용
        FileInputStream fis2 = new FileInputStream(filePath);
        InputStreamReader isr2 = new InputStreamReader(fis2,"UTF-8");
    ) {
      fis = new FileInputStream(filePath);
      int data = 0;
      while ((data = isr.read()) != -1) {
        System.out.print((char) data);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }


  }
}

