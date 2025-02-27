package com.example.MultithreadingPractice.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    Integer counter=10;
    StampedLock lock=new StampedLock();

    public void produce() throws InterruptedException {

        long stamp=lock.tryOptimisticRead();
        try {

            System.out.println("taken optimistic read");
            counter=11;
            if(lock.validate(stamp))
            {
                System.out.println("counter updated successfully");
            }
            else
            {
                //rollback
                System.out.println("rollback of work");
                counter=10;
            }

        }
        catch (Exception ex)
        {

        }

    }
    public void consume() throws InterruptedException {

        long stamp=lock.writeLock();
        System.out.println("write lock acquired by "+ Thread.currentThread().getName());
        try {
             Thread.sleep(6000);
            System.out.println("performing work");

            counter=9;
        }  finally {

            lock.unlockWrite(stamp);
        }
    }
}
