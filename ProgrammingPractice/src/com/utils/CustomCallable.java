package com.utils;

import java.util.concurrent.Callable;

public class CustomCallable implements Callable {
  private final Resource resource;
  private long localStartIndex = 0;
  private long localEndIndex = 0;

  public CustomCallable(Resource resource, long localStartIndex, long localEndIndex) {
    this.resource = resource;
    this.localStartIndex = localStartIndex;
    this.localEndIndex = localEndIndex;
  }

  @Override
  public Long call() throws Exception {
    long result = 0;
    for (long i = localStartIndex; i <= localEndIndex; i++) {
      result += i;
    }
    resource.addSum(result);

    return result;
  }
}
