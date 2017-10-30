package com.rssoftware.java8.tutorial.streams;

import java.util.List;

public class Person {

	public Person(String name,int age, List<Book> books) {
		super();
		this.name = name;
		this.age=age;
		this.books = books;
	}
	private String name;
	private int age;
	private List<Book> books;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", books=" + books + ", getName()=" + getName()
				+ ", getBooks()=" + getBooks() + ", getAge()=" + getAge() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
