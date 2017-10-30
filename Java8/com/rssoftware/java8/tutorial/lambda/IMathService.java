package com.rssoftware.java8.tutorial.lambda;

//@FunctionalInterface
public interface IMathService {

	int operation(int a, int b);
	
	// cannot add another interface if annotated with Functional Interface
	//String newOps(int a);
}
