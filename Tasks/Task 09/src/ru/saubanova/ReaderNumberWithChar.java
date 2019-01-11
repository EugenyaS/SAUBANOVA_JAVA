package ru.saubanova;

import java.util.Scanner;

public class ReaderNumberWithChar {

    public static int convertCharToInt(char[] arrOfChar) {
        int intResult = 0;
        for (int i = 0; i < arrOfChar.length; i++) {
            intResult = intResult * 10 + arrOfChar[i] - '0';
        }
        return intResult;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char arrOfChar[] = scanner.nextLine().toCharArray();
        System.out.println(convertCharToInt(arrOfChar));
    }
}
