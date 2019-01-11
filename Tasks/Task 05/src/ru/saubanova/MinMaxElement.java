package ru.saubanova;

public class MinMaxElement {

    public static int minValue (int[] arr){
        int minVal = arr[0];
        // поиск минимального
        for (int i = 1; i < arr.length; i++) {
            if (minVal > arr[i]) {
                minVal = arr[i];
            };
        }
        return minVal;
    }

    public static int maxValue (int[] arr){
        int maxVal = arr[0];
        // поиск максимального
        for (int i = 1; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            };
        }
        return maxVal;
    }

    public static void main(String[] args) {
        //инициализация массива
        int arr[] = {10, 13, 1, 34, 55, 10, 8, 9, 44, 100};
        // вывод найденных значений
        System.out.println("Минимальное значение: " + minValue(arr));
        System.out.println("Максимальное значение: " + maxValue(arr));
    }
}
