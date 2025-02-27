package com.example.MultithreadingPractice.Await_Signal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    ReentrantLock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    Boolean isAvailable=false;
    public void produce()
    {

        try {
            lock.lock();
            System.out.println("Producer Thread "+Thread.currentThread().getName()+ " acquired  lock "+isAvailable);

            if (isAvailable)
            {
                // already available, producer thread has to be waiting until it is consumed by consumer
                System.out.println("Producer thread is waiting "+ Thread.currentThread().getName()+isAvailable);
                condition.await();
            }
           isAvailable=true;
            condition.signal();
        }
        catch (Exception ex)
        {

        }
        finally {
            lock.unlock();
            System.out.println("Producer Thread "+Thread.currentThread().getName()+ " released lock "+isAvailable);
        }

    }

    public void consume()
    {

        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consumer Thread "+Thread.currentThread().getName()+ " acquired  lock "+isAvailable);

            if (!isAvailable)
            {
                // not available ,consumer thread has to be waiting until it is available by producer
                System.out.println("Consumer thread is waiting "+ Thread.currentThread().getName()+isAvailable);
                condition.await();
            }
            isAvailable=false;
            condition.signal();
        }
        catch (Exception ex)
        {

        }
        finally {
            lock.unlock();
            System.out.println("Consumer Thread "+Thread.currentThread().getName()+ " released lock "+isAvailable);
        }
    }

}

