package ru.saubanova;

public class IntegerLinkedList implements IntegerList {
    private Node top;
    private Node tail;
    private int count;

    private void swap (Node i, Node j){
        int tmp;
        tmp = i.getValue();
        i.setValue(j.getValue());
        j.setValue(tmp);
    }
    private Node getNode(int index) {
        if (index > 0 && index < getCount()) {
            Node iNode = top;
            for (int i = 0; i < index - 1; i++) {
                iNode = iNode.getNextNode();
            }
            return iNode;
        } else return null;
    }

    @Override
    public void add(int element) {
        Node newNode = new Node(element);
        if (tail != null) {
            tail.setNextNode(newNode);
        } else
            top = newNode;
        tail = newNode;
        count++;
    }

    @Override
    public void addToBegin(int element) {
        Node newNode = new Node(element);
        newNode.setNextNode(top);
        top = newNode;
        count++;
    }

    @Override
    public int get(int index) {
        if (index < getCount() && index > 0) {
            Node currentNode = top;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        }
        return -1;
    }

    @Override
    public void insert(int element, int index) {
        if (index < getCount() && index > 0) {
            Node newNode = new Node(element);
            Node currentNode = top;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
            count++;
        } else System.err.println("не верный индекс");
    }

    @Override
    public void reverse() {
        Node beginNode = top;
        Node endNode = tail;
        for (int i = 0; i < getCount() / 2; i++) {
            swap(beginNode, endNode);
            beginNode = beginNode.getNextNode();
            endNode =getNode(getCount() - i-1);
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void sort() {


    }

    @Override
    public boolean contains(int element) {
        Node currentNode = top;
        int i = 0;
        while (currentNode != null) {
            if (currentNode.getValue() == element) {
                return true;
            } else {
                currentNode=currentNode.getNextNode();
                i++;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int element) {
        Node currentNode = top;
        int i = 0;
        while (currentNode != null) {
            if (currentNode.getValue() == element) {
                return i;
            } else {
                currentNode=currentNode.getNextNode();
                i++;
            }
        }
        return -1;
    }

    @Override
    public void print(String msg) {
        System.out.print(msg + ": " + "{");
        Node currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.getValue());
            if (currentNode.getNextNode() != null) {
                System.out.print(",");
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println("}");
    }
}
