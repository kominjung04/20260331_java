package p06BasicPackage;

import javax.swing.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class J04String {
  public static void main(String[] args) {
    String str1 = "hello";
    String str2 = new String("hello");
    String str3 = "hello";
    System.out.println(str1);
    System.out.println(str2);
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);
    System.out.println(str1.hashCode());
    System.out.println(str2.hashCode());
    System.out.println(str3.hashCode());
    System.out.println(System.identityHashCode(str1));
    System.out.println(System.identityHashCode(str2));
    System.out.println(System.identityHashCode(str3));
    System.out.println(str1.equals(str2));
    System.out.println(str1.intern());
    System.out.println(str2.intern());
    System.out.println(str3.intern() == str2.intern());
    System.out.printf("%s %s %s",str1,str2,str3);
    System.out.println(String.format("%s %s %s",str1,str2,str3));

    System.out.println("===== String method =====");
    for(int i=0;i<str1.length();i++){
      System.out.println(str1.charAt(i));
    }
    System.out.println(str1.compareTo("Hello")); //32
    System.out.println(str1.concat("java"));
    System.out.println(str1.contains("hell")); //포함되어 있는냐
    System.out.println(str1.startsWith("e"));//시작 하는지
    System.out.println(str1.endsWith("o")); //끝나는지
    System.out.println(str1.indexOf("l"));
    System.out.println(str1.lastIndexOf("l"));
    System.out.println(str1.replace("l","n"));
    System.out.println(str1.replace("o",""));
    System.out.println(str1.replaceFirst("l","e"));
    String[] arr = "Passion is the Genesis of Genius".split(" ");
    System.out.println(Arrays.toString(arr));
    String url = "c:\\workspace\\test.html";
    arr = url.split("\\\\");
    System.out.println(Arrays.toString(arr));
    System.out.println(arr[arr.length-1]);
    System.out.println(url.substring(url.lastIndexOf("\\")+1));
    System.out.println("hello world".substring(6,10));
    System.out.println(url.substring(url.lastIndexOf(".")+1));
    String tmp = arr[arr.length-1]; //test.html
    String answer = tmp.substring(tmp.lastIndexOf(".")+1);
    System.out.println(answer);
    System.out.println(tmp.toUpperCase());
    System.out.println(tmp.toLowerCase());
//    String input = JOptionPane.showInputDialog("ID를 입력하세요");
//    if (input.toLowerCase().equals("admin")) {
//      System.out.println(true);
//    }
    System.out.println("  hello world   ".trim());
    System.out.println(String.valueOf(1));
    common.Util.typeOf(String.valueOf(1));
    common.Util.typeOf(1);
    common.Util.typeOf(1 + "");
    common.Util.typeOf(String.valueOf(0b10)); //2진수
    common.Util.typeOf(String.valueOf(0010)); //8진수
    common.Util.typeOf(String.valueOf(0x10)); //16진수
    StringJoiner sj = new StringJoiner(",","[","]");
    int[] intArr = {1,2,3,4,5};
    for(int i = 0;i<intArr.length;i++){
    //  sj.add(String.valueOf(intArr[i]));
      sj.add(intArr[i]+"");
    }
    System.out.println(sj.toString());
  }
}
