package com.resab.juc01.交替.交替打印;


public class Demo {

    public static void main(String[] args) throws InterruptedException {

        FooBar foo = new FooBar(22);

        new Thread(() -> {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("bar");
                }
            };
            try {
                foo.bar(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("foo");
                }
            };
            try {
                foo.foo(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
