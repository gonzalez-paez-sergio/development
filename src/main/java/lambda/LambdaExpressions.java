package lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class LambdaExpressions {

  private static final int privateStaticFinal = 18;
  public static final int publicStaticFinal = 0;

  private final int privateFinal = 0;
  public final int publicFinal = 0;
  private int privateInt = 0;
  public int publicInt = 0;

  public static void main(String... string) {

    List<Person> listPerson = new ArrayList<Person>();

    Person p =
        new Person(18, "Chaps18", LocalDate.of(2017, 12, 25), Person.Sex.MALE, "test18@gmail.com");
    listPerson.add(p);

    p = new Person(23, "Chaps", LocalDate.of(2018, 12, 25), Person.Sex.FEMALE, "test@gmail.com");
    listPerson.add(p);

    p = new Person(25, "Chaps25", LocalDate.of(2016, 12, 25), Person.Sex.MALE, "test25@gmail.com");
    listPerson.add(p);

    LambdaExpressions lambdaExpressions = new LambdaExpressions();

    lambdaExpressions.printPersonOlderThan(listPerson, 20);
    lambdaExpressions.printPersonsWithinAgeRange(listPerson, 20, 23);
    lambdaExpressions.printPerson(
        listPerson,
        new CheckPersons() {

          @Override
          public boolean test(Person p) {
            return p.getGender().equals(Person.Sex.FEMALE);
          }
        });

    lambdaExpressions.printPerson(listPerson, person -> person.getGender().equals(Person.Sex.MALE));

    lambdaExpressions.processPersons(
        listPerson,
        person -> person.getGender().equals(Person.Sex.MALE) && person.getAge() == 18,
        person -> person.printPerson("processPersons"));

    lambdaExpressions.processPersonsWithFunctions(
        listPerson,
        person -> person.getGender().equals(Person.Sex.MALE),
        email -> System.out.println(email),
        person -> person.getEmailAddress());

    System.out.println();
    lambdaExpressions.processPersonsWithFunctionsGenerics(
        listPerson,
        person -> person.getGender().equals(Person.Sex.MALE) && person.getAge() == 18,
        Person::getEmailAddress,
        System.out::println);

    System.out.println();

    lambdaExpressions.testLambdaScope(listPerson);

    Person[] arrayPerson = listPerson.toArray(new Person[listPerson.size()]);

    //		Arrays.sort(arrayPerson, (a, b) -> {
    //			return a.getBirthday().compareTo(b.getBirthday());
    //		});
    //
    //		Arrays.sort(arrayPerson, (a, b) ->  Person.compareByAge(a, b));
    //
    //		//using static method
    Arrays.sort(arrayPerson, Person::compareByAge);

    //		Arrays.sort(arrayPerson, (a,b) ->a.compareByAgeNonStatic(b));

    System.out.println(Arrays.toString(arrayPerson));

    Arrays.sort(arrayPerson, Person::compareByName);

    //		Arrays.sort(arrayPerson, (a,b) ->a.compareByAgeNonStatic(b));

    System.out.println(Arrays.toString(arrayPerson));

    Supplier<Person> c =
        () -> {
          return new Person();
        };

    System.out.println(c + "-" + c.get());

    Set<Person> setPerson =
        Transfer(
            listPerson,
            (person) -> person.setName(person.getName().toUpperCase()),
            HashSet<Person>::new);

    System.out.println("transfering elements");
    System.out.println(setPerson);
  }

  public static <T, K extends Collection<T>, V extends Collection<T>> V Transfer(
      K source, Consumer<T> consumer, Supplier<V> dest) {

    V result = dest.get();

    source.stream().forEach(consumer.andThen(result::add));

    return result;
  }

  private void testLambdaScope(List<Person> listPerson) {
    this.privateInt = 45;
    listPerson.stream()
        .filter(
            person -> {
              return person.getGender().equals(Person.Sex.MALE)
                  && person.getAge() > this.privateInt;
            })
        .map(Person::getEmailAddress)
        .forEach(System.out::println);

    ;
  }

  private <X, V> void processPersonsWithFunctionsGenerics(
      Iterable<X> iterable, Predicate<X> predicate, Function<X, V> function, Consumer<V> consumer) {

    for (X x : iterable) {
      if (predicate.test(x)) {
        V v = function.apply(x);
        consumer.accept(v);
      }
    }
  }

  private void processPersonsWithFunctions(
      List<Person> listPerson,
      Predicate<Person> predicatePerson,
      Consumer<String> consumerPerson,
      Function<Person, String> functionPerson) {

    for (Person person : listPerson) {
      if (predicatePerson.test(person)) {
        String data = functionPerson.apply(person);
        consumerPerson.accept(data);
      }
    }
  }

  public void processPersons(
      List<Person> listPerson, Predicate<Person> predicatePerson, Consumer<Person> consumerPerson) {
    for (Person p : listPerson) {
      if (predicatePerson.test(p)) {
        consumerPerson.accept(p);
      }
    }
  }

  public void printPersonOlderThan(List<Person> listPerson, int intAge) {
    for (Person p : listPerson) {
      if (p.getAge() >= intAge) {
        p.printPerson("printPersonOlderThan");
      }
    }
  }

  public void printPersonsWithinAgeRange(List<Person> listPerson, int low, int high) {
    for (Person p : listPerson) {
      if (p.getAge() >= low && p.getAge() <= high) {
        p.printPerson("printPersonsWithinAgeRange");
      }
    }
  }

  public void printPerson(List<Person> listPerson, CheckPersons tester) {
    for (Person p : listPerson) {
      if (tester.test(p)) {
        p.printPerson("printPerson");
      }
    }
  }

  interface CheckPersons {
    boolean test(Person p);
  }

  class CheckPersonEligibleForSelectiveService implements CheckPersons {
    @Override
    public boolean test(Person p) {
      return p.getGender() == Person.Sex.FEMALE && p.getAge() == publicFinal;
    }
  }
}

