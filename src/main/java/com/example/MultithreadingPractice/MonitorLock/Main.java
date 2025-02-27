package com.example.MultithreadingPractice.MonitorLock;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {

      SharedMonitorLock monitorLock=new SharedMonitorLock();

      Thread t1=new Thread(monitorLock::task1);
        Thread t2=new Thread(monitorLock::task2);
        Thread t3=new Thread(monitorLock::task3);

        t1.start();
        t2.start();
        t3.start();
    }

    }
