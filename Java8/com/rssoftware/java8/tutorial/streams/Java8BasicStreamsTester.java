package com.rssoftware.java8.tutorial.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8BasicStreamsTester implements ITester {

	@Override
	public void test() {
		// create a stream
		Stream<String> streamOfStr = Stream.of("a", "b", "c");
		// print elements of the stream using the foreach method
		streamOfStr.forEach(element -> System.out.println("element is "+element));
		
		// collect used for transformation - operation is very handy in case of converting a stream to a Collection or a Map
//		Stream<String> strStream = Stream.of("a", "b", "c");
//		List<String> resultList 
//		  = strStream.map(element -> "Transformed Str "+element).collect(Collectors.toList());
//		resultList.stream().forEach(element -> System.out.println("Collected element is "+element));
		
		// default stream() method to convert collection to stream
		Integer[] arr = new Integer[]{1, 2, 3};
		Stream<Integer> streamOfInt = Arrays.stream(arr);
		Predicate<Integer> p = element ->element.intValue() > 2;
		// print elements which are greater than 3
		Stream<Integer> filteredStream = streamOfInt.filter(p);
		filteredStream.forEach(element -> System.out.println("filtered element is "+element));
		
		// construct a pipeline and execute
		Arrays.stream(new Integer[]{4,5,6})
		.filter(element ->element > 4)
		.forEach(element -> System.out.println("filtered element through pipe is "+element));
		
		// anymatch 
		System.out.println(Arrays.stream(new Integer[]{7,8,9}).anyMatch(element -> element == 8));
		
	}

	
	
}
