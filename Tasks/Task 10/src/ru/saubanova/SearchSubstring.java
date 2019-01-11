package ru.saubanova;

import java.util.Scanner;

public class SearchSubstring {

    public static int positionSubstring(char[] mString, char[] sString) {
        int position = -1;
        int i = 0;
        int j = 0;
        while (position == -1 && i < mString.length - sString.length + 1) {
            if (mString[i] == sString[0]) {
                position = i;
                j = 0;
                while (position != -1 && j < sString.length) {
                    if (mString[i + j] != sString[j]) {
                        position = -1;
                    }
                    j++;
                }
            }
            i++;
        }
        return position;
    }

    public static void printCharArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char mainString[] = scanner.nextLine().toCharArray();
        char subString[] = scanner.nextLine().toCharArray();
        System.out.print("Строка \"");
        printCharArray(subString);
        System.out.print("\" входит в строку \"");
        printCharArray(mainString);
        System.out.println("\", начиная с позиции: " + positionSubstring(mainString, subString));
    }
}
