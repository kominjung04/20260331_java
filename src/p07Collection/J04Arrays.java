package p07Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class J04Arrays {
  public static void main(String[] args) {
    // Arrays :: Collection에서 배열을 다루기 위한 객체
    int[] arr1={0,1,2,3,4};

    // 배열 복사 ::copyOf,copyOfRange
    int[] arr2 = Arrays.copyOf(arr1,arr1.length);
    System.out.println(Arrays.toString(arr2));
    arr1[0] = 5;
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = Arrays.copyOfRange(arr1,2,4);
    System.out.println(Arrays.toString(arr3));

    //배열 채욱
    int[] arr4 = new int[5]; // 0으로 초기화
    Arrays.fill(arr4,10);
    System.out.println(Arrays.toString(arr4));
    Arrays.setAll(arr4, new IntUnaryOperator() {
      @Override
      public int applyAsInt(int operand) {
        return (int) (Math.random()*5);
      }
    });
    System.out.println(Arrays.toString(arr4));

    //배열을 list
    Integer[] integers = new Integer[]{0,1,2,3};
    List<Integer> listInteger = new ArrayList<>(Arrays.asList(integers));
    System.out.println(listInteger);

    // list를 배열로 :: 리스트를 배열로 변환하기 위해 배열을 단순히 참조할 뿐
    Integer[] arr5 = listInteger.toArray(new Integer[listInteger.size()]);
    System.out.println(Arrays.toString(arr5));

     Integer[] arr6 = listInteger.stream().toArray(new IntFunction<Integer[]>() {
       @Override
       public Integer[] apply(int value) {
         return new Integer[value];
       }
     });
     arr6 = listInteger.stream().toArray(value -> new Integer[value]);
  }
}
