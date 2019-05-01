package test.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambda {
  public static void main(String[] string) {

    List<Person> listPerson = Person.createShortList();

    Collections.sort(
        listPerson,
        new Comparator<Person>() {

          public int compare(Person p1, Person p2) {
            return p1.getSurName().compareTo(p2.getSurName());
          }
        });

    System.out.println("sorting w/anonymous class");
    for (Person p : listPerson) {
      p.printName();
    }

    //		Collections.sort(listPerson,
    //				(Person person1, Person person2) -> person2.getSurName().compareTo(person1.getSurName()));

    System.out.println("sorting w/lambda function");
    for (Person p : listPerson) {
      p.printName();
    }

    Collections.sort(listPerson, (p1, p2) -> p1.getSurName().compareTo(p2.getSurName()));

    System.out.println("sorting w/lambda function");
    for (Person p : listPerson) {
      p.printName();
    }
  }
}
