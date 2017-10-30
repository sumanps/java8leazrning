package com.rssoftware.java8.tutorial;

import com.rssoftware.java8.tutorial.lambda.ITester;
import com.rssoftware.java8.tutorial.lambda.Java8FunctionalInterfaceTester;
import com.rssoftware.java8.tutorial.lambda.Java8LambdaTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8BiConsumerTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8ConsumerTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8FunctionTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8PredicateTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8SupplierTester;
import com.rssoftware.java8.tutorial.lambda.function.Java8UnaryOperatorTester;
import com.rssoftware.java8.tutorial.optional.Java8OptionalTester;

public class LambdaTester {

	public static void main(String[] args) {
		// Exercise 1 - lambda usage
		ITester java8LambdaTester = new Java8LambdaTester();
		java8LambdaTester.test();
		ITester tester = () -> {
			System.out.println("my function runtime interface");
		};
		tester.test();

//		// Exercise 2 - lambda functional interface
		ITester java8FunctionalInterfaceTester = new Java8FunctionalInterfaceTester();
		java8FunctionalInterfaceTester.test();

		ITester lineSpace = () -> {
			System.out.println("\n----------------------");
		};
		lineSpace.test();
//		// Exercise 3 lambda functions
//		// consumer
		ITester java8ConsumerTester = new Java8ConsumerTester();
		java8ConsumerTester.test();
		lineSpace.test();
//		// predicate
		ITester java8PredicateTester = new Java8PredicateTester();
		java8PredicateTester.test();
		lineSpace.test();
//		// function
		ITester java8FunctionTester = new Java8FunctionTester();
		java8FunctionTester.test();
		lineSpace.test();
//		// Supplier
		ITester java8SupplierTester = new Java8SupplierTester();
		java8SupplierTester.test();
		lineSpace.test();
//		// unary operator
		ITester java8UnaryOperatorTester = new Java8UnaryOperatorTester();
		java8UnaryOperatorTester.test();
		lineSpace.test();
//		// BiConsumer
		ITester java8BiConsumerTester = new Java8BiConsumerTester();
		java8BiConsumerTester.test();
		lineSpace.test();

//		// Excercise 4 optional
		ITester java8OptionalTester = new Java8OptionalTester();
		java8OptionalTester.test();
		lineSpace.test();
	}

}
