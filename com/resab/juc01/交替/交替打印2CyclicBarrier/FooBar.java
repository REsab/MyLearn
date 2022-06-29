package com.resab.juc01.交替.交替打印2CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;


//手太阴肺经 BLOCKING Queue
public class FooBar {
    volatile boolean fooExec = true;
    private int n;
    private CyclicBarrier cb = new CyclicBarrier(2);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fooExec) {
                //false的时候，bar线程在执行，foo线程在这此处空转
            }
            printFoo.run();//打印foo
            fooExec = false;//设置变量
            try {
                cb.await();//线程foo到达同步点
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Runnable 无入参 无返回
     * @param printBar
     * @throws InterruptedException
     */
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooExec = true;

        }


        /**
         * callable 无入参，有返回
         */
    } public void bar22(Callable printBar) throws Exception {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.call();
            fooExec = true;

        }
    }
}
