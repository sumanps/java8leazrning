package com.rssoftware.java8.tutorial.lambda.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.rssoftware.java8.tutorial.lambda.ITester;
/**
 * Predicate<T> - one method with param of type T and boolean return type 
 * @author swarnabhaL
 *
 */
public class Java8PredicateTester implements ITester {

	@Override
	public void test() {
		// Create ArrayList and add four String elements.
//        List<String> list = new ArrayList<>();
//        list.add("cat");
//        list.add("dog");
//        list.add("cheetah");
//        list.add("deer");
        // Remove elements that start with c.
       Predicate<String> c=element -> element.startsWith("c");
       System.out.println(c.test("Cat"));
       System.out.println(c.test("cat"));

       //list.removeIf(element -> element.startsWith("c"));
        
       // System.out.println("element selection via Predicate"+list.toString());
	}

	
}
