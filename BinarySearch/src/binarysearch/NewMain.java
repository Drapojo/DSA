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
public class NewMain {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int[] array = BinarySearch.randomArray(inputArray());
        array = BinarySearch.mergeSort(array);
        BinarySearch.printArray(array);
        System.out.println("Enter search value:");
        int x = input.nextInt();
        BinarySearch.BinarySearchHelp(array, x);
    }

    public static int inputArray() {
        int n = 0;
        boolean isValid;
        do {
            isValid = true;
            try {
                System.out.println("Enter number of array:");
                n = input.nextInt();
            } catch (Exception e) {
                isValid = false;
                System.out.println("Please input a number equal or greater than zero");
                input.next();
            }
            if (n < 0) {
                isValid = false;
                System.out.println("Please input a number equal or greater than zero");
            }
        } while (!isValid);
        return n;
    }
}
