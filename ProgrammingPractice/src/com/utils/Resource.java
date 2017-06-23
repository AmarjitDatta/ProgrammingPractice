package com.utils;

public class Resource {
  private long result = 0;
  private long startValue = 0;
  private long endValue = 0;

  public long getStartValue() {
    return startValue;
  }

  public void setStartValue(long startValue) {
    this.startValue = startValue;
  }

  public long getEndValue() {
    return endValue;
  }

  public void setEndValue(long endValue) {
    this.endValue = endValue;
  }

  public long getResult() {
    return result;
  }

  public synchronized void addSum(long partialSum) {
    result += partialSum;
  }
}
