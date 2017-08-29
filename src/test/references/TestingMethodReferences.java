package test.references;

import java.util.Arrays;
import java.util.Comparator;

import test.lambda.Person;

public class TestingMethodReferences {

	public static void main(String[] string) {

		Person[] rosterAsArray = (Person[]) Person.createShortList().toArray();

		class PersonAgeComparator implements Comparator<Person> {
			public int compare(Person a, Person b) {
				return a.getGivenName().compareTo(b.getGivenName());
			}
		}

		/** sorting using class */
		Arrays.sort(rosterAsArray, new PersonAgeComparator());

		/** sorting using anonymous class */
		Arrays.sort(rosterAsArray, new Comparator<Person>() {
			public int compare(Person a, Person b) {
				return a.getGivenName().compareTo(b.getGivenName());
			}
		});

		/** sorting using lambda expression */
		Arrays.sort(rosterAsArray, (Person a, Person b) -> a.getGivenName().compareTo(b.getGivenName()));

		/** sorting using lambda expression which invokes an existing method */
		Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));

		/** sorting using lambda expression which invokes an existing method */
		Arrays.sort(rosterAsArray, Person::compareByAge);

		ComparisonProvider c = new ComparisonProvider();

		/** using lambda expression */
		Arrays.sort(rosterAsArray, (Person p1, Person p2) -> p1.getGivenName().compareTo(p2.getGivenName()));

		/** using method reference */
		Arrays.sort(rosterAsArray, c::compareByName);

		String[] stringArray = { "juana", "Maria", "Licha" };

		/** using lambda expression */
		Arrays.sort(stringArray, (String s1, String s2) -> s1.compareToIgnoreCase(s2));

		/** using method reference */
		Arrays.sort(stringArray, String::compareToIgnoreCase);

	}

	static class ComparisonProvider {
		public int compareByName(Person p1, Person p2) {
			return p1.getGivenName().compareTo(p2.getGivenName());
		}

		public int compareByAge(Person p1, Person p2) {
			return p1.getAge() < p2.getAge() ? -1 : p2.getAge() < p1.getAge() ? 1 : 0;
		}

		public Person getYougest(Person[] persons) {
			return persons[0];
		}
	}

}
