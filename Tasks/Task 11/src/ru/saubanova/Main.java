package ru.saubanova;

import java.util.Scanner;

public class Main {

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

    public static void sort(int[] arr) {
        int minValueInd;
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            minValueInd = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minValueInd] > arr[j]) {
                    minValueInd = j;
                }
            }
            if (arr[i] != arr[minValueInd]) {
                swap(arr, i, minValueInd);
            }
        }
    }

    public static int[] readNewArray() {
        Scanner scanner = new Scanner(System.in);
        String newStringArray = scanner.nextLine().toString();
        int indChar = 0;
        int fromChar = 0;
        int cnt = 0;
        while (indChar > -1) {
            indChar = newStringArray.indexOf(',', fromChar);
            if (indChar != -1) {
                cnt++;
            }
            fromChar = indChar + 1;
        }
        int resArr[] = new int[cnt + 1];
        indChar = 0;
        fromChar = 0;
        for (int j = 0; j <= cnt; j++) {
            indChar = newStringArray.indexOf(',', indChar + 1);
            if (indChar != -1) {
                resArr[j] = Integer.parseInt(newStringArray.substring(fromChar, indChar));
            } else {
                resArr[j] = Integer.parseInt(newStringArray.substring(fromChar, newStringArray.length()));
            }
            fromChar = indChar + 1;
        }
        return resArr;
    }

    public static int calcMiddle(int l, int r) {
        return l + (r - l) / 2;
    }

    public static int binarySearch(int[] arr, int needInt) {
        int left = 0;
        int right = arr.length - 1;
        int middle = calcMiddle(left, right);
        while (arr[middle] != needInt) {
            if (arr[left] == needInt) {
                middle = left;
            } else if (arr[right] == needInt) {
                middle = right;
            } else if (arr[middle] < needInt) {
                left = middle;
                middle = calcMiddle(left, right);
            } else {
                right = middle;
                middle = calcMiddle(left, right);
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        // write your code here
        int arr[] = readNewArray();
        System.out.println("До сортировки: ");
        printArray(arr);
        sort(arr);
        System.out.println("После сортировки: ");
        printArray(arr);
        Scanner scanner = new Scanner(System.in);
        int needInt = scanner.nextInt();
        System.out.println("Позиция числа " + needInt + " в отсортированном массиве: " + binarySearch(arr, needInt)
        );
    }
}
