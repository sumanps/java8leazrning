package com.rssoftware.java8.tutorial;

import java.util.Optional;
import java.util.function.Predicate;

import com.rssoftware.java8.tutorial.lambda.ITester;
import com.rssoftware.java8.tutorial.streams.OptionalPerson;

public class OptionalTester {

	public static void main(String[] args) {

		ITester lineSpace = () -> {
			System.out.println("\n----------------------");
		};
		lineSpace.test();

		// optional isPresent()
//		Optional<String> empty = Optional.empty();
//		System.out.println("Empty optional is present test " + empty.isPresent());
//		Optional<String> notEmpty = Optional.of("abc");
//		System.out.println("Empty optional is present test " + notEmpty.isPresent());
//		System.out.println("Optional get the wrapped value test " + notEmpty.get());

		// no such element exception
		// Optional<String> opt = Optional.ofNullable(null);
		// System.out.println("no suh element error here "+opt.get());

		// null pointer
		// Optional<String> optNull = Optional.of(null);
		// System.out.println("Null optional is present test "+optNull.isPresent());

		// null pointer
//		String xyz = null;
//		Optional<String> optNullable = Optional.ofNullable(xyz);
//		System.out.println("Null Ref optional is present test " + optNullable.isPresent());
//		xyz="abc";
//		Optional<String> optNullable1 = Optional.ofNullable("abc");
//		System.out.println("Null Ref optional toString test " + optNullable.toString());

		// set defaults
//		String name = Optional.ofNullable(xyz).orElse("john");
//		System.out.println("Null Default optional test " + name);

		// filter
//		Integer year = 2016;
//		Optional<Integer> yearOptional = Optional.of(year);
//		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
//		System.out.println("Optional filter test " + is2016);
//		Integer year1 = null;
//		Optional<Integer> yearOptional1 = Optional.ofNullable(year1);
//		boolean is2016Flag = yearOptional1.filter(y -> y == 2016).isPresent();
//		System.out.println("Optional filter test " + is2016Flag);

//		// map
		String myString = "My string";
		myString=null;
		Optional<String> myNameOptional = Optional.ofNullable(myString);
		int len = myNameOptional.map(String::length).orElse(0);
		System.out.println("String length using map " + len);

//		// map and filter
		String password = " password ";
		Optional<String> passOpt = Optional.of(password);
		Predicate p = pass -> pass.equals("password");
		boolean correctPassword = passOpt.filter(p).isPresent();
		System.out.println("Optional password check filter - map " + correctPassword);
		// passOpt.map(s->s.trim()).get();
		correctPassword = passOpt
				.map(String::trim)
				.filter(pass -> pass.equals("password")).isPresent();
		System.out.println("Optional password check 2 map - filter" + correctPassword);

		// flat map
		 OptionalPerson person = new OptionalPerson(null, 26,"pass");
		    Optional<OptionalPerson> personOptional = Optional.of(person);
		 
		 Optional<Optional<String>> nameOptionalWrapper  
	      = personOptional.map(OptionalPerson::getName);
		 
		  Optional<String> nameOptional  
	      = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
	    String name1 = nameOptional.orElse("");
	    System.out.println("Person name is "+name1);
	    String name2 = personOptional
	    	      .flatMap(OptionalPerson::getName)//.get()
	    	      .orElse("");
	    System.out.println("Person name from flatmap is "+name1);
	}

}
