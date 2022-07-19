package com.resab.base.extentdt;

public class Test2 {

    static class Parent {
        //父类方法
        void who() {
            System.out.println("I'm parent");
        }
    }

    static class Child extends Parent {
        //子类重写方法
        @Override
        void who() {
            System.out.println("I'm child");
        }

        //通过supper调用父类方法
        void parentWho() {
            super.who();
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        parent.who();
        child.who();
        child.parentWho();
    }
}
