package com.rssoftware.java8.tutorial;

import com.rssoftware.java8.tutorial.lambda.ITester;
import com.rssoftware.java8.tutorial.streams.Java8ParallelStreamsTester;

public class StreamsTester {

	public static void main(String[] args) {

		ITester lineSpace = () -> {
			System.out.println("\n----------------------");
		};
		lineSpace.test();

//		ITester java8BasicStreamsTester = new Java8BasicStreamsTester();
//		java8BasicStreamsTester.test();
//		lineSpace.test();
//		
//		ITester java8BasicStreamsAggrTester = new Java8BasicStreamsAggrTester();
//		java8BasicStreamsAggrTester.test();
//		lineSpace.test();

		// Exercise 
//		ITester java8BasicStreamsProcessingOrderTester = new  Java8BasicStreamsProcessingOrderTester();
//		java8BasicStreamsProcessingOrderTester.test();
//		lineSpace.test();
		// Exercise 4 parallel streams
		ITester java8ParallelStreamsTester = new Java8ParallelStreamsTester();
//		java8ParallelStreamsTester.test();
		Runnable run =java8ParallelStreamsTester::test;
		run.run();
		lineSpace.test();
		
		


	}
	
	
}
