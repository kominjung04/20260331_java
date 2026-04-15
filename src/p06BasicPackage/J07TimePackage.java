package p06BasicPackage;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class J07TimePackage {
  public static void main(String[] args) {
    // 사용 권장, 간결, 편리, java 8 사용, 요일 월~일(1~7), 월(1~12)
    LocalDate ld = LocalDate.now();
    System.out.println(ld);

    //날짜 지정 유의
    ld.of(2026, 4, 25); // immutable
    System.out.println(ld.hashCode());
    ld = ld.of(2026, 4, 25); // mutable
    System.out.println(ld);
    System.out.println(ld.hashCode());

    LocalTime lt = LocalTime.now();
    System.out.println(lt);
    DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
    System.out.println(lt.format(f));
    lt = lt.of(10,10,10);
    System.out.println(lt.format(f));

    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt);
    // MM(01~12),mm(1~12),dd(01~31),d(1~31),HH(24),hh(12),a(AM/PM)
    // E(Wed),EEEE(Wednesday),MMM(Apr),MMMM(April)
    f = DateTimeFormatter.ofPattern("y-M-dd a hh:mm:ss");
    System.out.println(ldt.format(f));
    System.out.println(LocalDate.now().format(f.ofPattern("MM월 dd일(E)")));

    String date = "2026-04-15"; //문자열
    LocalDate ld2 = LocalDate.parse(date);
    System.out.println(ld2);

    System.out.println("==== 특정필드값 가져오기, get(), getXXX() ====");
    ld = ld.now();
    System.out.println(ld.getYear());
    System.out.println(ld.getMonth()); //월을 영어명으로
    System.out.println(ld.getMonthValue()); // 월을 숫자로
    System.out.println(ld.getDayOfMonth()); // 그달의 해당일
    System.out.println(ld.getDayOfYear()); //그해의 총일수
    System.out.println(ld.getDayOfWeek()); //요일명
    System.out.println(ld.getDayOfWeek().getValue()); //요일 숫자
    System.out.println(ld.lengthOfMonth()); //특정월의 총일수
    System.out.println(ld.lengthOfYear()); //해당 년의 총일수
    System.out.println(ld.isLeapYear()); //윤년인지 아닌지
    System.out.println("============= ChronoField ===============");
    System.out.println(ld.get(ChronoField.YEAR));
    System.out.println(ld.get(ChronoField.YEAR_OF_ERA));
    System.out.println(ld.get(ChronoField.MONTH_OF_YEAR));
    System.out.println(ld.get(ChronoField.DAY_OF_MONTH));
    System.out.println(ld.get(ChronoField.DAY_OF_WEEK)); //요일 숫자
    System.out.println(ld.get(ChronoField.DAY_OF_YEAR));

    System.out.println(lt);
    System.out.println(lt.get(ChronoField.AMPM_OF_DAY)); //오전:0, 오후:1
    System.out.println(lt.get(ChronoField.HOUR_OF_DAY)); //24
    System.out.println(lt.get(ChronoField.HOUR_OF_AMPM)); //0~11
    System.out.println(lt.get(ChronoField.CLOCK_HOUR_OF_AMPM)); //1~12
    System.out.println(lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond());

    System.out.println("=== 특정 필드 변경 with(),plus(),plusXXX(),minus(),minusXXX() ===");
    System.out.println("지정 날짜: "+ld);
    System.out.println("DAY_OF_WEEK: " + ld.with(ChronoField.DAY_OF_WEEK,5));
    System.out.println("지정 날짜: "+ld);
    // ALIGNED_WEEK_OF_MONTH 현재 요일의 해당월 2번째 요일 일자 출력
    System.out.println(ld.with(ChronoField.ALIGNED_WEEK_OF_MONTH, 4));
    // ALIGNED_WEEK_OF_YEAR 현재 요일의 해당년 20번째 요일 일자 출력
    System.out.println(ld.with(ChronoField.ALIGNED_WEEK_OF_YEAR, 20));
    // 특정 요일 지정 후 해당년의 20번째 요일 일자 출력
    System.out.println(ld.with(ChronoField.ALIGNED_WEEK_OF_YEAR, 20)
        .with(ChronoField.DAY_OF_WEEK, 1));
    // 특정 년월, 특정 요일 지정 후 해당월 n번째 요일 일자 출력
    LocalDate result = LocalDate.of(2025,8,1)
        .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY));
    System.out.println(result);

    System.out.println("ld: "+ld);
    // 달의 첫째날, 마지막날 구하는 방법 4가지
    System.out.println("달의 첫째날: " + ld.withDayOfMonth(1));
    System.out.println("달의 마지막 날: " + ld.withDayOfMonth(ld.lengthOfMonth()));
    System.out.println("달의 첫째날: " + ld.with(TemporalAdjusters.firstDayOfMonth()));
    System.out.println("달의 마지막 날: " + ld.with(TemporalAdjusters.lastDayOfMonth()));
    YearMonth ym = YearMonth.of(2025, 7);
    System.out.println("달의 첫째날: " + ym.atDay(1));
    System.out.println("달의 마지막 날: " + ym.atEndOfMonth());

    System.out.println("=== plus(),plusXXX(),minus(),minusXXX() ===");
    System.out.println("ld:" + ld);
    System.out.println(ld.plus(1, ChronoUnit.YEARS));
    System.out.println(ld.plusYears(1));
    System.out.println(ld.plusDays(1));
    System.out.println(ld.minusYears(1));
    ld = ld.of(2025, 3, 1);
    System.out.println("ld.minusDays(1): "+ld.minusDays(1));
    //plusHours, plusMinutes, plusSeconds

    System.out.println("\n4. 날짜와 시간의 비교 isEqual(), isAfter(), isBefore() ===");
    ld = ld.with(LocalDate.now());
    //with() 메서드는 현재 날짜를 기준으로 상대적인 날짜를 리턴
    System.out.println("현재 날짜: "+ld);
    LocalDate ld3 = LocalDate.of(2026, 4, 15);
    System.out.println(ld.equals(ld3)); //false
    System.out.println(ld.isEqual(ld3)); //false 단순 날짜비교
    System.out.println(ld.isAfter(ld3)); //false
    System.out.println(ld.isBefore(ld3)); //true

    JapaneseDate jdt = JapaneseDate.from(LocalDate.now());
    System.out.println(jdt);
    System.out.println(ld.equals(jdt)); //false 연대가 다름.
    System.out.println(ld.isEqual(jdt)); // true 오직 날짜만 비교

    // java.util.Date => LocalDate
    LocalDate ld5 =
        new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    // java.util.Date => LocalDateTime
    LocalDateTime ldt5 =
        new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    //LocalDate => java.sql.Date
    Date d1 = java.sql.Date.valueOf(ld);

    //LocalDateTime => java.sql.Date
    Date d2 = java.sql.Timestamp.valueOf(ldt);

    //java.sql.Date => java.util.Date
    Date d3 = new java.sql.Date(new Date().getTime());

    // Data 객체만 사용
    SimpleDateFormat sdf =
        new SimpleDateFormat("yyyy-MM-dd E a hh:mm:ss");
    System.out.println(sdf.format(new Date()));
    System.out.println(sdf.format(
        java.sql.Date.valueOf(LocalDate.now())));//날짜만!

    System.out.println(LocalDateTime.now());
    System.out.println(sdf.format(
        java.sql.Timestamp.valueOf(LocalDateTime.now())));
  }
}
