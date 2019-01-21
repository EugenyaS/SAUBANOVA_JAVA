package ru.saubanova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        ArrayList myArray = new ArrayList();
        for (int i = 0; i < arrayLength-1; i++) {
            if (i%2==0) {
                myArray.add(scanner.nextInt());
                myArray.printArray("Добавлен в конец");
            }
            else {
                myArray.addToBegin(scanner.nextInt());
                myArray.printArray("Добавлен в начало");
            }

        }
        myArray.insert(scanner.nextInt(), arrayLength/2);
        myArray.printArray("Добавлен в середину");
        myArray.reverseArray();
        myArray.printArray("Перевернут");
        myArray.sort();
        myArray.printArray("Отсортирован");

        System.out.println("Размер: "+myArray.getCountOfElements());
        System.out.println("Содержит элемент 10: "+ myArray.contains(10));
        System.out.println("Индекс элемента 10: "+ myArray.indexOf(10));

    }
}
