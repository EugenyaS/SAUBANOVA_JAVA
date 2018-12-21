package ru.saubanova;
import java.util.Scanner;

public class LostNumber {
    public static void main(String[] args) {
        int sumAllNumber=0;
        // считаем сумму всех чисел от 1 до 1000
        for (int i = 1; i<=1000; i++){
            sumAllNumber+=i;
        }
        // ввод чисел и вычисление пропущенного
        int number;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 1000; i++) {
            number = scanner.nextInt();
            sumAllNumber -= number;
        }
        System.out.print(sumAllNumber);
    }
}
