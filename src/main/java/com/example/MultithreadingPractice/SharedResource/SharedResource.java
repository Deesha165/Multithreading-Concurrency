package com.example.MultithreadingPractice.SharedResource;

public class SharedResource {

    boolean itemAvailable=false;

    public synchronized void addItem()
    {
        itemAvailable=true;
        System.out.println("item added by "+ Thread.currentThread().getName()+ "and all waiting threads are notified");
        notifyAll();

    }

    public synchronized void consumeItem()
    {
        System.out.println("ConsumeItem method has invoked by "+ Thread.currentThread().getName());
        while (!itemAvailable)
        {
            try{
                System.out.println("Thread "+Thread.currentThread().getName()+" is waiting");
                wait();
            }
            catch (Exception ex)
            {

            }
        }
        System.out.println("Item consumed by "+ Thread.currentThread().getName());
        itemAvailable=false;

    }


}
