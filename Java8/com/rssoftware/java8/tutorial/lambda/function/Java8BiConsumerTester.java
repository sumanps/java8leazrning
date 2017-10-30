package com.rssoftware.java8.tutorial.lambda.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8BiConsumerTester implements ITester {

	@Override
	public void test() {
		BiConsumer<String, String> biConsumer = (x, y) -> {
			System.out.println(x);
			System.out.println(y);
		};
		biConsumer.accept("Printed by", "Bi Consumer");
		
//		Map<String, String> hash = new HashMap<>();
//        hash.put("cat", "orange");
//        hash.put("dog", "black");
//        hash.put("snake", "green");
//        // Use lambda expression that matches BiConsumer to display HashMap.
//        hash.forEach((string1, string2) -> System.out.println(string1 + "..."
//                + string2 + ", " + string1.length()));
	}

}
