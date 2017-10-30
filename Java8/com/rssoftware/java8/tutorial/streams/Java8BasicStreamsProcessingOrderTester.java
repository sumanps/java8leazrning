package com.rssoftware.java8.tutorial.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8BasicStreamsProcessingOrderTester implements ITester {

	@Override
	public void test() {

//		// intermediate operation is not invoked unless a terminal operation is present
//		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
//			System.out.println("filter: " + s);
//			return true;
//		});
//
//		// order of execution of intermediate operations
//		Stream.of("d2", "a2", "b1", "b3", "c")
//		.filter(s -> {
//			System.out.println("In filter: " + s);
//			return true;
//		})
//		.forEach(s -> System.out.println("In forEach: " + s));

		// order of execution
//		Stream.of("d2", "a2", "b1", "b3", "ac")
//		.map(s -> {
//			System.out.println("map: " + s);
//			return s.toUpperCase();
//		}).anyMatch(s -> {
//			System.out.println("anyMatch: " + s);
//			return s.startsWith("A");
//		});

		// sorting - reorder to optimize
//		Stream.of("d2", "a2", "b1", "a3", "c")
//		.filter(s -> {
//			System.out.println("filter: " + s);
//			return s.startsWith("a");
//		})
//		.map(s -> {
//			System.out.println("map: " + s);
//			return s.toUpperCase();
//		})
//		.sorted((s1, s2) -> {
//			System.out.printf("sort: %s; %s\n", s1, s2);
//			return s1.compareTo(s2);
//		})
//		.forEach(s -> System.out.println("forEach: " + s));
//
		// Resusing streams
		Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));

		stream.anyMatch(s -> true); // ok
		//stream.noneMatch(s -> true); // exception - Exception in thread "main" java.lang.IllegalStateException:
										// stream has already been operated upon or closed

		Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c")
				.filter(s -> s.startsWith("a"));
		streamSupplier.get().anyMatch(s -> true); // ok
		streamSupplier.get().noneMatch(s -> true); // ok
		
		// Advanced - collect and reduce
		// collect
		List<Person> filtered =
				getPersons()
			        .stream()
			        .filter(p -> p.getName().startsWith("P"))
			        .collect(Collectors.toList());
		filtered.stream().forEach(s -> System.out.println("collect forEach: " + s));
//		
//		// reduce
		getPersons()
	    .stream()
	    .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
	    .ifPresent(s -> System.out.println("reduce item: " + s));
	}

private List<Person> getPersons() {
		
		List<Person> persons = new ArrayList<>();
		List<Book> books1 = new ArrayList<>();
		Book book1 = new Book("1","Book A");
		books1.add(book1);
		Person person1 =new Person("PersonofAge12",12,books1);
		
		persons.add(person1);
		List<Book> books2 = new ArrayList<>();
		Book book2 = new Book("2","Book B");
		Book book3 = new Book("3","Book C");
		books2.add(book2);
		books2.add(book3);
		Person person2 =new Person("PersonofAge24",24,books2);
		persons.add(person2);
		return persons;
	}
}
