package com.utils;

public class SortFunctions {
  public void printArray(int[] array) {
    int i;
    System.out.println("Printing array");
    for (i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public void bubbleSort(int[] array) {
    int i, j;
    int length = array.length;
    for (i = 0; i < length - 1; i++) {
      for (j = 0; j < (length - 1 - i); j++) {
        if (array[j] > array[j + 1]) {
          /*swap*/
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public void selectionSort(int[] array) {
    int minIndex;
    int i, curMinIndex = 0, temp;
    int curMinValue = Integer.MAX_VALUE;

    for (minIndex = 0; minIndex < array.length; minIndex++) {
      for (i = minIndex; i < array.length; i++) {
        if (curMinValue > array[i]) {
          curMinValue = array[i];
          curMinIndex = i;
        }
      }
      temp = array[minIndex];
      array[minIndex] = array[curMinIndex];
      array[curMinIndex] = temp;
      curMinValue = Integer.MAX_VALUE;
    }
  }

  public void quickSort(int[] array) {
    int length = array.length;
    performQuickSort(array, 0, length - 1);
  }

  private void performQuickSort(int[] array, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    int pivotIndex = partitionArray(array, startIndex, endIndex);
    performQuickSort(array, startIndex, pivotIndex - 1);
    performQuickSort(array, pivotIndex + 1, endIndex);
  }

  private int partitionArray(int[] array, int startIndex, int endIndex) {
    int pivot = array[endIndex];
    int partitionIndex = startIndex;
    int temp;

    for (int i = startIndex; i < endIndex; i++) {
      if (array[i] < pivot) {
        temp = array[i];
        array[i] = array[partitionIndex];
        array[partitionIndex] = temp;
        partitionIndex++;
      }
    }

    array[endIndex] = array[partitionIndex];
    array[partitionIndex] = pivot;
    return partitionIndex;
  }

  public void mergeSort(int[] array) {
    int length = array.length;
    performMergeSort(array, 0, length - 1);
  }

  private void performMergeSort(int[] array, int start, int end) {
    if (array.length < 2) {
      return;
    }
    else {
      int middleIndex = (end - start + 1)/2;

      int[] left = new int[middleIndex - start];
      int[] right = new int[end - middleIndex + 1];

      for (int i = 0; i < middleIndex; i++) {
        left[i] = array[i];
      }
      for (int i = middleIndex; i <= end; i++) {
        right[i - middleIndex] = array[i];
      }

      performMergeSort(left, 0, middleIndex - 1);
      performMergeSort(right, 0, (end - middleIndex));
      merge(left, right, array);
    }
  }

  private void merge(int[] left, int[] right, int[] array) {
    int i = 0;
    int j = 0;
    int k = 0;

    while(i < left.length && j < right.length) {
      if (left[i] < right[j]) {
        array[k] = left[i];
        k++;
        i++;
      }
      else {
        array[k] = right[j];
        k++;
        j++;
      }
    }
    /*Copy leftover of left*/
    while(i < left.length) {
      array[k] = left[i];
      k++;
      i++;
    }

    /*Copy leftover of right*/
    while (j < right.length) {
      array[k] = right[j];
      k++;
      j++;
    }
  }

  public void bucketSort(int[] array) {

  }
}
