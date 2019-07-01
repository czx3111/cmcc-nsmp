package com.ultrapower.web;


import org.junit.Test;

public class Ticket implements Runnable {

    private int i =300;
    private Object lock=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if (i>0){
                    i=i-1;
                    System.out.println(Thread.currentThread().getName()+"剩余票数 = " + i);
                }
            }
        }

    }

    @Test
    public void Test1() {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        Thread thread4 = new Thread(ticket);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}