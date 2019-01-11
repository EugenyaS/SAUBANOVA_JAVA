package ru.saubanova;

public class SelectionSort {
    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("}");
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort (int[] arr){
        int minValueInd;
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            minValueInd = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minValueInd] > arr[j]) {
                    minValueInd = j;
                }
            }
            if (arr[i]!=arr[minValueInd]) {
                swap(arr, i, minValueInd);
            }
        }
    }
    public static void main(String[] args) {
        // write your code here
        int arr[] = {12, 32, 1, 12, 34, 54, 24, 55, 3, 6, 10, 9};
        System.out.println("До сортировки: ");
        printArray(arr);
        sort(arr);
        System.out.println("После сортировки: ");
        printArray(arr);
    }
}
