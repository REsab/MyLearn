package com.resab.juc01.交替.交替打印2CyclicBarrier;

public class Demo {

    //input
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(100);//打印10次foo bar
        Runnable printFoo = () -> {
            System.out.printf("%s\n", "foo11");
        };
        Runnable printBar = () -> {
            System.out.printf("%s\n", "bar");
        };

        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        fooThread.start();
        barThread.start();

    }


}
