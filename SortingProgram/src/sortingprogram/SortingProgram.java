/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingprogram;

import java.util.*;

/**
 *
 * @author vdqvi
 */
public class SortingProgram {

    static Random rd = new Random();

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

//
//    public static int[] myQuickSort(int[] array) {
//        int pivot = array[array.length - 1];
//        ArrayList<Integer> left = new ArrayList<>();
//        ArrayList<Integer> right = new ArrayList<>();
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] <= pivot) {
//                left.add(array[i]);
//            } else {
//                right.add(array[i]);
//            }
//        }
//        int[] newLeft = new int[left.size()];
//        for (int i = 0; i < left.size(); i++) {
//            newLeft[i] = left.get(i);
//        }
//        int[] newRight = new int[right.size()];
//        for (int i = 0; i < right.size(); i++) {
//            newRight[i] = right.get(i);
//        }
//        if (newLeft.length > 2) {
//            newLeft = myQuickSort(newLeft);
//        }
//        if (newRight.length > 2) {
//            newRight = myQuickSort(newRight);
//        }
//        System.arraycopy(newLeft, 0, array, 0, newLeft.length);
//        array[newLeft.length] = pivot;
//        System.arraycopy(newRight, 0, array, newLeft.length + 1, newRight.length);
//        return array;
//    }
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = array[end];
            int i = start, j = end;
            while (i < j) {
                while (array[i] < pivot && i < j) {
                    i++;
                }
                while (array[j] >= pivot && i < j) {
                    j--;
                }
                if (i < j) {
                    swap(array, i, j);
                }
            }
            swap(array, i, end);
            quickSort(array, start, i - 1);
            quickSort(array, i + 1, end);
        }
    }

    public static int[] mergeSort(int[] array) {
        int[] Left = new int[(int) Math.ceil((float) array.length / 2)];
        int[] Right = new int[array.length / 2];
        System.arraycopy(array, 0, Left, 0, Left.length);
        System.arraycopy(array, Left.length, Right, 0, Right.length);
        if (Left.length > 1 && Right.length >= 1) {
            Left = mergeSort(Left);
            Right = mergeSort(Right);
        }
        int[] afterMergeArray = new int[array.length];
        int n, i, j;
        n = i = j = 0;
        while (i < Left.length && j < Right.length) {
            if (Left[i] <= Right[j]) {
                afterMergeArray[n++] = Left[i++];
            } else {
                afterMergeArray[n++] = Right[j++];
            }
        }
        while (i < Left.length) {
            afterMergeArray[n++] = Left[i++];
        }

        while (j < Right.length) {
            afterMergeArray[n++] = Right[j++];
        }
        return afterMergeArray;
    }

    private static void heapify(int[] array, int index, int n) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, index, largest);
            heapify(array, largest, n);
        }
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
    }

    public static void bucketSort(int[] array) {
        ArrayList<Integer>[] listBucket = new ArrayList[array.length];
        for (int i = 0; i < array.length; i++) {
            listBucket[i] = new ArrayList<>();
        }
        for (int i = 0; i < array.length; i++) {
            int indexBucket = array[i] * array.length % 10;
            listBucket[indexBucket].add(array[i]);
        }
        for (ArrayList<Integer> list : listBucket) {
            if (!list.isEmpty()) {
                quickSortForArrayList(list, 0, list.size() - 1);
            }
        }
        int index = 0;
        for (ArrayList<Integer> i : listBucket) {
            if (!i.isEmpty()) {
                for (int j : i) {
                    array[index++] = j;
                }
            }
        }

    }

    public static void quickSortForArrayList(ArrayList<Integer> arrayList, int start, int end) {
        if (start < end) {
            int pivot = arrayList.get(end);
            int i = start, j = end;
            while (i < j) {
                while (arrayList.get(i) < pivot && i < j) {
                    i++;
                }
                while (arrayList.get(j) >= pivot && i < j) {
                    j--;
                }
                if (i < j) {
                    swapForArrayList(arrayList, i, j);
                }
            }
            swapForArrayList(arrayList, i, end);
            quickSortForArrayList(arrayList, start, i - 1);
            quickSortForArrayList(arrayList, i + 1, end);
        }
    }

    public static void radixSort(int[] array, int timer) {
        ArrayList<Integer>[] listBucket = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            listBucket[i] = new ArrayList<>();
        }
        for (int i = 0; i < array.length; i++) {
            listBucket[array[i] / (int) Math.pow(10, timer) % 10].add(array[i]);
        }
        int index = 0;
        for (int i = 0; i < listBucket.length; i++) {
            if (!listBucket[i].isEmpty()) {
                for (int j : listBucket[i]) {
                    array[index++] = j;
                }
            }
        }
        if (listBucket[0].size() != array.length) {
            radixSort(array, ++timer);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void swapForArrayList(ArrayList<Integer> arrayList, int i, int j) {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    public static int[] randomArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rd.nextInt(n);
        }
        return array;
    }
}
