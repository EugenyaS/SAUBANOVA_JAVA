package ru.saubanova;

public class CountOfLocalMax {

    public static void main(String[] args) {
	// write your code here
        // массив  со значениями
        int arr[] = {123,22,34,35,11,34,56,78,2,3,3,4,1};
        int cntLocalMax = 0;
        for (int i = 1; i < arr.length-2; i++) {
            if (arr[i-1]<arr[i] & arr[i]<arr[i+1]){
                cntLocalMax++;
            }
        }
        System.out.println("Количество локальных максимумов: "+cntLocalMax);
    }
}
