package com.resab.juc01.水生成.按序打印;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class H2O {
    public Semaphore o1 = new Semaphore(1);
    public Semaphore h2 = new Semaphore(2);

    private AtomicInteger num = new AtomicInteger(3);


    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        h2.acquire();
        releaseHydrogen.run();
        num.getAndIncrement();

        if (num.get() % 3 == 0) {
            o1.release();
            h2.release(2);
        }
        // 不可行 如果 O 进来了 ，else 方案没办法到 下一个方法运行
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        o1.acquire();
        releaseOxygen.run();
        num.getAndIncrement();


        if (num.get() % 3 == 0) {
            o1.release();
            h2.release(2);
        }


    }
}

