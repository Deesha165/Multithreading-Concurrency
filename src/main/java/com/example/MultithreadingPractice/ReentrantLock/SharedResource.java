package com.example.MultithreadingPractice.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void produce(ReentrantLock lock)
    {

        try {
            lock.lock();

            System.out.println("Thread "+Thread.currentThread().getName()+ " acquired  lock ");
            Thread.sleep(4000);
        }
        catch (Exception ex)
        {

        }
        finally {
lock.unlock();
            System.out.println("Thread "+Thread.currentThread().getName()+ " released lock ");
        }

    }

}
