package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lectures {
    public static void main(String [] args){
        int[] array1 = new int[]{89, 5,2, 1, 89, 234, 23, 1, 65, 100};
//        BubblSort(array1);               // Алгоритм пузырьковой сортировки.
//        System.out.println(Arrays.toString(array1));
//        sortByChoice(array1);            // Алгоритм сортировки выбором.
//        System.out.println(Arrays.toString(array1));
//        SottByInsert(array1);            // Алгоритм сортировки вставкой.
//        System.out.println(Arrays.toString(array1));
//
//        System.out.println(SimpleSearch(89, array1));   // Алгоритм простого поиска.
//        System.out.println(BinarySearch(89, SottByInsert(array1),  0, array1.length - 1));   //Алгоритм бинарного поиска (требует отсортированный массив).
//
//        QuickSort(array1, 0, array1.length-1);

        SortByHeapOne(array1);
        System.out.println(Arrays.toString(array1));
    }
    // Простая сортировка (пузырьком):
    public static void BubblSort(int[] array){
        boolean needSort;
        do{
            needSort = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i]=array[i+1];
                    array[i+1] = temp;
                    needSort = true;
                }
            }
        }
        while (needSort);
    }
    //  Сортировка выбором:
    public static int[] sortByChoice(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
        return array;
    }
    // Сортировка вставками:
    public static int[] SottByInsert (int[]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }
    // Простой поиск, возвращает первое вхождение:
    public  static  int SimpleSearch (int value, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
    // Бинарный поиск, возвращает второе вхождение в сортированном списке:
    public static int BinarySearch (int value, int[]sortedArray, int min, int max){
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) /2 + min;
        }
        if (sortedArray[midpoint] < value) {
            return BinarySearch(value, sortedArray, midpoint +1, max);
        } else {
            if (sortedArray[midpoint] > value) {
                return BinarySearch(value, sortedArray, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
    // Быстрая сортировка:
    public static int[] QuickSort (int[]array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition ++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition --;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition ++;
                rightPosition --;
            }
        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            QuickSort(array, leftPosition,endPosition);
        }
        if (startPosition < rightPosition) {
            QuickSort(array, startPosition, rightPosition);
        }
        return array;
    }
    // Сщртировка кучей (пирамидальная):
    public  static void SortByHeapOne (int[]array) {
        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            SortByHeapTwo(array, array.length, i);
        }
            for (int i = array.length-1; i >= 0 ; i--) {
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;
                SortByHeapTwo(array, i, 0);
            }
        }
    private static void SortByHeapTwo (int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            SortByHeapTwo(array, heapSize, largest);
        }
    }
}

