package com.resab;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {
    public static AtomicInteger atomicInteger = new AtomicInteger(10);

    public static void main(String[] args) {


        new Thread(() -> {
            atomicInteger.compareAndSet(10, 101);
            System.out.println(atomicInteger.get());
            atomicInteger.compareAndSet(101, 101);
            System.out.println(atomicInteger.get());
            boolean b = atomicInteger.compareAndSet(102, 101);
            System.out.println(atomicInteger.get());

        }, "t1").start();

    }
}
