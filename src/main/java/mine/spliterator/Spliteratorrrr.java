package mine.spliterator;

import generics.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Spliteratorrrr {

  public static void main(String... strings) {

    test();
  }

  public static void test() {

    List<Person> list = new ArrayList<>();
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());
    list.add(new Person());

    Spliterator<Person> li = list.spliterator();
    System.out.println(li.characteristics());
    System.out.println(li.estimateSize());
    System.out.println(li.getExactSizeIfKnown());

    Spliterator<Person> p1 = li.trySplit();

    System.out.println(p1.getExactSizeIfKnown());

    p1.forEachRemaining(
        (Person p) -> {
          p.setName("myNameP1");
          System.out.println(p.getName());
        });

    li.forEachRemaining(
        (Person p) -> {
          p.setName("myName");
          System.out.println(p.getName());
        });
  }
}
