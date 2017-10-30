package com.rssoftware.java8.tutorial.lambda.function;

import java.util.function.Function;

import com.rssoftware.java8.tutorial.lambda.ITester;
/**
 * Predicate<T> - one method with param of type T and boolean return type 
 * @author swarnabhaL
 *
 */
public class Java8FunctionTester implements ITester {

	@Override
	public void test() {
		
		Function<Integer, Integer> func = x -> x * 2;

        // Apply the function to an argument of 10.
        int result = func.apply(10);
        System.out.println("element printed via Function"+result);
		
	}

	
}
