package test.lambda;

import java.util.List;
import java.util.function.Predicate;

import test.lambda.Person.Gender;

/**
 *
 * @author MikeW
 */
public class RoboContactLambda {

	public static void main(String[] args) {

		List<Person> pl = Person.createShortList();
		RoboContactLambda robo = new RoboContactLambda();

		// Predicates
		@SuppressWarnings("unused")
		Predicate<Person> allDrivers = p -> p.getAge() >= 16;
		Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

		System.out.println("\n==== Test 04 ====");
		System.out.println("\n=== Calling all Drivers ===");
		robo.phoneContacts(pl, p -> p.getAge() >= 16);

		System.out.println("\n=== Emailing all Draftees ===");
		robo.emailContacts(pl, allDraftees);

		System.out.println("\n=== Mail all Pilots ===");
		robo.mailContacts(pl, allPilots);

		// Mix and match becomes easy
		System.out.println("\n=== Mail all Draftees ===");
		//robo.mailContacts(pl, allDraftees);

		System.out.println("\n=== Call all Pilots ===");
		//robo.phoneContacts(pl, allPilots);

	}

	public void phoneContacts(List<Person> pl, Predicate<Person> pred) {
		for (Person p : pl) {
			if (pred.test(p)) {
				roboCall(p);
			}
		}
	}

	public void emailContacts(List<Person> pl, Predicate<Person> pred) {
		for (Person p : pl) {
			if (pred.test(p)) {
				roboEmail(p);
			}
		}
	}

	public void mailContacts(List<Person> pl, Predicate<Person> pred) {
		for (Person p : pl) {
			if ((pred.test(p))) {
				roboMail(p);
			}
		}
	}

	public void roboCall(Person p) {
		System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at "
				+ p.getPhoneNumber());
	}

	public void roboEmail(Person p) {
		System.out.println(
				"EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail());
	}

	public void roboMail(Person p) {
		System.out.println(
				"Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress());
	}

}
