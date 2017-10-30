package com.rssoftware.java8.tutorial.lambda;

import java.util.function.Consumer;
import java.util.function.Function;

public class Java8LambdaMethodRefTester {

	public void test() {
		//Function<String,String> f=Java8LambdaMethodRefTester :: concatStrings;
		String p = "dsvs";
		Consumer<String> c = p1 -> System.out.println(p1);
		c.accept(p);
		
	}
	private static String concatStrings(String a, String b) {
		return a + " " + b;
	}
}
