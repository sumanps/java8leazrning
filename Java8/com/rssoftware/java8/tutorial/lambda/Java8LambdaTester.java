package com.rssoftware.java8.tutorial.lambda;


public class Java8LambdaTester implements ITester{

	@Override
	public void test() {
		// with type declaration
		IMathService additionService = (int a, int b) -> a + b;

		// with out type declaration
		IMathService subtractionService = (a, b) -> a - b;

		// with return statement along with curly braces multi line code
		IMathService multiplicationService = (int a, int b) -> {
			System.out.println("I am multiplying numbers"+a+" "+b);
			return a * b;
		};
		// without return statement and without curly braces
		IMathService divisionService = (int a, int b) -> a / b;
		
		// executing
		System.out.println("added :"+additionService.operation(1, 2));
		System.out.println("substracted :"+subtractionService.operation(1, 2));
		System.out.println("multiplied :"+multiplicationService.operation(1, 2));
		System.out.println("divided :"+divisionService.operation(1, 2));
		
	}


}
