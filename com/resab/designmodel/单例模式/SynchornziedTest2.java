package com.resab.designmodel.单例模式;

import java.util.HashMap;

public class SynchornziedTest2 {

    public static synchronized void method1() {
        System.out.println("test1 start ");
        try {
            Thread.sleep(1000);

            SynchornziedTest2.class.wait();

            System.out.println("test1 run");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test1 end");
    }

    public static synchronized void method2() {
        System.out.println("test2 start ");
        try {
//hotspot
            SynchornziedTest2.class.notify();


            Thread.sleep(1000);
            System.out.println("test2 run");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2 end");
    }


    public static void main(String[] args) {

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();


        final SynchornziedTest2 test = new SynchornziedTest2();
        final SynchornziedTest2 test2 = new SynchornziedTest2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();
    }
}



