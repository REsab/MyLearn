package com.resab.designmodel.单例模式;

public class SynchornziedTest3 {

    public static void method2() {
        System.out.println("test2 start ");
        try {

            Thread.sleep(1000);
            System.out.println("test2 run");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 end");
    }

    public static void main(String[] args) {
        final SynchornziedTest3 test = new SynchornziedTest3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1("  001");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1("  002");
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1("  003");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1("  004");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1("  005");
            }
        }).start();


    }

    public void method1(String name) {
        System.out.println("test start " + name);
        try {
            synchronized (this) {

                Thread.sleep(1000);
                System.out.println("test run" + name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test end" + name);
    }
}



