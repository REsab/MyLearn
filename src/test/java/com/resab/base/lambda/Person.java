package com.resab.base.lambda;

import lombok.Data;

@Data
public class Person {

	private String name;
	private Integer sex;
	private Integer age;

	public Person() {

	}

	public Person(String name, Integer age, Integer sex) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
}
