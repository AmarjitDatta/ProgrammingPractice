package com.utils;

public class Multithreading implements Runnable {
  private final Resource resource;
  private long localStartIndex = 0;
  private long localEndIndex = 0;

  public Multithreading(Resource resource, long localStartIndex, long localEndIndex) {
    this.resource = resource;
    this.localStartIndex = localStartIndex;
    this.localEndIndex = localEndIndex;
  }

  @Override
  public void run() {
    long result = 0;
    for (long i = localStartIndex; i <= localEndIndex; i++) {
      result += i;
    }
    resource.addSum(result);
  }
}
