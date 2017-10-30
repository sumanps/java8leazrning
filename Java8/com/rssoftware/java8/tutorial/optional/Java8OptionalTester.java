package com.rssoftware.java8.tutorial.optional;

import java.util.Optional;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8OptionalTester implements ITester {

	@Override
	public void test() {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		String answer1 = "Yes";
        String answer2 = null;
		// Basic
        
        System.out.println("Empty Optional:" + emptyGender);
		System.out.println("Non-Empty Optional:" + gender);
		System.out.println("Non-Empty Optional: Gender value : " + gender.get());
		System.out.println("Empty Optional: " + Optional.empty());

		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
//
//		// Filter on Optional
//		System.out.println(gender.filter(g -> g.equals("male"))); // Optional.empty
//		System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional[MALE]
//		System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional.empty
//
//		//isPresent and ifPresent
//		if (gender.isPresent()) {
//			System.out.println("Value available.");
//		} else {
//			System.out.println("Value not available.");
//		}
//
//		gender.ifPresent(g -> System.out.println("In gender Option, value available."));
//
//		// condition failed, no output print
//		emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));
//
//		
//		// orElse
//		System.out.println(gender.orElse("<N/A>")); // MALE
//		System.out.println(emptyGender.orElse("<N/A>")); // <N/A>
//
//		System.out.println(gender.orElseGet(() -> "<N/A>")); // MALE
//		System.out.println(emptyGender.orElseGet(() -> "<N/A>")); // <N/A>

		
		// flat map
		// Optional<String> nonEmptyGender = Optional.of("male");
		//
		// System.out.println("Non-Empty Optional:: " +
		// nonEmptyGender.map(String::toUpperCase));
		// System.out.println("Empty Optional :: " +
		// emptyGender.map(String::toUpperCase));
		//
		// Optional<Optional<String>> nonEmptyOtionalGender =
		// Optional.of(Optional.of("male"));
		// System.out.println("Optional value :: " + nonEmptyOtionalGender);
		// System.out
		// .println("Optional.map :: " + nonEmptyOtionalGender.map(gender ->
		// gender.map(String::toUpperCase)));
		// System.out.println(
		// "Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(gender ->
		// gender.map(String::toUpperCase)));
	}

}
