package ru.saubanova;

public interface IntegerList {
    void add(int element); // добавление в конец
    void addToBegin(int element); // добавление в начало
    int get(int index); // получить элемент по индексу
    void insert(int element, int index); // вставить по индексу со сдвигом
    void reverse();
    int getCount();
    void sort();
    boolean contains(int element); // возвращает true, если список содержит заданный элемент
    int indexOf(int element); // возвращает индекс элемента, если он есть в списке, -1 - если не нашел ничего
    void print(String msg); // печать списка
}
