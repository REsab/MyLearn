package com.resab.juc01.水生成;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {
    public final CyclicBarrier barrier = new CyclicBarrier(3);
    public final Semaphore h = new Semaphore(2);
    public final Semaphore o = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //h原子获取信号量
        h.acquire();
        releaseHydrogen.run();

        //等待另一个h的打印和o的打印
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //释放信号量
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        //o原子获取信号量
        o.acquire();
        releaseOxygen.run();
        //等待另外两个h的打印
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        //释放信号量
        o.release();
    }



}

