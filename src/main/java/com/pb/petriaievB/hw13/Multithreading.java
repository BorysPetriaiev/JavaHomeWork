package com.pb.petriaievB.hw13;

import java.util.*;

public class Multithreading {
    public static Queue<Integer> queue = new PriorityQueue<>();
    public static void produce () {
        Random r = new Random();
        while (true) {
            synchronized (queue) {
                if (queue.size() != 5) {
                    int x = r.nextInt(100);
                    queue.offer(x);
                    System.out.println("Добавлен элемент " + x);
                    System.out.println("Размер очереди в producer: " + queue.size());
                    queue.notify();
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void consume() {
        while (true) {
            synchronized (queue) {
                if (queue.size() > 0) {
                    int x = queue.poll();
                    System.out.println("Изъят элемент " + x);
                    System.out.println("Размер очереди в consumer: " + queue.size());
                    queue.notify();
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {


        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                produce();
            }

        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                consume();
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