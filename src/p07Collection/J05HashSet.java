package p07Collection;

import java.util.*;

public class J05HashSet {
  public static void main(String[] args) {
    //Set :: 순서 없고, 중복 불허
    Set set = new HashSet();

    //데이터 추가
    set.add(1);
    set.add(1);
    set.add(2);
    set.add(true);
    System.out.println(set);

    // 데이터 접근
    for(Object o: set) System.out.println(o);
    System.out.println();
    Iterator iset = set.iterator();

    while (iset.hasNext()){
      System.out.println(iset.next());
    }

    Set<Integer> lotto = new HashSet<>();
    while (lotto.size() < 6 ){
      lotto.add(((int)(Math.random()*45)+1));
    }
    System.out.println(lotto);

    //교집합 :: retaubAll()
    Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4));
    Set<Integer> set2 = new HashSet<>(Arrays.asList(5,6,7,8));

    set1.retainAll(set2);
    System.out.println("교집합: " + set1);

    //합집합 :: addAll()
    set1 = new HashSet<>(Arrays.asList(1,2,3,4));
    set2 = new HashSet<>(Arrays.asList(5,6,7,8));

    set1.addAll(set2);
    System.out.println("합집합: " + set1);

    //차집합 :: removeAll()
    set1 = new HashSet<>(Arrays.asList(1,2,3,4));
    set2 = new HashSet<>(Arrays.asList(3,4,5,6));

    set1.removeAll(set2);
    System.out.println("차집합: " + set1);

    Student std1 = new Student("김길동",1);
    Student std2 = new Student("김길동",2);
    Student std3 = new Student("박길동",2);
    Set<Student> students = new HashSet<>();
    students.add(std1);
    students.add(std2);
    students.add(std3);
    System.out.println(students);

  }
}


class Student{
  private String name;
  private int no,kor,eng,math;

  public Student(String name, int no) {
    this.name = name;
    this.no = no;
  }

  @Override
  public String toString() {
    return String.format("이름:%s 학번:%d",name,no);
  }

  //중복된 것을 확인할 경우 equals()와 hashCode()를 재정의
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return no == student.no ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }
}