class Person {

  int age;
  String name;
  LocalDate birthday;
  Sex gender;
  String emailAddress;

  public Person(int age, String name, LocalDate birthday, Sex gender, String emailAddress) {
    this.age = age;
    this.name = name;
    this.birthday = birthday;
    this.gender = gender;
    this.emailAddress = emailAddress;
  }

  public Person() {
    // TODO Auto-generated constructor stub
  }

  public enum Sex {
    MALE,
    FEMALE
  };

  /** @return the age */
  public int getAge() {
    return age;
  }

  /** @param age the age to set */
  public void setAge(int age) {
    this.age = age;
  }

  /** @return the name */
  public String getName() {
    return name;
  }

  /** @param name the name to set */
  public void setName(String name) {
    this.name = name;
  }

  /** @return the birthday */
  public LocalDate getBirthday() {
    return birthday;
  }

  /** @param birthday the birthday to set */
  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  /** @return the gender */
  public Sex getGender() {
    return gender;
  }

  /** @param gender the gender to set */
  public void setGender(Sex gender) {
    this.gender = gender;
  }

  /** @return the emailAddress */
  public String getEmailAddress() {
    return emailAddress;
  }

  /** @param emailAddress the emailAddress to set */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void printPerson(String string) {
    // string -> System.out::println;

    System.out.println(
        string
            + "-Person [age="
            + age
            + ", name="
            + name
            + ", birthday="
            + birthday
            + ", gender="
            + gender
            + ", emailAddress="
            + emailAddress
            + "]");
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Person [age="
        + age
        + ", name="
        + name
        + ", birthday="
        + birthday
        + ", gender="
        + gender
        + ", emailAddress="
        + emailAddress
        + "]\n";
  }

  public static int compareByAge(Person p1, Person p2) {
    return p1.getBirthday().compareTo(p2.getBirthday());
  }

  public static int compareByName(Person p1, Person p2) {
    return p1.getName().compareTo(p2.getName());
  }

  public int compareByAgeNonStatic(Person p) {
    return this.getBirthday().compareTo(p.getBirthday());
  }
}
