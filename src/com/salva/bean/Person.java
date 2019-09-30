package com.salva.bean;

/**
 * Bean Person
 */
public class Person {

	private String name;
	private String surnames;
	private int age;
	private String gender;


	public Person() {

	}

	public Person(String name, String surnames, int age, String gender) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static Person getPersonFromArray(String[] items) {
		try {
			return new Person(items[0], items[1], Integer.parseInt(items[2]), items[3]);
		} catch (NumberFormatException nFE) {
			return null;
		}
	}


}