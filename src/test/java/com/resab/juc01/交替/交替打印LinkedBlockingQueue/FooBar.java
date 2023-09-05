package com.resab.juc01.交替.交替打印LinkedBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


//手太阴肺经 BLOCKING Queue
public class FooBar {
    private int n;

    /**
     * put  有东西的时候  需要waite
     * take 没有东西的时候 需要waite
     */
    private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            foo.put(i);
            printFoo.run();
            bar.put(i);

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {

            bar.take();
            printBar.run();
            foo.take();

        }
    }
}
