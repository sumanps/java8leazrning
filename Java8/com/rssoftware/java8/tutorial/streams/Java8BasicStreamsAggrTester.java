package com.rssoftware.java8.tutorial.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8BasicStreamsAggrTester implements ITester {

	@Override
	public void test() {
		// mapping -used for transformation
		List<Integer> sourceArray = Arrays.asList(new  Integer[]{1, 2, 3});
		Stream<String> stream = sourceArray.stream().map(element -> "elem_"+element.toString());
		stream.forEach(elem -> System.out.println("list().stream().map() "+elem));
		
		// real object example
		List<Person> persons = getPersons();
		Stream<String> bookStream= persons.stream().flatMap(person -> person.getBooks().stream().map(book -> book.getName()));
		bookStream.forEach(name -> System.out.println("Book item "+name));

		// reduce - used for aggregation
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		System.out.println("Reduce total "+reduced);
		
		// collect used for transformation - operation is very handy in case of converting a stream to a Collection or a Map
		List<Integer> resultList 
		  = integers.stream().map(element -> element + 1).collect(Collectors.toList());

	}
	
	private List<Person> getPersons() {
		
		List<Person> persons = new ArrayList<>();
		List<Book> books1 = new ArrayList<>();
		Book book1 = new Book("1","Book A");
		books1.add(book1);
		Person person1 =new Person("Person1",12,books1);
		
		persons.add(person1);
		List<Book> books2 = new ArrayList<>();
		Book book2 = new Book("2","Book B");
		Book book3 = new Book("3","Book C");
		books2.add(book2);
		books2.add(book3);
		Person person2 =new Person("Person2",24,books2);
		persons.add(person2);
		return persons;
	}

	
	
}
