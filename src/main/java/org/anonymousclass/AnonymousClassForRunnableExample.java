package org.anonymousclass;

public class AnonymousClassForRunnableExample {
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside run method1!!!");
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside run method2!!!");
            }
        });
        t1.start();
        t2.start();
    }
}
