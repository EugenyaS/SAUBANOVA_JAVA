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
        while (value != -1) {
            // вычисляем сумму цифр числа
            // проверяем является ли сумма простой
            // если да, умножаем
            // считываем следующее значение и увеличиваем позицию
            value = scanner.nextInt();
            pos ++;
        }
        // выводим произведение позиций
        System.out.println("Произведение позиций введенных чисел, сумма цифр которых является простым числом:");
        System.out.println(multPos);
    }
}
