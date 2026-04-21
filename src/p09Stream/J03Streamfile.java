package p09Stream;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class J03Streamfile {
  public static void main(String[] args) {
    //경로 지정
    String dir = "C:\\workspace\\spaceJava\\20260331_java";
    try {
      //경로에 가서 파일과 디렉토리 목록을 fileListStream에 저장
      Stream<Path> fileListStream = Files.list(Paths.get(dir));
      // 스트림 적용 filter -> map -> forEach
      fileListStream.map(path -> path.toFile())
          .filter(file -> file.isDirectory())
          .map(file -> file.toString()).distinct()
          .forEach(System.out::println);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
