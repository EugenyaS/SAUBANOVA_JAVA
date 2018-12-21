package ru.saubanova;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.print("{");
        for (int i = arr.length-1; i >= 0 ; i--) {
            System.out.print(arr[i]);
            if (i>0){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
