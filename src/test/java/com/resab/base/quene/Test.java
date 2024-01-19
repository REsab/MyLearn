package com.resab.base.quene;

public class Test {
	public static void main(String[] args) {

		MyBlockQueue myBlockQueue = new MyBlockQueue(3);





		myBlockQueue.add(333);
		myBlockQueue.add(3);
		myBlockQueue.add(33);
		myBlockQueue.add(533);
		myBlockQueue.add(833);
		myBlockQueue.add(933);
		myBlockQueue.add(733);

		int take = myBlockQueue.take();

		System.out.println(take);


	}
}
