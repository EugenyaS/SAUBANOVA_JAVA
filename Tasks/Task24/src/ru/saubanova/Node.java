package ru.saubanova;

public class Node {
    private int value;
    private Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
