package com.Monica.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(500000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            },"Thead-" + i).start();
        }
    }
}
