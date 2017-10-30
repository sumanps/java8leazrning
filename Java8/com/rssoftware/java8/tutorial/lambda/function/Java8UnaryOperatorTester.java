package com.rssoftware.java8.tutorial.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import com.rssoftware.java8.tutorial.lambda.ITester;
/**
 * Predicate<T> - one method with param of type T and boolean return type 
 * @author swarnabhaL
 *
 */
public class Java8UnaryOperatorTester implements ITester {

	@Override
	public void test() {
		
		UnaryOperator<Integer> operator = v -> v * 100;
		System.out.println("Calculation via unary operator"+operator.apply(45));
		 // Add ten to each element in the ArrayList.
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.replaceAll(element -> element + 10);
//        // ... Display the results.
//        System.out.println("modified list via unary operator"+list);
		
	}

	
}
