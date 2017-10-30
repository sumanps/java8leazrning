package com.rssoftware.java8.tutorial.streams;

import java.util.Optional;

public class OptionalPerson {
	public OptionalPerson(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}

	private String name;
	private int age;
	private String password;

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	public Optional<String> getPassword() {
		return Optional.ofNullable(password);
	}

}
