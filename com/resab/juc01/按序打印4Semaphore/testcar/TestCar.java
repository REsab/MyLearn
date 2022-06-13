package com.resab.juc01.按序打印4Semaphore.testcar;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 业务场景 ：
 * <p>
 * 1、停车场容纳总停车量10。
 * <p>
 * 2、当一辆车进入停车场后，显示牌的剩余车位数响应的减1.
 * <p>
 * 3、每有一辆车驶出停车场后，显示牌的剩余车位数响应的加1。
 * <p>
 * 4、停车场剩余车位不足时，车辆只能在外面等待。
 */
public class TestCar {

    //停车场同时容纳的车辆10
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {

        //模拟100辆车进入停车场
        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("====" + Thread.currentThread().getName() + "来到停车场");
                        if (semaphore.availablePermits() == 0) {
                            System.out.println("车位不足，请耐心等待");
                        }
                        semaphore.acquire();//获取令牌尝试进入停车场
                        System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                        Thread.sleep(new Random().nextInt(10000));//模拟车辆在停车场停留的时间
                        System.out.println(Thread.currentThread().getName() + "驶出停车场");
                        semaphore.release();//释放令牌，腾出停车场车位
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "号车");

            thread.start();
        }

    }
}
  