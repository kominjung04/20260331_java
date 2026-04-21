package p09Stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class J04Stream활용 {
  public static void main(String[] args) {
    class User implements Comparable<User>{
      String name;
      int age;
      int ban;

      public User(String name, int age, int ban) {
        this.name = name;this.age = age;this.ban=ban;
      }

      @Override
      public String toString() {
        return String.format("[%s, %d, %d]",name,age,ban);
      }
      public int compareTo(User u){return age-u.age;}//implements Comparable때문에 필수
    }
    List<User> users = List.of(
        new User("A", 20, 1),
        new User("B", 20, 2),
        new User("C", 30, 2),
        new User("D", 30, 3),
        new User("E", 30, 1),
        new User("F", 40, 1)
    );
    //나이만 출력
    List<Integer> ages = users.stream()
        .map(user -> user.age)
        .collect(Collectors.toList());
    System.out.println("ages: " + ages);

    //반별,나이 순 출력
    users.stream().sorted(
        Comparator.comparing(new Function<User, Integer>() {
          @Override
          public Integer apply(User user) {
            return user.ban;
          }
        }).thenComparing(Comparator.naturalOrder())
            .thenComparing(new Comparator<User>() {
              @Override
              public int compare(User o1, User o2) {
                return o1.age - o2.age;
              }
            })
    ).forEach(System.out::println);
    System.out.println("====최고 나이 출력 :: Optional====");
    Optional<User> result = users.stream().reduce(
        new BinaryOperator<User>() {
          @Override
          public User apply(User u1, User u2) {
            return u1.age > u2.age?u1:u2;
          }
        }
    );
    System.out.println("최고 나이: "+result);

    System.out.println("==== 나이별 개수 구하기 ====");
    Map<Integer, Long> countByAge =
        users.stream().collect(Collectors.groupingBy(
            user -> user.age, Collectors.counting()));
    System.out.println(countByAge);

    System.out.println("==== 나이별 평균 구하기 ====");
    Map<Integer, Double> avgByAge =
        users.stream().collect(Collectors.groupingBy(
            user -> user.age, Collectors.averagingInt(user -> user.age)));
    System.out.println(avgByAge);

    //IntSummaryStatistics = 통계
    System.out.println("==== 나이별 통계 구하기 ====");
    Map<Integer, IntSummaryStatistics> statsByAge =
        users.stream().collect(Collectors.groupingBy(
            user -> user.age, Collectors.summarizingInt(user -> user.age)));
    System.out.println(statsByAge);
    IntSummaryStatistics stats30 = statsByAge.get(30);
    System.out.println(stats30.getCount());
    System.out.println(stats30.getSum());
    System.out.println(stats30.getAverage());
    System.out.println(stats30.getMax());
    System.out.println(stats30.getMin());

    System.out.println("==== User 통계 구하기 ====");
    IntSummaryStatistics stats2 =users.stream()
        .collect(Collectors.summarizingInt(user -> user.age));
    System.out.println(stats2);
  }
}