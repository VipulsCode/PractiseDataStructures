package org.example.InterviewCodes.pragmaticPay;


public class AtomicIntegerCustom {
    private int value;

    public AtomicIntegerCustom (int value) {
        this.value = value;
    }


    public synchronized int get() {
        return value;
    }

    public synchronized int incrementAndGet() {
        value++;
        return value;
    }

    public synchronized int decrementAndGet() {
        value--;
        return value;
    }

    public static void main(String[] args) {

    }



}

