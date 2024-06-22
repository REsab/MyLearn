package com.resab.leetcode.ms;

import java.util.PriorityQueue;

/**
 * 10亿个数字，取最小的100个数
 */
public class TopK {

	public static void findMinimumHundredNumbers(long[] numbers) {

		// 队列无序
		PriorityQueue<Long> queue = new PriorityQueue<>((a, b) -> Long.compare(b, a));

		// PriorityQueue<Long> priorityQueue = new PriorityQueue<>((a, b) -> Long.compare(b, a));

		for (long number : numbers) {
			// 存入数值
			queue.offer(number);
			if (queue.size() > 100) {
				//  取出最大值
				queue.poll();
			}
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	public static void main(String[] args) {
		// 假设这是 10 亿个数字的数组（这里只是示例）
		long[] numbers = {123, 5, 789, 10, 23, 56, 999, 1, 55, 444, 222, 777};
		findMinimumHundredNumbers(numbers);
	}
}
