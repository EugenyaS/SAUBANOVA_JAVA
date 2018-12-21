package ru.saubanova;

import java.util.Scanner;

public class MultPosOfNumbWithPrimeSumDigits {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        // входное число
        int value = scanner.nextInt();
        // позиция
        int pos = 1;
        // произведение позиций
        int multPos = 1;
        // сумма цифр числа
        int sum;
        // сумма - простое число
        boolean isPrime;
        // делитель
        int divider;
        while (value != -1) {
            sum = 0;
            divider = 2;
            // вычисляем сумму цифр числа
            while (value != 0) {
                sum = sum+value % 10;
                value /= 10;
            }
            if (sum == 1 ){
                isPrime = false;
            }
            else{
                isPrime = true;
                if (sum != 2) {
                    // проверяем является ли сумма простой
                    while (divider * divider <= sum) {
                        if (sum % divider == 0) {
                            isPrime = false;
                            break;
                        }
                        divider++;
                    }
                }
            }
            // если да, умножаем
            if (isPrime) {
                multPos *= pos;
            }
            // считываем следующее значение и увеличиваем позицию
            value = scanner.nextInt();
            pos++;
        }
        // выводим произведение позиций
        System.out.println("Произведение позиций введенных чисел, сумма цифр которых является простым числом:");
        System.out.println(multPos);
    }
}
