package com.resab.juc01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如何保证多线程下 i++ 结果正确？
 */
public class Demo1 {

    public static int num1 = 0;
    public static int size = 100000000;
    public static AtomicInteger atomicInteger3 = new AtomicInteger();
    public static AtomicInteger atomicInteger2 = new AtomicInteger();
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        // 耗时 1401
        synchronizedDemo(size);

        // 耗时  523
        atomicDemo(size);

        threadPoolDemo(size / 10);

//result
//synchronizedDemo
//100000000
//1395
//atomicDemo
//100000000
//413
//threadPoolDemo
//10000000
//5041
    }


    private static void threadPoolDemo(int size) throws InterruptedException {
        long l5 = System.currentTimeMillis();
        System.out.println("threadPoolDemo");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return atomicInteger3.getAndIncrement();
            }
        };
        for (int i = 0; i < size; i++) {
            executorService.submit(call);
        }

        // 线程池结束方法
        executorService.shutdown();
        while (true) {
            //Returns: true if all tasks have completed following shut down
            if (executorService.isTerminated()) {
                break;
            }
            Thread.sleep(200);
        }

        System.out.println(atomicInteger3.get());
        long l6 = System.currentTimeMillis();
        System.out.println(l6 - l5);


    }


    private static void futureTaskDemo(int size) {


    }

    /**
     * 使用synchronized同步
     *
     * @param size
     */
    private static void synchronizedDemo(int size) {
        long l3 = System.currentTimeMillis();
        System.out.println("synchronizedDemo");

        for (int i = 0; i < size; i++) {
            synchronized (Demo1.class) {
                num1++;
            }
        }
        System.out.println(num1);
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
    }

    /**
     * 原子类 cas 无锁机制
     *
     * @param size
     */
    private static void atomicDemo(int size) {
        long l1 = System.currentTimeMillis();

        System.out.println("atomicDemo");

        for (int i = 0; i < size; i++) {
            atomicInteger.getAndIncrement();
        }
        System.out.println(atomicInteger.get());
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

}


