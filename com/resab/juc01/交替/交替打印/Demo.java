package com.resab.juc01.交替.交替打印;


public class Demo {

    public static void main(String[] args) throws InterruptedException {

        FooBar foo = new FooBar(33);
        Runnable runnable = new Runnable
                () {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable barRunnble = new Runnable
                () {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        foo.bar(barRunnble);
        foo.foo(runnable);


    }
}
