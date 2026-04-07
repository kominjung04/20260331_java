package p03Array;

public class J02MinMaxAverangeTotal {
  public static void main(String[] args) {
    int[] arr = new int[6];
//    for(int i = 0 ; i < arr.length;i++){
//      int ball = (int)(Math.random()*45)+1;
//      arr[i] = ball;
//    }
    int count = 0; //볼의 갯수를 확인
    while (count < 6) {
      //랜덤한 볼생성
      int ball = (int) (Math.random() * 45) + 1;

      //중복확인
      boolean duplicate = false;
      for (int i = 0; i < arr.length; i++) {
        if (ball == arr[i]) {
          duplicate = true;
          break;
        }
      }

      //중복되면 while문 처음부터 다시 시작, 있으면 배열에 추가
      if (duplicate) continue;
      else arr[count++] = ball;

      //배열 원소에 0이 있다면 6자리가 다 채워지지 않았으므로 첨으로 돌아감.
//      boolean chk = false;
//      for(int i=0; i< arr.length;i++) {
//        if(arr[i] == 0) chk = true;
//      }
//      if(!chk) break;
    }
    J03ArraySortShuffle.p(arr);
    System.out.println("max: " + max(arr) + " min: " + min(arr));
    System.out.printf("avg: %.1f, %.2f",avg(arr),avg(arr));
  }

  static int max(int[] arr) {
    int max = arr[0];
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      //max와 arr[i]값을 비교
      if (max < arr[i]) {
        //크면 max값을 arr[i]로 갱신
        max = arr[i];
      }
    }
    return max;
  }

  static int min(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      //min와 arr[i]값을 비교
      if(min > arr[i]){
        //작으면 min값을 arr[i]로 갱신
        min = arr[i];
      }
    }
    return min;
  }

  static float avg(int[]arr){
    int sum = 0;
    int avg = 0;
    for(int i = 0 ; i < arr.length;i++){
      sum += arr[i];
    }
    return (float)sum/arr.length;
  }
}


