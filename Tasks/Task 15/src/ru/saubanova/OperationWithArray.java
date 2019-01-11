package ru.saubanova;

import java.util.Scanner;

public class OperationWithArray {

    public static void printArray(int[] arr, String msg) {
        System.out.print(msg + ": " + "{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(arr[i]);
        }
        System.out.println("}");
    }

    public static boolean addToEnd(int[] arr, int val, int cnt) {
        boolean result = false;
        if (cnt < arr.length) {
            arr[cnt] = val;
            result = true;
        }
        return result;
    }

    public static boolean addToBegin(int[] arr, int val, int cnt) {
        boolean result = false;
        if (cnt < arr.length - 1) {
            for (int i = cnt; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = val;
            result = true;
        }
        return result;
    }

    public static boolean insByInd(int[] arr, int val, int ind, int cnt) {
        boolean result = false;
        if (ind < cnt && cnt < arr.length - 1) {
            for (int i = cnt; i > ind; i--) {
                arr[i] = arr[i - 1];
            }
            arr[ind] = val;
            result = true;
        }
        return result;
    }

    public static boolean delByInd(int[] arr, int ind, int cnt) {
        boolean result = false;
        if (ind < cnt) {
            for (int i = ind; i < cnt; i++) {
                arr[i] = arr[i + 1];
            }
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        int size = 10;
        int count = 0;
        int value;
        Scanner scanner = new Scanner(System.in);
        printArray(arr, "Массив до изменения");
        value = scanner.nextInt();
        if (addToEnd(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в конец массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        value = scanner.nextInt();
        if (addToEnd(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в конец массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        value = scanner.nextInt();
        if (addToBegin(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в начало массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        value = scanner.nextInt();
        if (addToBegin(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в начало массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        value = scanner.nextInt();
        if (addToEnd(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в конец массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        value = scanner.nextInt();
        if (addToBegin(arr, value, count)) {
            printArray(arr, "Элемент успешно добавлен в начало массива");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
        System.out.println("Введите индекс удаляемого элемента: ");
        int index = scanner.nextInt();
        if (delByInd(arr, index, count)) {
            printArray(arr, "Элемент успешно удален");
            count--;
        } else
            System.out.println("Ошибка при удалении элемента " + index);
        System.out.println("Введите индекс добавляемого элемента: ");
        index = scanner.nextInt();
        System.out.println("Введите добавляемый элемент: ");
        value = scanner.nextInt();
        if (insByInd(arr, value, index, count)) {
            printArray(arr, "Элемент успешно добавлен");
            count++;
        } else
            System.out.println("Ошибка при добавлении элемента " + value);
    }
}
