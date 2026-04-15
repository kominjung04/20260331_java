package p06BasicPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class J06DateCalendar {
  public static void main(String[] args) {
    // Date     :: deprecated,  월(0), 불편/날짜 지정 어려움
    // Calendar :: 보통      ,  월(0), set()으로 날짜 지정
    System.out.println("===DATE===");
    String week[] = {"일", "월", "화", "수", "목", "금", "토"};
    Date d1 = new Date();
    d1 = new Date(126,3,15);//쓰지 말 것, 급 deprecated
    System.out.println(d1);
    System.out.println(d1.getYear()+1900);
    System.out.println(d1.getMonth()+1);
    System.out.println(d1.getDate());
    System.out.println(d1.getDay()); //일(0),1,2,3,4,5,토(6)
    System.out.println(week[d1.getDay()]);
    System.out.println(d1.getHours());
    System.out.println(d1.getMinutes());
    System.out.println(d1.getSeconds());
    System.out.println(getDate(d1));
    System.out.println(getTime(d1));
    System.out.println(getDate(d1)+ " "+getTime(d1));
    SimpleDateFormat sdf =
        new SimpleDateFormat("yyyy-MM-dd E a hh:mm:ss");
    System.out.println(sdf.format(new Date()));

    System.out.println("=====Calendar=====");
    //월은 0 ~ 11까지
    Calendar c = Calendar.getInstance();
    c.set(2026, 3, 15); // 날짜 지정 가능
    c.set(2026, 3, 15,10,30,20);
    c.set(Calendar.MONTH,Calendar.DECEMBER);
    c.set(Calendar.DAY_OF_MONTH,25);
    System.out.println(c.get(Calendar.YEAR));
    System.out.println(c.get(Calendar.MONTH)+1);
    System.out.println(c.get(Calendar.DATE));
    String week2[] = {"", "일", "월", "화", "수", "목", "금", "토"};
    System.out.println(week2[c.get(Calendar.DAY_OF_WEEK)]);
    System.out.println(c.get(Calendar.HOUR)); //12시간제
    System.out.println(c.get(Calendar.HOUR_OF_DAY)); //24시간제

    // Calendar => Date
    Date d2 = c.getTime(); // Calendar에서 날짜를 지정한 후 Date변환
    Date d3 = new Date(Calendar.getInstance().getTimeInMillis());//비추

    // Date => Calendar
    c.setTime(d2);
  }
  static String getDate(Date date) {
    return (date.getYear()+1900) + "-"
        + len2(date.getMonth()+1) + "-"
        + len2(date.getDate());
  }
  static String getTime(Date date) {
    return len2(date.getHours()) + ":"
        + len2(date.getMinutes()) + ":"
        + len2(date.getSeconds());
  }
  static String len2(int num) {
    return num < 10 ? "0" + num : "" + num;
  }
}
