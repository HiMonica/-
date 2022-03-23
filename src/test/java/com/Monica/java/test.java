package com.Monica.java;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        FutureTask futureTask = new FutureTask<>(myTest);
        futureTask.run();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}

class MyTest implements Callable{
    @Override
    public Object call() throws Exception {
        return null;
    }
}
