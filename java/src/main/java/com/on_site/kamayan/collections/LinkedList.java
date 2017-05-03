package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Use this nested class for storing the values of the LinkedList. Each
    // LinkedList.Node contains the value at its index, and a link to the
    // LinkedList.Node at the next index (called the "child" here). If the child
    // is null, that denotes the last element of the LinkedList.
    class Node {
        public Object value;
        public Node child;

        public Node(Object value) {
            this(value, null);
        }

        public Node(Object value, Node child) {
            this.value = value;
            this.child = child;
        }
    }

    public int size() {
        return size;
    }

    public LinkedList prepend(Object value) {
        // Node tempNode = new Node (value);
        // tempNode.child = head;
        // head = tempNode;
        head = new Node (value, head);
        size++;
        return this;
    }

    public LinkedList add(Object value) {
            Node tempNode = new Node (value);
            if (head == null) {
                head = tempNode;
            } else {
                Node currentNode = head;
                while (currentNode.child != null) {
                    currentNode = currentNode.child;
                }
                currentNode.child = tempNode;
            }
            size++;
            return this;
    }

    public Object delete(int index) {
            checkBounds(index);
            if (head == null) {
                return null;
            }
            if (size == 1) {
                size -=1;
                Node temp = head;
                head = null;
                return temp.value;
            }

            Node returnNode;
            Node currentNode = head;
            for ( int i = 0; i<index; i++ ) {
                currentNode = currentNode.child;
            }
            if ( index == 0) {
                currentNode = currentNode.child;
                head =
            }
            Node tempNode = currentNode;
            if (currentNode.child != null){
                currentNode = currentNode.child;
                returnNode = currentNode;
                tempNode.child = currentNode.child;
            }
            size-=1;
            return returnNode.value;
    }

    public Object get(int index) {
        checkBounds(index);
        Node currentNode = head;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.child;
        }
        return currentNode.value;
    }

    public Object set(int index, Object value) {
        checkLowerBound(index);
        Node currentNode = head;
        if ( index < size ){
             for(int i = 0; i < index; i++) {
                 currentNode = currentNode.child;
             }
             Node tempNode = currentNode;
             Object output = tempNode.value;
             currentNode.value = value;
             return output;
        } else {
            for (int i = size; i < index; i++) {
                this.add(null);
            }
            this.add(value);
            return null;
        }
    }

    private void checkBounds(int index) {
        checkLowerBound(index);
        checkUpperBound(index);
    }

    private void checkLowerBound(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkUpperBound(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
