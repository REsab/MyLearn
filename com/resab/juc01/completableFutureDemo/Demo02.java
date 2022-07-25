package com.resab.juc01.completableFutureDemo;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 *
 */
public class Demo02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //线程池
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("this is deamed: " + Thread.currentThread().isDaemon());
                return null;
            }
        });

        CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("doing by lambda:" + Thread.currentThread().isDaemon());
                return null;
            }
        });


        CompletableFuture<Object> future = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("doinng  in  executos service : " + Thread.currentThread().isDaemon());
                return null;
            }
        }, executorService);


        future1.get();
        future.get();

        executorService.shutdown();

    }

}
