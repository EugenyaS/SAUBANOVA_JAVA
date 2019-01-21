package ru.saubanova;

public class ArrayList {
    public static int MAX_SIZE = 100;

    private int array[];
    private int countOfElements;

    private void swap(int i, int j) {
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    public ArrayList() {
        this.array = new int[MAX_SIZE];
        countOfElements = 0;
    }

    public ArrayList(int[] array) {
        this.array = new int[MAX_SIZE];
        int maxIndex = array.length < MAX_SIZE ? array.length - 1 : MAX_SIZE - 1;
        for (int i = 0; i < maxIndex; i++) {
            this.array[i] = array[i];
        }
        countOfElements = maxIndex + 1;
    }

    public int get(int index) {
        if (index < countOfElements) {
            return this.array[index];
        } else {
            return -1;
        }
    }

    public int getCountOfElements() {
        return countOfElements;
    }


    public void printArray(String msg) {
        System.out.print(msg + ": " + "{");
        for (int i = 0; i < this.array.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(this.array[i]);
        }
        System.out.println("}");
    }

    public void add(int element) {
        if (countOfElements < this.array.length) {
            this.array[countOfElements] = element;
            countOfElements++;
        }
    }

    public void addToBegin(int element) {
        if (countOfElements < this.array.length - 1) {
            for (int i = countOfElements; i > 0; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[0] = element;
            countOfElements++;
        }
    }

    public void insert(int element, int index) {
        if (index < countOfElements) {
            for (int i = countOfElements; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = element;
            countOfElements++;
        }
    }

    public void reverseArray() {
        int tmp;
        for (int i = 0; i < countOfElements / 2; i++) {
            swap(i, countOfElements - i - 1);
        }
    }


    public void sort() {
        int minValueInd;
        int tmp;
        for (int i = 0; i < countOfElements; i++) {
            minValueInd = i;
            for (int j = i; j < countOfElements; j++) {
                if (this.array[minValueInd] > this.array[j]) {
                    minValueInd = j;
                }
            }
            if (this.array[i] != this.array[minValueInd]) {
                swap(i, minValueInd);
            }
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < countOfElements; i++) {
            if (this.array[i] == element) {
                return true;
            }
        };
        return false;
    }

    public int indexOf(int element) {
        for (int i = 0; i < countOfElements; i++) {
            if (this.array[i] == element) {
                return i;
            }
        }
        return -1;
    }


}
