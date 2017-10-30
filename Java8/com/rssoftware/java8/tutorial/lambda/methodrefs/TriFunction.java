package com.rssoftware.java8.tutorial.lambda.methodrefs;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);
}
