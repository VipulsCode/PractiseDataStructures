package org.example.InterviewCodes.pragmaticPay;

import java.util.Queue;

public class CustomBlockingQueue<T> {
    private final Queue<T> queue;
    private final int capacity;

    public CustomBlockingQueue(Queue<T> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }
     public synchronized void produce(T item) throws InterruptedException {
        while(queue.size() == capacity) {
            wait();
        }
        queue.add(item);
        notifyAll();
     }

    public synchronized T consume() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        T item = queue.poll();
        notifyAll();
        return item;
    }
}
