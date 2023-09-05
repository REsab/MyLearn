package com.resab.juc01.按序.按序打印4Semaphore;

import java.util.concurrent.Semaphore;

class Foo {

    Semaphore semaphore12, semaphore23;

    public Foo() {
        //初始的允许请求均设为0
        semaphore12 = new Semaphore(0);
        semaphore23 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //释放一个12的信号量
        semaphore12.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //获取一个12的信号量，没有则阻塞
        semaphore12.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //释放一个23的信号量
        semaphore23.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //获取一个23的信号量，没有则阻塞
        semaphore23.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

//作者：momentumxx
//        链接：https://leetcode.cn/problems/print-in-order/solution/si-chong-bu-tong-de-shi-xian-fang-shi-zong-jie-by-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。