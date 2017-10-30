package com.rssoftware.java8.tutorial.lambda;

public class Java8FunctionalInterfaceTester implements ITester {

	@Override
	public void test() {
		IMathFunctionalInterface addfnService =(int[] a)->{System.out.println("adding through annotated classes "+a[0]+" "+a[1]);
			return a[0]+a[1];};
			System.out.println("Functional interface addition "+addfnService.operate(1, 2));
		
	}

	
//	The expected type must be an interface that has exactly one (abstract) method
//	Called “Functional Interface” or “Single Abstract Method (SAM) Interface”

}
