package org.example.Queue;

import java.util.Stack;

public class QueueImplUsing2Stacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueImplUsing2Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    //NOTE : Queue<Integer> qu = new LinkedList<>();
    // since I want Queue to be formed by utilizing LinkedList as class implementation hence the internal ,
    // methods of Queue are --> add(int data), remove(), peek()


    // Intuition

    // So keep on pushing data to 2nd Stack (stack2) until the 1st Stack (stack1) is empty,
    //once stack1 is empty add the new data in stack1, once new data is added in stack1,
    //transfer all the other data back to stack1 from stack2, and do this transfer until stack2 is empty.

    //Note: 1st time both the Stacks will be empty, start visualizing from here,
    //it will be easy to see the data in Stack similar to that of Queue (FiFO)

    public void add(int data) {// push() if you use ArrayDeque() as class impl rather than LinkedList
        // This will take O(N)

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(data);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int remove() { //pop() if you use ArrayDeque() as class impl rather than LinkedList
        // This will take O(1)
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int peek() {
        // This will take O(1)
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        // This will take O(1)
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        QueueImplUsing2Stacks que = new QueueImplUsing2Stacks();

        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        que.add(9);

        while (!que.isEmpty()) {
            System.out.println(que.peek());
            que.remove();
        }

    }
}
