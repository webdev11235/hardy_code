package com.test1;

import java.util.Collection;

public class GenericTest {
	public static <T extends Collection, E> void printCollection(Collection<E> collection) {
		for (E element: collection) {
			System.out.println(element);
		}
	}
}

class Gen {
	private int val;
	<T extends Number> Gen(T value) {
		this.val = value;
	}
}
