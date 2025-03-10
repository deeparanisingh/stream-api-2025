package org.anonymousclass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceForRunnable {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run method");
            }
        });
        executorService.shutdown();
    }
}
