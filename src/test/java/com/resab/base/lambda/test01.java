package com.resab.base.lambda;

import java.util.Arrays;
import java.util.List;

public class test01 {

	public static void main(String[] args) {
		Person kobe = new Person("kobe", 40, 1);
		Person jordan = new Person("jordan", 50, 1);
		Person mess = new Person("mess", 20, 2);
		List<Person> personList = Arrays.asList(kobe, jordan, mess);

		personList.stream().filter(person -> person.getSex() > 30).findAny().orElse(null);
	}
}
