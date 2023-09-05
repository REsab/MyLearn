package com.resab.juc01.零奇偶;


public class Demo {

    public static void main(String[] args) {
        //long startTime=System.nanoTime();   //获取开始时间
        long startTime = System.currentTimeMillis();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(50000);


        new Thread(() -> {
            try {
                zeroEvenOdd.zero((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
        //long endTime=System.nanoTime(); //获取结束时间
        long endTime = System.currentTimeMillis();    //获取结束时间
        //System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

}
