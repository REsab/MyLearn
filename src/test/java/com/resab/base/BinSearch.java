package com.resab.base;

public class BinSearch {

	public static void main(String[] args) {

		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
		int target = 6;
		int resultIndex = binSearch(target, array);
		System.out.println("元素 " + target + " 在数组中的索引为: " + resultIndex);

		int i = binarySearchRecursive(array, target, 0, array.length);
		System.out.println("元素 " + target + " 在数组中的索引为: " + i);
	}

	private static int binSearch(int target, int[] array) {

		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int halfIndex = left + (right - left) / 2;

			if (array[halfIndex] == target) {
				return halfIndex;
			} else if (array[halfIndex] < target) {
				left = halfIndex + 1;
			} else {
				right = halfIndex - 1;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] < target) {
			return binarySearchRecursive(arr, target, mid + 1, right);
		} else {
			return binarySearchRecursive(arr, target, left, mid - 1);
		}
	}
}
