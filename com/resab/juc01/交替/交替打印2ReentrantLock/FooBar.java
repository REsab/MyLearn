package com.resab.juc01.交替.交替打印2ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

//手太阴肺经 BLOCKING Queue
public class FooBar {
    volatile boolean fooExec = true;
    private int n;
    private ReentrantLock lock = new ReentrantLock(true);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (fooExec) {
                    printFoo.run();
                    fooExec = false;
                    i++;
                }
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!fooExec) {
                    printBar.run();
                    fooExec = true;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
