package org.multithreading;

import java.util.LinkedList;

/*

Implement a Bounded Blocking Queue
Problem: Create a class BoundedBlockingQueue using wait() and notify().

 */
public class BoundedBlockingQueue<T> {
    private Object lock = new Object();
    private LinkedList<T> queue = new LinkedList<>();
    private final int maxSize = 10;

    public LinkedList<T> getQueue() {
        return queue;
    }

    public void enqueue(T element){
        synchronized (lock) {
            while (queue.size() >= maxSize){
                {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("exception occurred!!!");
                    }
                }
            }
            queue.addLast(element);
            System.out.println(Thread.currentThread().getName()+" : "+element + " : "+queue);

            lock.notifyAll();
        }
    }

    public T dequeue(){
        synchronized (lock) {
            while (queue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("exception occurred!!!");
                }
            }

            T element = queue.getLast();
            queue.removeLast();
            System.out.println(Thread.currentThread().getName()+" : "+element + " : "+queue);
            lock.notifyAll();
            return element;
        }
    }
}

class QueueMainClass{
    public static void main(String[] args) {
        BoundedBlockingQueue<Integer> bq=new BoundedBlockingQueue<>();
        Thread t= new Thread(()->{
            bq.enqueue(1);
            bq.enqueue(2);
            bq.enqueue(3);
            bq.enqueue(4);
            bq.dequeue();
            bq.dequeue();
        });
        Thread t2= new Thread(()->{
            bq.enqueue(3);
            bq.enqueue(4);
            bq.enqueue(5);
            bq.enqueue(6);
            bq.dequeue();
        });
        t.start();
        t2.start();
        System.out.println(bq.getQueue());
    }
}