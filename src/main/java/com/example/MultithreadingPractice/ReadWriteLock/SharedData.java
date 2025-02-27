package com.example.MultithreadingPractice.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData {
    private int value = 0; // Shared variable
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // READ operation (only reads, no modifications allowed)
    public int readData() {
        lock.readLock().lock();  // Acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() + " is reading: " + value);
            Thread.sleep(4000);  // Simulate a read delay
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.readLock().unlock();  // Release read lock
            System.out.println(Thread.currentThread().getName() + " finished reading.");
        }
    }
    // WRITE operation (only writes, ensures no reads happen at the same time)
    public void writeData(int newValue) {
        lock.writeLock().lock();  // Acquire write lock
        try {
            System.out.println(Thread.currentThread().getName() + " is writing: " + newValue);
            value = newValue;
            Thread.sleep(4000);  // Simulate a write delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();  // Release write lock
            System.out.println(Thread.currentThread().getName() + " finished writing.");
        }
    }
}