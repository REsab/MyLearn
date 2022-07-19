package com.resab.base.extentdt;

/**
 * 父类 子类共用一个属性
 */
public class Test {

    public static void main(String[] args) {

        Father child = new Child("a", "b");
        System.out.println(child.getName());
        System.out.println(child.getName());

        Father father = (Father) child;
        System.out.println(father.getName());
        System.out.println(child.getName());

    }
}
