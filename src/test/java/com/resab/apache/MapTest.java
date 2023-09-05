package com.resab.apache;

import cn.hutool.core.map.BiMap;

import java.util.HashMap;

public class MapTest {

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
