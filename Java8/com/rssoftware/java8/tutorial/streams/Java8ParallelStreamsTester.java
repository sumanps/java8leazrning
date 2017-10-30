package com.rssoftware.java8.tutorial.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8ParallelStreamsTester implements ITester {

	@Override
	public void test() {
		
		// stream builder
		Stream<String> myStream =
				  Stream.<String>builder().add("a").add("b").add("c").build();
		myStream.iterator().forEachRemaining(System.out::println);
		
		// finite streams
		Stream<String> finiteStream =
				  Stream.generate(() -> "element").limit(4);
		finiteStream.forEach(System.out::println);
		Stream.iterate("element",element ->{System.out.println(element); return element;});
		
		// infinite streams
//		Stream<?> infiniteStream =Stream.generate(() -> Math.random());
//		infiniteStream.forEach(System.out::println);
		
		// intStream
		IntStream intStream = IntStream.range(1, 3);
		System.out.println("Int stream elements "+intStream.sum());
		
		// longStream
		LongStream longStream = LongStream.rangeClosed(1, 3);
		System.out.println("Long stream elements "+longStream.count());
		
		// doubleStream
		//DoubleStream doubleStream1 = DoubleStream.generate(()->(new Random()).nextDouble());
		DoubleStream doubleStream = DoubleStream.concat((new Random()).doubles(24), (new Random()).doubles(34));
		System.out.println("DoubleStream stream elements "+doubleStream.count());
		
		// Fork join test
		ForkJoinPool commonPool = ForkJoinPool.commonPool(); 
		System.out.println("----No of parallelism---- "+commonPool.getParallelism()); 
		
		// parallel collection
//		Arrays.asList("a1", "a2", "b1", "c2", "c1")
//	    .parallelStream()
//	    .filter(s -> {
//	        System.out.format("Parallel filter: %s [%s]\n",
//	            s, Thread.currentThread().getName());
//	        return true;
//	    })
//	    .map(s -> {
//	        System.out.format("parallel map: %s [%s]\n",
//	            s, Thread.currentThread().getName());
//	        return s.toUpperCase();
//	    })
//	    .forEach(s -> System.out.format("parallel forEach: %s [%s]\n",
//	        s, Thread.currentThread().getName()));
//
//		System.out.println("----common pool size---- "+commonPool.getPoolSize()); 
		
		// implicit parallelSort -  sort on a parallel stream uses the new Java 8 method Arrays.parallelSort() under the hood
		Arrays.asList("a1", "a2", "b1", "c2", "c1")
	    .parallelStream()
	    .filter(s -> {
	        System.out.format("filter: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return true;
	    })
	    .map(s -> {
	        System.out.format("map: %s [%s]\n",
	            s, Thread.currentThread().getName());
	        return s.toUpperCase();
	    })
	    .sorted((s1, s2) -> {
	        System.out.format("arrays parallelSort sort: %s <> %s [%s]\n",
	            s1, s2, Thread.currentThread().getName());
	        return s1.compareTo(s2);
	    })
	    .forEach(s -> System.out.format("forEach: %s [%s]\n",
	        s, Thread.currentThread().getName()));
	}

}
