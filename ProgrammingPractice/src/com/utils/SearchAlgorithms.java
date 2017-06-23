package com.utils;

public class SearchAlgorithms {
  public int linearSearch(Integer[] array, int value) {
    int length = array.length;

    for (int i = 0; i < length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  public int binarySearch(Integer[] array, int value) {
    /*we are assuming that the array is already sorted*/
    int startIndex = 0;
    int endIndex = array.length - 1;

    while (startIndex < endIndex) {
      int middleIndex = (startIndex + endIndex) / 2;
      if (array[middleIndex] == value) {
        return middleIndex;
      }
      else if (array[middleIndex] > value) {
        /*search to the left half*/
        endIndex = middleIndex - 1;
      }
      else {
        startIndex = middleIndex + 1;
      }
    }
    return -1;
  }
}
