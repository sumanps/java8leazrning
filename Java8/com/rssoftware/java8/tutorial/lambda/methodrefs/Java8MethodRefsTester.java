package com.rssoftware.java8.tutorial.lambda.methodrefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8MethodRefsTester implements ITester {

	@Override
	public void test() {
		// Reference to static method – Class::staticMethodName
		Function<String[], String> concatStrStaticRef = Java8MethodRefsTester::concatString;
		System.out.println(concatStrStaticRef.apply(new String[] { "Hello Static", "Concat" }));

		// Reference instance method via Class type
		List<String> strings = Arrays.asList("D", "C", "B", "A", "X", "Z", "Y");
//		Comparator<T> comparator = new Comparator<T>() {
//
//			@Override
//			public int compare(T o1, T o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		};
		List<String> sorted1 = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		List<String> sorted = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		sorted.forEach(System.out::println);
		sorted1.forEach(System.out::println);

		// Reference Instance method of an existing object
		Java8MethodRefsTester java8MethodRefsTester = new Java8MethodRefsTester();
		Function<String[], String> concatStrNonStaticRef = java8MethodRefsTester::concatStringNonStatic;
		System.out.println(concatStrNonStaticRef.apply(new String[] { "Hello Non Static", "Concat" }));

		// for 2 or more arguments
		BiFunction<String, Integer, String> concatBiFunction = (s, t) -> {
			return s + " " + t;
		};
		concatBiFunction = java8MethodRefsTester::concatStringIntNonStatic;
		System.out.println("BiFunction object method ref result "
				+ concatBiFunction.apply("Hello BiFunction object  method ref concatStringIntNonStatic", 3));

		TriFunction<String, Boolean,Integer, String> concatTriFunction = (s, t, v) -> {
			return s + t + v;
		};
		concatTriFunction = java8MethodRefsTester::concatStringBooleanIntNonStatic;

		TriFunction<String, Boolean,Integer, String> concatTriFunction1 = java8MethodRefsTester::concatStringBooleanIntNonStatic;
		System.out.println("TriFunction object method ref result "
				+ concatTriFunction.apply("str", true, 567));
		
		// Reference to constructor – Class::new
		// Using a lambda expression
		// Function<Integer, Integer> integerConstructor = s -> new Integer(2);
		// Integer i = integerConstructor.apply(100);
		Function<Integer, Integer> integerConstructor = Integer::new;
		Integer i = integerConstructor.apply(100);
		System.out.println("integer intialized with " + i);

		// Supplier<List<String>> s = () -> new ArrayList<String>();
		Supplier<List<String>> s = ArrayList::new;
		List<String> myList = s.get();
		myList.add("element in supplied list ");
		myList.forEach(System.out::println);

	}

	private static String concatString(String... a) {
		return a[0] + a[1];
	}

	private String concatStringNonStatic(String... a) {
		return a[0] + a[1];
	}

	private String concatStringIntNonStatic(String a, Integer b) {
		return a + " " + b;
	}
	
	private String concatStringBooleanIntNonStatic(String a, Boolean b,Integer c) {
		return a + " " + b+" "+c;
	}

	private String concatAndTransform(String a, Integer b, Function<String, String> stringTransform,
			Function<Integer, Integer> integerTransform) {

		a = stringTransform.apply(a);
		b = integerTransform.apply(b);

		return a + " " + b;
	}

	private Supplier<String> concatAndTransformRetLambda(String a, Integer b, Function<String, String> stringTransform,
			Function<Integer, Integer> integerTransform) {
		return () -> {
			String a1 = stringTransform.apply(a);
			Integer b1 = integerTransform.apply(b);

			return a1 + " " + b1;
		};
	}

}
