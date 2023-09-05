package com.resab.juc01.交替.交替打印2yield;

//手太阴肺经 BLOCKING Queue
public class FooBar {
    volatile boolean fooExec = true;//foo可以执行
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (fooExec) {
                printFoo.run();
                fooExec = false;
                i++;
            } else {
                Thread.yield();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (!fooExec) {
                printBar.run();
                fooExec = true;
                i++;
            } else {
                Thread.yield();
            }

        }
    }
}

//作者：a-fei-8
//        链接：https://leetcode.cn/problems/print-foobar-alternately/solution/chang-you-duo-xian-cheng-zhi-1115-by-a-f-mf5u/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。