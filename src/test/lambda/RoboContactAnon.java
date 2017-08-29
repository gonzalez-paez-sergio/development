package test.lambda;

import java.util.List;

/**
 *
 * @author MikeW
 */
public class RoboContactAnon {

	public interface MyTest<T> {
		boolean test(T t);
	}

	public void phoneContacts(List<Person> pl, MyTest<Person> aTest) {
		for (Person p : pl) {
			if (aTest.test(p)) {
				roboCall(p);
			}
		}
	}

	public void emailContacts(List<Person> pl, MyTest<Person> aTest) {
		for (Person p : pl) {
			if (aTest.test(p)) {
				roboEmail(p);
			}
		}
	}

	public void mailContacts(List<Person> pl, MyTest<Person> aTest) {
		for (Person p : pl) {
			if (aTest.test(p)) {
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