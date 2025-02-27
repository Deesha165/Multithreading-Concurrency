package com.example.MultithreadingPractice.DeamonThread;

public class SharedResource {

    Boolean isAvailable=false;

    public synchronized void produce()
    {
        System.out.println("lock acquired");
        try {

            Thread.sleep(8000);
        }
        catch (Exception ex)
        {

        }
        System.out.println("lock released");

    }
}
