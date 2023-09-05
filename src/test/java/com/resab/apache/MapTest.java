package com.resab.apache;

import cn.hutool.core.map.BiMap;
import cn.hutool.core.map.TableMap;
import org.junit.Test;

import java.util.HashMap;

public class MapTest {

	@Test
	public void test1() {
		TableMap<String, Integer> tableMap = new TableMap(3);

		tableMap.put("aaa", 111);
		tableMap.put("bbb", 222);

		// 111
		tableMap.get("aaa");
		// 222
		tableMap.get("bbb");

		// aaa
		tableMap.getKey(111);
		// bbb
		tableMap.getKey(222);

		// [111]
		tableMap.getValues("aaa");

		//[aaa]
		tableMap.getKeys(111);
	}

	public static void main(String[] args) {

		BiMap<String, Integer> biMap = new BiMap<>(new HashMap<>());
		biMap.put("aaa", 111);
		biMap.put("bbb", 222);

		// 111
		biMap.get("aaa");
		// 222
		biMap.get("bbb");

		// aaa
		biMap.getKey(111);
		// bbb
		biMap.getKey(222);
	}
}
