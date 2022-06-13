package com.resab.juc01.按序打印2;

class Foo {

    private Object lock = new Object(); //使用一个Java对象作为一个锁
    private int index = 1;  //设置输出顺序

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (index != 1) {  //输出顺序不符合的进入到entrySet等待唤醒
                lock.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            index++;    // 按顺序打印后，index加一，进入下一个线程答应
            lock.notifyAll();   //唤醒所有等待的线程
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (index != 2) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            index++;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (index != 3) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            index++;
            lock.notifyAll();
        }

    }
}
//
//作者：silly-franklin4w7
//        链接：https://leetcode.cn/problems/print-in-order/solution/by-silly-franklin4w7-cunm/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。