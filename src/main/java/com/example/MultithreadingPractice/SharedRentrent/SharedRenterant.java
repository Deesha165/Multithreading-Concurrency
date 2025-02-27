package com.example.MultithreadingPractice.SharedRentrent;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedRenterant {
    boolean isAvailable=false;

    public void producer(ReadWriteLock lock)
    {
        try{
            lock.readLock().lock();
            System.out.println("Lock acqiured by: "+ Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(8000);
        }
        catch (Exception ex)
        {

        }
        finally {
            lock.readLock().unlock();

            System.out.println("lock released by :" + Thread.currentThread().getName());
        }
    }
    public void consumer(ReadWriteLock lock)
    {
        try{
            lock.writeLock().lock();
            System.out.println("Lock acqiured by: "+ Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(8000);
        }
        catch (Exception ex)
        {

        }
        finally {
            lock.writeLock().unlock();

            System.out.println("lock released by :" + Thread.currentThread().getName());
        }
    }
}
