package com.resab.base.quene;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		MyBlockQueue myBlockQueue = new MyBlockQueue(3);

		new Thread(() -> {
			myBlockQueue.add(333);
			myBlockQueue.add(3);
			myBlockQueue.add(33);
			myBlockQueue.add(533);
			myBlockQueue.add(833);
			myBlockQueue.add(933);
			myBlockQueue.add(733);
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				int take = myBlockQueue.take();
				System.out.println(take);
			}
		}).start();
		System.out.println("-------------------");

		Thread.sleep(10000);

		System.exit(0);

		//
		// myBlockQueue.add(333);
		// myBlockQueue.add(3);
		// myBlockQueue.add(33);
		// myBlockQueue.add(533);
		// myBlockQueue.add(833);
		// myBlockQueue.add(933);
		// myBlockQueue.add(733);
		//
		// int take = myBlockQueue.take();
		//
		// System.out.println(take);


	}
}
