package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class Stack {
    private Integer maxSize;
    private DoublyLinkedList list;

    public Stack() {
        this(null);
    }

    public Stack(Integer maxSize) {
        this.maxSize = maxSize;
        // You may use any of the collections you've built so far, though you
        // will need to implement `each` for that collection if you use
        // something other than DoublyLinkedList.
        this.list = new DoublyLinkedList();
    }

    public int size() {
        return list.size();
    }

    public Stack push(Object value) {
            // "The push(Object) method should add the argument to the end of the",
            // "stack, which should increase the size by 1. The return value must",
            // "be this. If the maxSize was specified when constructing the Stack",
            // "(that is, it is not null), then a StackOverflowException should be",
            // "raised before adding the value if the stack is already at the",
            // "capacity."

        // try {
        //     this.list.add(value);
        // } catch (StackOverflowException e){
        //     System.out.println("Caught Error"+ e);
        // };

        if ( this.maxSize != null && this.maxSize <= list.size()){
            throw new StackOverflowException();
        } else{
            list.add(value);
            return this;
        }

    }

    public Object pop() {
            // "The pop() method should remove and return the last value in the",
            // "stack. An IndexOutOfBoundsException should be raised if the Stack",
            // "is empty."
            Object returnVal = list.last();
            list.deleteLast();
            return returnVal;
    }

    public boolean isEmpty() {
            // "The isEmpty() method should return whether or not the size is 0."
            return list.size() == 0 ? true:false;
    }

    public Object peek() {
            // "The peek() method should return the last value in the stack,",
            // "without removing any elements in the stack."
        return list.last();

    }
}
