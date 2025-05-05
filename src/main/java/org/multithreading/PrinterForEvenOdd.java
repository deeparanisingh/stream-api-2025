package org.multithreading;
/*
*
*
Print Even and Odd Numbers using Two Threads
Problem: Thread A prints even numbers, Thread B prints odd numbers — print from 1 to N alternately.

Focus: wait() / notify() or Lock and Condition
*
*
 */
public class PrinterForEvenOdd {
    private int counter = 1;
    private final int MAX = 10;
    public synchronized void printOdd(){
        while (counter<=MAX){
            if(counter%2==1){
                System.out.println("odd : "+counter);
                System.out.println("current thread = "+ Thread.currentThread().getName());
                counter++;
                notify();
            }else{
                try{
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("exception occured");
                }
            }
        }
    }
    public synchronized void printEven(){
        while (counter<=MAX){
            if(counter%2==0){
                System.out.println("even : "+counter);
                System.out.println("current thread = "+ Thread.currentThread().getName());
                counter++;
                notify();
            }else{
                try{
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("exception occured");
                }
            }
        }
    }
}
class OddRunnable implements Runnable{
    private final PrinterForEvenOdd obj;
    OddRunnable(PrinterForEvenOdd obj){
        this.obj=obj;
    }
    @Override
    public void run() {
        obj.printOdd();
    }
}
class EvenRunnable implements Runnable{
    private final PrinterForEvenOdd obj;
    EvenRunnable(PrinterForEvenOdd obj){
        this.obj=obj;
    }
    @Override
    public void run() {
        obj.printEven();
    }
}

class MainClass{
    public static void main(String[] args){
        PrinterForEvenOdd printerObj = new PrinterForEvenOdd();
        Thread t1 = new Thread(new OddRunnable(printerObj));
        Thread t2 = new Thread(new EvenRunnable(printerObj));
        t1.start();
        t2.start();
    }
}
