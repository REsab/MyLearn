package com.resab.designmodel.单例模式;

public class SynchornziedTest1 {

    public static void main(String[] args) {
        final SynchornziedTest1 test = new SynchornziedTest1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();
    }

    public synchronized void method1() {
        System.out.println("test1 start ");
        try {
            Thread.sleep(1000);
            System.out.println("test1 run");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test1 end");
    }

    public synchronized void method2() {
        System.out.println("test2 start ");
        try {
            Thread.sleep(1000);
            System.out.println("test2 run");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 end");
    }
}



