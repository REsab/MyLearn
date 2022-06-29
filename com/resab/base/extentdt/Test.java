package com.resab.base.extentdt;

public class Test {

    public static void main(String[] args) {

        Child child = new Child("a", "b");
        System.out.println(child.getName());
        System.out.println(child.getName());

        Father father = (Father) child;
        System.out.println(father.getName());
        System.out.println(child.getName());

    }
}
