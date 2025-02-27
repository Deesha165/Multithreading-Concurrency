package com.example.MultithreadingPractice.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    Semaphore lock=new Semaphore(2);

    public void produce()
    {
        try {
            lock.acquire();
            System.out.println("lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(4000);
        }
        catch (Exception ex)
        {

        }
        finally {
            lock.release();
            System.out.println("lock released by "+ Thread.currentThread().getName());
        }


    }
}
