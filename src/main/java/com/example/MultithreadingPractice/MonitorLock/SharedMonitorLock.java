package com.example.MultithreadingPractice.MonitorLock;

public class SharedMonitorLock {

    public synchronized void task1()
    {
        try {
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("task1 completed");
        }
        catch (Exception ex)
        {

        }
    }

    public  void task2()
    {
        System.out.println("task2 before synchronized");
        synchronized (this)
        {
            System.out.println("task2 inside inside synchronized");
        }
    }
    public void task3()
    {
        System.out.println("task3 ");
    }

}
