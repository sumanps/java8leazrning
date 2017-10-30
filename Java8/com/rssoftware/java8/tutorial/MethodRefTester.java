package com.rssoftware.java8.tutorial;

import java.util.function.Consumer;

import com.rssoftware.java8.tutorial.lambda.ITester;
import com.rssoftware.java8.tutorial.lambda.methodrefs.Java8MethodRefsTester;

public class MethodRefTester {

	public static void main(String[] args) {

		ITester lineSpace = () -> {
			System.out.println("\n----------------------");
		};
		lineSpace.test();

		Consumer<String> c = s -> System.out.println(s);
		Consumer<String> d = System.out::println;
		d.accept("Method Ref Print");
		
		ITester java8MethodRefsTester = new Java8MethodRefsTester();
		java8MethodRefsTester.test();
	}
	
	
}
