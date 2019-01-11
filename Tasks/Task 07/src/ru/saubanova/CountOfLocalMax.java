package ru.saubanova;

import java.util.Scanner;

public class CountOfLocalMax {

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

    public static int countLocalOfMax(int[] arr) {
        int cntLocalMax = 0;
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i - 1] < arr[i] && arr[i] < arr[i + 1]) {
                cntLocalMax++;
            }
        }
        return cntLocalMax;
    }

    public static void main(String[] args) {
        // массив  со значениями
        int arr[] = {123, 22, 34, 35, 11, 34, 56, 78, 2, 3, 3, 4, 1};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Массив: ");
        printArray(arr);
        System.out.println("Количество локальных максимумов: " + countLocalOfMax(arr));
    }
}
