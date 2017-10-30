package com.rssoftware.java8.tutorial.lambda.function;

import java.util.function.Supplier;

import com.rssoftware.java8.tutorial.lambda.ITester;
/**
 * Predicate<T> - one method with param of type T and boolean return type 
 * @author swarnabhaL
 *
 */
public class Java8SupplierTester implements ITester {

	@Override
	public void test() {
		
		Supplier<Integer> arg = () -> (int) (Math.random() * 100);
		// .get() to retrive the value
        System.out.println("calculation via supplier"+arg.get());
		
	}

	
}
