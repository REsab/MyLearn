package com.resab.juc01.按序.按序打印5阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


/**
 * 阻塞队列
 */
class Foo {


    /**
     * 原理take方法 在队列为空的时候 ，调用take() 会阻塞
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     *
     * @return the head of this queue
     * @throws InterruptedException if interrupted while waiting
     */
    //    E take() throws InterruptedException;

    BlockingQueue<String> blockingQueue12, blockingQueue23;

    public Foo() {
        //同步队列,没有容量，进去一个元素，必须等待取出来以后，才能再往里面放一个元素
        blockingQueue12 = new SynchronousQueue<>();
        blockingQueue23 = new SynchronousQueue<>();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        blockingQueue12.put("stop");
    }

    public void second(Runnable printSecond) throws InterruptedException {
        blockingQueue12.take();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        blockingQueue23.put("stop");
    }

    public void third(Runnable printThird) throws InterruptedException {
        blockingQueue23.take();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

//作者：momentumxx
//        链接：https://leetcode.cn/problems/print-in-order/solution/si-chong-bu-tong-de-shi-xian-fang-shi-zong-jie-by-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。