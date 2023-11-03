package org.example.Queue;


public class QueueImplUsingArray {

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

}
 class QueueArray {
    int[] arr;
    int size;

    QueueArray(int size) {
        arr = new int[size];
        this.size = size;
    }


    // so the functions we need to do is enqueue i.e., add() , and dequeue i.e., remove() and peek()
    int rear = -1;

    // initially let the rear does not point to any index, if it's 0 then it
    // illustrates a data is already present in queue at 0th index
    //NOTE: here we will not use another variable int front = -1, as we know that the first index in array os front by default

    public void add(int data) {
        if (size-1 == rear) {
            System.out.println("The data cannot be added as the queue is full");;
        } else {
            arr[++rear] = data;
        }
    }

    public int remove() {
        int front = -1;
        if (rear >= 0) {
            front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
        }
        return front;
    }

    public int peek() {
        if (rear >= 0) {
            return arr[0];
        }
        return -1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }
}

