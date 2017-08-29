package test.lambda;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String givenName;
	private String surName;
	private int age;
	private Gender gender;
	private String eMail;
	private String phoneNumber;
	private String address;

	public enum Gender {
		MALE, FEMALE;
	}

	public static class Builder {
		private String givenName;
		private String surName;
		private int age;
		private Gender gender;
		private String eMail;
		private String phoneNumber;
		private String address;

		public Builder givenName(String string) {
			this.givenName = string;
			return this;
		}

		public Builder surName(String string) {
			this.surName = string;
			return this;
		}

		public Builder age(int i) {
			this.age = i;
			return this;
		}

		public Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Builder email(String string) {
			this.eMail = string;
			return this;
		}

		public Builder phoneNumber(String string) {
			this.phoneNumber = string;
			return this;
		}

		public Builder address(String string) {
			this.address = string;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	private Person(Builder builder) {

		this.givenName = builder.givenName;
		this.surName = builder.surName;
		this.age = builder.age;
		this.gender = builder.gender;
		this.eMail = builder.eMail;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
	}

	public static List<Person> createShortList() {
		List<Person> people = new ArrayList<>();

		people.add(new Person.Builder().givenName("Bob").surName("Baker").age(21).gender(Gender.MALE)
				.email("bob.baker@example.com").phoneNumber("201-121-4678").address("44 4th St, Smallville, KS 12333")
				.build());

		people.add(new Person.Builder().givenName("Jane").surName("Doe").age(25).gender(Gender.FEMALE)
				.email("jane.doe@example.com").phoneNumber("202-123-4678").address("33 3rd St, Smallville, KS 12333")
				.build());

		people.add(new Person.Builder().givenName("John").surName("Doe").age(25).gender(Gender.MALE)
				.email("john.doe@example.com").phoneNumber("202-123-4678").address("33 3rd St, Smallville, KS 12333")
				.build());
		people.add(new Person.Builder().givenName("Test").surName("Test").age(16).gender(Gender.MALE)
				.email("john.doe@example.com").phoneNumber("202-123-4678").address("33 3rd St, Smallville, KS 12333")
				.build());
		return people;

	}

	public void printName() {
		System.out.println(this.givenName + " " + this.surName);
	}

	public String getSurName() {
		// TODO Auto-generated method stub
		return this.surName;
	}

	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * @param givenName
	 *            the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the eMail
	 */
	public String getEmail() {
		return eMail;
	}

	/**
	 * @param eMail
	 *            the eMail to set
	 */
	public void setEmail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param surName
	 *            the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	public static int compareByAge(Person a, Person b) {
		return a.getAge() < b.getAge() ? -1 : a.getAge() > b.getAge() ? 1 : 0;
	}

}