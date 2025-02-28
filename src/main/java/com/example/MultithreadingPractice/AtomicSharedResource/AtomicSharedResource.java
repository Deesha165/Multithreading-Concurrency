package com.example.MultithreadingPractice.AtomicSharedResource;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSharedResource {


    private final AtomicInteger counter=new AtomicInteger(0);
    public  void addCount()
    {
        counter.getAndIncrement();
    }
    public int getCount()
    {
        return counter.get();
    }
}
