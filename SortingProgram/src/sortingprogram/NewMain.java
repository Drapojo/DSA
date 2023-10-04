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
public class NewMain {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        do {
            switch (mainMenu()) {
                case 1: {
                    int[] array = SortingProgram.randomArray(inputArray());
                    System.out.print("Unsorted array:");
                    SortingProgram.printArray(array);
                    switch (sortMenu()) {
                        case 1: {
                            SortingProgram.bubbleSort(array);
                            break;
                        }
                        case 2: {
                            SortingProgram.selectionSort(array);
                            break;
                        }
                        case 3: {
                            SortingProgram.insertionSort(array);
                            break;
                        }
                        case 4: {
                            array = SortingProgram.mergeSort(array);
                            break;
                        }
                        case 5: {
                            SortingProgram.quickSort(array, 0, array.length - 1);
                            break;
                        }
                        case 6: {
                            SortingProgram.heapSort(array);
                            break;
                        }
                        case 7: {
                            SortingProgram.bucketSort(array);
                            break;
                        }
                        case 8: {
                            SortingProgram.radixSort(array, 0);
                            break;
                        }
                    }
                    System.out.print("Sorted array:");
                    SortingProgram.printArray(array);
                    break;
                }
                case 0: {
                    return;
                }
            }
        } while (true);
    }

    public static int sortMenu() {
        int userChoice = 0;
        boolean isValid;
        do {
            isValid = true;
            try {
                System.out.println("1. BubbleSort");
                System.out.println("2. SelectionSort");
                System.out.println("3. InsertionSort");
                System.out.println("4. MergeSort");
                System.out.println("5. QuickSort");
                System.out.println("6. HeapSort");
                System.out.println("7. BucketSort");
                System.out.println("8. RadixSort");
                System.out.print("Your choice: ");
                userChoice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Please input number from 1 to 8");
                isValid = false;
                input.nextLine();
            }
            if (userChoice < 1 || userChoice > 8) {
                System.out.println("Please input number from 1 to 8");
                isValid = false;
            }
        } while (!isValid);
        return userChoice;
    }

    public static int mainMenu() {
        int userChoice = 0;
        boolean isValid;
        do {
            isValid = true;
            try {
                System.out.println("----------SortingProgram----------");
                System.out.println("1. Create new sort");
                System.out.println("0. Exit");
                System.out.print("Your choice: ");
                userChoice = input.nextInt();
                if (userChoice < 0 || userChoice > 1) {
                    System.out.println("Please input 1 or 0");
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("Please input 1 or 0");
                isValid = false;
                input.nextLine();
            }
        } while (!isValid);
        return userChoice;
    }

    public static int inputArray() {
        int n = 0;
        boolean isValid;
        do {
            isValid = true;
            try {
                System.out.println("Enter number of array: ");
                n = input.nextInt();
                if (n < 0) {
                    System.out.println("Please input a number equal or greater than zero");
                    isValid = false;
                }
            } catch (Exception e) {
                System.out.println("Please input a number equal or greater than zero");
                isValid = false;
                input.next();
            }
        } while (!isValid);
        return n;
    }
}
