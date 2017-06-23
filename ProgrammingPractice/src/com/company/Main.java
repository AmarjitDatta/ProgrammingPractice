package com.company;

import com.utils.CustomCallable;
import com.utils.Multithreading;
import com.utils.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    long startTime, endTime, startTime2, endTime2;
    long startNumber, endNumber, partitionSize;
    int numberOfThreads;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter following information: ");
    System.out.print("Enter start number: ");
    startNumber = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter end number: ");
    endNumber = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter partition size: ");
    partitionSize = Integer.parseInt(scanner.nextLine());
    scanner.close();

    Resource resource = new Resource();
    resource.setStartValue(startNumber);
    resource.setEndValue(endNumber);

    startTime = System.nanoTime();
    long result = 0;
    for (long i = startNumber; i <= endNumber; i++) {
      result += i;
    }
    endTime = System.nanoTime();
    System.out.println("Single thread value: " + result);
    System.out.println("Execution time without multithreading: " + (endTime - startTime) / 1000000.0);

    ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //ExecutorService executors = Executors.newCachedThreadPool();
    List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
    long end = partitionSize;
    while (startNumber < endNumber) {
      tasks.add(new CustomCallable(resource, startNumber, end));
      startNumber = end + 1;
      end = end + partitionSize;
      if (end > endNumber) {
        end = endNumber;
      }
    }

    startTime2 = System.nanoTime();
    List<Future<Object>> futures = executors.invokeAll(tasks);
    endTime2 = System.nanoTime();

    try {
      for (int i = 0; i < futures.size(); i++) {
        System.out.println("What is in get? " + (long) futures.get(i).get());
      }
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("Result: " + resource.getResult());
    System.out.println("Execution time: " + (endTime2 - startTime2) / 1000000.0);
    executors.shutdown();
  }
}
