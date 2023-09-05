package com.resab.base;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.io.IOException;

/**
 * * https://juejin.cn/post/7166504674214805517
 */
public class GuavaTest {
	public static void main(String[] args) throws IOException {

		test1();
		test2();
	}

	private static void test1() {
		Table<String, String, Integer> table = HashBasedTable.create();
// 存放元素
		table.put("1", "1", 1);
		table.put("1", "2", 1);
		table.put("2", "1", 1);
		table.put("2", "2", 1);

		// 取出元素
		Integer dayCount = table.get("Hydra", "Feb");
	}

	private static void test2() {
		Table<String, String, Integer> table = HashBasedTable.create();
		// 存放元素
		table.put("1", "1", 1);
		table.put("1", "2", 1);
		table.put("2", "1", 1);
		table.put("2", "2", 1);

// 取出元素
		Integer dayCount = table.get("Hydra", "Feb");
	}
}