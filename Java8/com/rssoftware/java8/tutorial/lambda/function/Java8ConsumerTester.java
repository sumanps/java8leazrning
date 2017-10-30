package com.rssoftware.java8.tutorial.lambda.function;

import java.util.function.Consumer;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8ConsumerTester implements ITester {

	@Override
	public void test() {
		String p = "dsvs";
		Consumer<String> c = p1 -> System.out.println(p1);
		c.accept(p);
	}

	
}
