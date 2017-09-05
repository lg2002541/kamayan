package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class Queue {
    private DoublyLinkedList list;

    public Queue() {
        // You may use any of the collections you've built so far, though you
        // will need to implement `each` for that collection if you use
        // something other than DoublyLinkedList.
        this.list = new DoublyLinkedList();
    }

    public int size() {
        return list.size();
    }

    public Queue enqueue(Object value) {
            // "The enqueue(Object) method should add the argument to the end of",
            // "the queue, which should increase the size by 1. The return value",
            // "must be this."
            list.add(value);
            return this;

    }

    public Object dequeue() {
            // "The dequeue() method should remove and return the first value in",
            // "the queue. An IndexOutOfBoundsException should be thrown if the",
            // "Queue is empty."
            return  list.deleteFirst();

    }

    public boolean isEmpty() {
            // "The isEmpty() method should return whether or not the size is 0."
        return list.size() == 0;
    }

    public Object peek() {
            // "The peek() method should return the first value in the queue,",
            // "without removing any elements in the queue."
        return list.first();
    }
}
