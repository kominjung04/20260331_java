package p03Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class J04Arrays {
  public static void main(String[] args) {
    int a[] ={1,2,3,4,5};
    System.out.println(a);
    System.out.println(Arrays.toString(a));

    int[] b = a; //얇은복사 shallow copy,주소값 공유
    System.out.println(b);
    System.out.println(Arrays.toString(b));
    b[0] = 10;
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));

    b=a.clone(); //깊은복사 deep copy,주소값 공유X
    System.out.println(b);
    System.out.println(Arrays.toString(b));
    a[0]=1;
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    // 깊은 복사 deep copy 2
    System.arraycopy(a,0,b,0,2);
    a[0]=100;
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    // 깊은 복사 deep copy 3
    b = Arrays.copyOf(a,a.length);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    // 깊은 복사 deep copy 4
    b = Arrays.copyOfRange(a,0,a.length);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    
    //깊은 복사 deep copy 5
    Arrays.sort(a);
    System.out.println(Arrays.toString(a));

    Arrays.fill(a,20);
    System.out.println(Arrays.toString(a));
  }
}
