package org.example.Stacks;

import java.util.LinkedList;
import java.util.Queue;

// Intuition
// Step1 : Utilise 2 Queues first declare them and later in constructor initialise them. we need to use these 2 Quesues to achieve Stack functions.
// Step2 : for Push() what we do is we check for q1 not being empty in while loop , till it becomes empty, populate q2, by extracting data from q1.
// Step3 : Now once the q1 is entirely empty, the data which is a new data which needs to be added, can be added in q1. Now in the 2nd while loop ,
// the iteration will be till q2 is empty, that is till q2 is not empty the q1 will be again populated by removing data from q2, and adding in q1. Now
// the new data is first in q1, now it is like stack i.e., in Stack the most lastly added data is removed first. As you can see in q1 , the newly added data
// occupies the 1st spot which will be again LIFO but satisfies Stack removal rule.

public class StackUsing2Queue {

    Queue<Integer> q1;
    Queue<Integer> q2;
    StackUsing2Queue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // So keep on pushing data to 2nd que(q2) untill the 1st queue (q1) is empty.
    //once 1st Queue q1 is empty add the new data (int data) in q1. Once new data is added in q1,
    //transfer all the other data back to q1 from q2, and do this transfer unril q2 is empty.

    //Note: 1st time both the queues will be empty, start visualizing from here,
    //it will be easy to see the data in queue similar to that of stack (LIFO)

    public void push(int data) {

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(data);

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }
    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.remove();
    }

    public int top() { // or peek()
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsing2Queue sq = new StackUsing2Queue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(5);
        sq.push(6);
        sq.push(7);
        sq.push(8);

        while(!sq.isEmpty()) {
            System.out.println(sq.top());
            sq.pop();
        }
    }

}


