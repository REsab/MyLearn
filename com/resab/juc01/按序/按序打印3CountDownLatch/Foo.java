package com.resab.juc01.按序.按序打印3CountDownLatch;

import java.util.concurrent.CountDownLatch;

class Foo {

    //CountDownLatch详解 https://www.jianshu.com/p/128476015902
    private CountDownLatch countDownLatch12 = new CountDownLatch(1);
    private CountDownLatch countDownLatch23 = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch12.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch12.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch23.countDown();

        long count = countDownLatch23.getCount();

    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch23.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

//作者：wan-jia-guo-du
//        链接：https://leetcode.cn/problems/print-in-order/solution/1114-by-wan-jia-guo-du-3xsu/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。