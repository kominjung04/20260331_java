package p10IO;

import java.io.File;
import java.io.IOException;

public class J04File {
  public static void main(String[] args) {
    //File :: file,folder를 다룰수 있는 객체
    File file = new File(".");

    if (file.exists() && file.isDirectory()) {
      //파일을 문자열 목록으로 들고 오기
      String[] fileStrList = file.list();
      System.out.println("=====fileStrList=====");
      for (int i = 0; i < fileStrList.length; i++) {
        System.out.println(fileStrList[i]);
      }


      //파일 객체 자체를 목록으로 들고 오기
      File[] fileList = file.listFiles();
      System.out.println("=====fileList=====");
      for (int i = 0; i < fileList.length; i++) {
        if (fileList[i].isDirectory()) {
          System.out.println("[" + fileList[i].getName() + "]");
        } else {
          System.out.println(fileList[i].getName());
        }
      }

      System.out.println("=====파일 다루기=====");
      file =new File("test.txt");
      if (file.exists()) {
        try {
          System.out.println("file.getName(): " + file.getName());
          System.out.println("file.getPath(): " + file.getPath()); //상대경로
          System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
          System.out.println("file.getAbsoluteFile(): " + file.getAbsoluteFile());
          // Canonical :: ./, ../를 정리하여 절대경로로 표시
          System.out.println("file.getCanonicalPath(): " + file.getCanonicalPath());
          System.out.println("file.getCanonicalFile(): " + file.getCanonicalFile());
          System.out.println("file.getParent(): " + file.getParent());
        } catch (IOException e) {
        }
      }

      System.out.println("=====Drive 다루기=====");
      String drive;
      double totalSpace, usedSpace, freeSpace, usableSpace;
      File[] roots = File.listRoots();
      for (File root : roots) {
        drive = root.getAbsolutePath();
        totalSpace = root.getTotalSpace() / Math.pow(1024, 3);
        usableSpace = root.getUsableSpace() / Math.pow(1024, 3);
        freeSpace = root.getFreeSpace() / Math.pow(1024, 3);
        usedSpace = totalSpace - usableSpace;
        System.out.println("Drive: " + drive);
        System.out.printf("Total Space: %5.2f GB %n", totalSpace);
        System.out.printf("Usable Space: %5.2f GB %n", usableSpace);
        System.out.printf("Free Space: %5.2f GB %n", freeSpace);
        System.out.printf("Used Sapce: %5.2f GB %n", usedSpace);
      }
    }
  }
}
