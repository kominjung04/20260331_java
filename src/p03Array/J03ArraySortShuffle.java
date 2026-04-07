package p03Array;

public class J03ArraySortShuffle {
  public static void main(String[] args) {
    int[] arr = new int[10];
    p(arr);
    init(arr);
    p(arr);
    shuffle(arr);
    //lotto();
    //bubbleSort(arr);
    selectSort(arr);

  }
  //선택정렬
  static void selectSort(int[] arr) {
//    for(int i = 0 ; i < arr.length -1 ; i++){
//      for (int j = i ; j< arr.length ; j++){
//        if (arr[i] > arr[j]) {
//          int tmp = arr[i];
//          arr[i] = arr[j];
//          arr[j] = tmp;
//        }
//      }
//    }
//  }
    //성능 개선 : 빈번한 자리변경 대신에 j루프가 끝나면 최종 한번만 변경
    for(int i = 0 ; i < arr.length -1 ; i++){
      int minIdx = i;
      boolean change = false;
      for(int j = i+1;j < arr.length;j++){
        if(arr[minIdx] > arr[j]) minIdx = j;
        change = true;
      }
      if(minIdx != i){
        int tmp = arr[i];
          arr[i] = arr[minIdx];
          arr[minIdx] = tmp;
      }
      if(!change) break;
    }
    p(arr);
  }

  //버블소트 : 자신과 자신의 옆자리 크기 비교,크면 바꿈
  static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean change = false;
      //arr.length-1-i (큰 숫자가 정해질수록 비교할 범위가 줄어들기에 씀)
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
          change = true;
        }
      }
      if(!change) break; //정렬이 발생하지 않을 시 for문 나감
    }
    p(arr);
  }



  static int[] init(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i + 1;
    }
    return arr;
  }

  static void shuffle(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int r = (int) (Math.random() * 10);
      int tmp = arr[i];
      arr[i] = arr[r];
      arr[r] = tmp;
    }
    p(arr);
  }

//  //로또게임
//  static void lotto(){
//    int[] lotto = new int[45];
//    init(lotto);
//    shuffle(lotto);
//    for(int i =0 ; i < 6 ;i++){
//      System.out.println(lotto[i]);
//    }
//  }

  //배열 출력
  static void p(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      if (i != 0) System.out.print(",");
      System.out.print(arr[i]);
    }
    System.out.println("]");
//    for(int i:arr){
//      System.out.println(arr[i]);
//    }
  }

}
