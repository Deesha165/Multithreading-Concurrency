package com.example.MultithreadingPractice.SharedQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {

    Queue<Integer> q= new LinkedList<Integer>();
    int maxSize;
    int limit=0;
    int item=1;
    boolean turn=false;
    public SharedQueue( int size)
    {

        this.maxSize=size;

    }

    public synchronized void consumeQueue() {
        System.out.println("consume method started");

        while (q.size()>=0&&limit<15)
        {
            while (q.size()==0)
            {
                try{
                    System.out.println("consumer thread "+ Thread.currentThread().getName()+" is waiting for producer");
                    wait();
                }
                catch (Exception ex)
                {

                }
            }
            var item=q.poll();
            System.out.println("consumed item " + item+" queue size"+ q.size());
            notifyAll();
            limit++;
        }


    }
    public synchronized void  produceQueue()
    {
        System.out.println("produce method started");
        while (q.size()<=maxSize &&limit<15)
        {
            while (q.size()==maxSize)
            {
                try{
                    System.out.println("producer thread "+ Thread.currentThread().getName()+" is waiting for consumer");
                    wait();
                }
                catch (Exception ex)
                {

                }
            }
            q.add(item);
            System.out.println("produced item is "+ item+ " queue size "+ q.size());
            item++;
            notifyAll();
            limit++;
        }

    }

}
