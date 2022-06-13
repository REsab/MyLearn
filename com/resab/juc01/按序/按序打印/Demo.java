package com.resab.juc01.按序.按序打印;


public class Demo {

    public static void main(String[] args) {

        Foo foo = new Foo();
        new Thread(() -> {
            Runnable aaa = new Runnable() {
                @Override
                public void run() {
                    System.out.println("3third");
                }
            };
            try {
                foo.third(aaa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            Runnable aaa = new Runnable() {
                @Override
                public void run() {
                    System.out.println("1frist");
                }
            };
            try {
                foo.first(aaa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            Runnable aaa = new Runnable() {
                @Override
                public void run() {
                    System.out.println("2second ");
                }
            };
            try {
                foo.second(aaa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
