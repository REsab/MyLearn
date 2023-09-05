package com.resab.base.cache;

import java.util.stream.IntStream;

public class OHCtest {

	public static void main(String[] args) {

		IntStream.range(1, 10).peek(x -> System.out.print("\nA" + x)).skip(6).peek(x -> System.out.print("B" + x))
				.forEach(x -> System.out.print("C" + x));
	}
}
