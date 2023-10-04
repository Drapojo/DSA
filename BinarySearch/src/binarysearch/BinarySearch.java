/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.*;

/**
 *
 * @author vdqvi
 */
public class BinarySearch {

    static Random rd = new Random();
    
    private static ArrayList<Integer> BinarySearch(int[] array, int start, int end, int x) {
        ArrayList<Integer> listIndex = new ArrayList<>();
        if(start<=end) {
            if (x == array[(end + start) / 2]) {
                listIndex.add((end + start) / 2);
                listIndex.addAll(BinarySearch(array, (end + start) / 2 + 1, end, x));
                listIndex.addAll(BinarySearch(array, start, (end + start) / 2 - 1, x));
            } else if (x > array[(end + start) / 2] && start < end) {
                listIndex.addAll(BinarySearch(array, (end + start) / 2 + 1, end, x));
            } else if (x < array[(end + start) / 2] && start < end) {
                listIndex.addAll(BinarySearch(array, start, (end + start) / 2 - 1, x));
            }
        }
        return listIndex;
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

    public static void printArray(int[] array) {
        System.out.print("Sorted array:");
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
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]>array[i+1]) return false;
        }
        return true;
    }
    public static void BinarySearchHelp(int[] array, int x) throws Exception {
        if(array.length==0) throw new Exception("Array null");
        else if(!isSorted(array)) throw new Exception("Array is unsorted");
        else System.out.println(BinarySearch(array, 0, array.length-1, x).toString());
    }
    
}
