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
	}

	private static void test1() {
		Table<String, String, Integer> table = HashBasedTable.create();
// 存放元素
		table.put("Hydra", "Jan", 20);
		table.put("Hydra", "Feb", 28);

		table.put("Trunks", "Jan", 28);
		table.put("Trunks", "Feb", 16);

// 取出元素
		Integer dayCount = table.get("Hydra", "Feb");
	}
}