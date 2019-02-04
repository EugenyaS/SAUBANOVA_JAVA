package ru.saubanova;

public class Main {
    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        list.add(1);
        list.add(2);
        list.print("Add");
        list.add(3);
        list.print("Add");
        list.addToBegin(0);
        list.print("AddToBegin");
        list.add(5);
        list.insert(4, 4);
        list.print("Insert");
        list.reverse();
        list.print("Перевернут");
        System.out.println("индекс 2 - "+list.indexOf(2));
        System.out.println("индекс 10 - "+list.indexOf(10));
        System.out.println("Элемент 2 - "+list.contains(2));
        System.out.println("Элемент 10 - "+list.contains(10));
        System.out.println("Элемент с ииндексом 3 - "+list.get(3));
        System.out.println("Элемент с ииндексом 100 - "+list.get(100));
        System.out.println("Элемент с ииндексом -10 - "+list.get(-10));
        list.sort();
        list.print("Сортировка ");
    }
}
