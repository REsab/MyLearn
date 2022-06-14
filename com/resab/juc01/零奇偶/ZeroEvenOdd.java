package com.resab.juc01.零奇偶;


import java.util.function.IntConsumer;


public class ZeroEvenOdd {
    private int n;
    private int odd = 1;
    private int even = 2;
    private String flag = "zero";   //作为锁🔒

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (odd < n || even < n) {    //当最大值<n的时候才会有打印0的情况
            if (!flag.equals("zero")) {  //如果当前状态不是打印0，则zero()这个方法线程处于等待状态
                this.wait();
            }
            this.notifyAll();  //唤醒所有处于等待中的线程
            if (flag.equals("zero")) {  //确定下一个要处于等待中的线程
                if (even < odd) {
                    flag = "even";
                } else {
                    flag = "odd";
                }
                printNumber.accept(0);
            }
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (even <= n) {
            if (!flag.equals("even")) {
                this.wait();
            }
            this.notifyAll();
            if (flag.equals("even")) {  //打印完偶数后，下一个就是打印0
                flag = "zero";
                printNumber.accept(even);
                even += 2;
            }
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (odd <= n) {
            if (!flag.equals("odd")) {
                this.wait();
            }
            this.notifyAll();
            if (flag.equals("odd")) {  //打印完奇数后，下一个就是打印0
                flag = "zero";
                printNumber.accept(odd);
                odd += 2;
            }
        }
    }

}
