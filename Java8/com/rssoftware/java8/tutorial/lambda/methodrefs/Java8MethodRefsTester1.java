package com.rssoftware.java8.tutorial.lambda.methodrefs;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.rssoftware.java8.tutorial.lambda.ITester;

public class Java8MethodRefsTester1 implements ITester {

	@Override
	public void test() {
		
		BiFunction<String, Integer, String> concatFunction = (s, t) -> {
			return s + " " + t;
		};
		String applyResult = concatFunction.apply("Hello concatFunction", 1);
		System.out.println("apply result " + applyResult);

		concatFunction = Java8MethodRefsTester1::concatStringInt;
		System.out.println("apply result " + concatFunction.apply("Hello concatStringInt", 2));

		Java8MethodRefsTester1 functionUsage = new Java8MethodRefsTester1();
		concatFunction = functionUsage::concatStringIntNonStatic;
		System.out.println("apply result " + concatFunction.apply("Hello concatStringIntNonStatic", 3));

		Function<String, String> toLowerCase = (s) -> {
			return s.toLowerCase();
		};
		Function<Integer, Integer> halfInteger = (i) -> {
			return i / 2;
		};

		String response = functionUsage.concatAndTransform("Hello concatAndTransform", 8, toLowerCase, halfInteger);
		System.out.println("apply result " + response);
		
		Supplier<String> transformOperation = functionUsage.concatAndTransformRetLambda("Hello concatAndTransformRetLambda", 10, toLowerCase, halfInteger);
		String operationResponse =transformOperation.get();
		System.out.println("apply result " + operationResponse);
	}
	
	private static String concatStringInt(String a, Integer b) {
		return a + " " + b;
	}

	private String concatStringIntNonStatic(String a, Integer b) {
		return a + " " + b;
	}

	private String concatAndTransform(String a, Integer b, Function<String, String> stringTransform,
			Function<Integer, Integer> integerTransform) {

		a = stringTransform.apply(a);
		b = integerTransform.apply(b);

		return a + " " + b;
	}
	
	private Supplier<String> concatAndTransformRetLambda(String a, Integer b, Function<String, String> stringTransform,
			Function<Integer, Integer> integerTransform) {
		return () -> {
			String a1 = stringTransform.apply(a);
			Integer b1 = integerTransform.apply(b);

			return a1 + " " + b1;
		};
	}

}
