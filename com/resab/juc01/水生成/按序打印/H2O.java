package com.resab.juc01.水生成.按序打印;


import java.util.concurrent.atomic.AtomicInteger;

class H2O {

    private AtomicInteger dist = new AtomicInteger(5);

    public H2O() {
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


        if (dist.get() % 3 != 0) {
            releaseHydrogen.run();
            dist.getAndIncrement();
        }
        // 不可行 如果 O 进来了 ，else 方案没办法到 下一个方法运行
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {

        if (dist.get() % 3 == 0) {
            releaseOxygen.run();
            dist.getAndIncrement();
        }
    }
}

