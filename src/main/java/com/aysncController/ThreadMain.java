package com.aysncController;

import java.util.TreeMap;

public class ThreadMain {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tread starting");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread finisehd");
            }
        });
        thread.setDaemon(true);
        thread.start();
//        thread.join();
        System.out.println("Main thread end");

    }
}
