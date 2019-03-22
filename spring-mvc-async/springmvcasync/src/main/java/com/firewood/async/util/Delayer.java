package com.firewood.async.util;

public class Delayer {
    public static void threadSleep() {
        try {
            for (int i=0;i<5;i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
