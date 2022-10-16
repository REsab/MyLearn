package com.resab.juc01.completableFutureDemo;

import java.io.*;
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

//不用get方法阻塞主线程会导致任务执行中断。
        future1.get();
        future.get();

        executorService.shutdown();


        // 测试
        System.out.println("测试： ");
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("this is lambda supplyAsync");
            System.out.println("supplyAsync 是否为守护线程 " + Thread.currentThread().isDaemon());
            try {
                TimeUnit.SECONDS.sleep(1);
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/tmp/out.txt"))))) {
                    writer.write("this is completableFuture daemon test");
                } catch (Exception e) {
                    e.printStackTrace();

                    System.out.println("exception find");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this lambda is executed by forkJoinPool");
            return "result1";
        });

        TimeUnit.SECONDS.sleep(5);


    }

}
