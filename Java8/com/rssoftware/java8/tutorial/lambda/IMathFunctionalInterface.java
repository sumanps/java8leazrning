package com.rssoftware.java8.tutorial.lambda;

@FunctionalInterface
public interface IMathFunctionalInterface {

	int operate(int... a);
	// cannot add another interface if annotated with Functional Interface
	//String newOps(int a);
	
	default void xyx(String a) {};
}
