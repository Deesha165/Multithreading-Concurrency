package com.example.MultithreadingPractice.ReadWriteLock;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

        SharedData sharedData = new SharedData();

        // Create multiple reading threads
        Thread reader1 = new Thread(sharedData::readData, "Reader-1");
        Thread reader2 = new Thread(sharedData::readData, "Reader-2");

        // Create a writing thread
        Thread writer = new Thread(() -> sharedData.writeData(42), "Writer");

        writer.start();
        reader1.start();
        reader2.start();

    }



}
