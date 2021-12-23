package com.pb.petriaievB.hw13;

import java.util.*;

public class Multithreading {
    public static void main(String[] args) {
        Object lock = new Object();
        Queue<Integer> queue = new LinkedList<>();
        Random r = new Random();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (queue.size() != 5) {
                            queue.offer(r.nextInt(100));
                            System.out.printf("Размер очереди в producer: %s\n", queue.size());
                            lock.notify();
                        }
                        else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (queue.size() > 0) {
                            queue.poll();
                            System.out.printf("Размер очереди в consumer: %s\n", queue.size());
                            lock.notify();
                        }
                        else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}