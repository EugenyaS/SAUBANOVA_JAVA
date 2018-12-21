package ru.saubanova;

public class SelectionSort {

    public static void main(String[] args) {
        // write your code here
        int arr[] = {12, 32, 1, 12, 34, 54, 24, 55, 3, 6, 10, 9};
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
                tmp = arr[i];
                arr[i] = arr[minValueInd];
                arr[minValueInd] = tmp;
            }
        }
        for (int i =0; i < arr.length; i++) {
            System.out.println("a[" + i + "] = " + arr[i]);
        }
    }
}
