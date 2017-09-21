package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class Hash {
    private DoublyLinkedList[] hash;
    private int size;

    private static class Entry {
        private final Object key;
        private final Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    public Hash() {
        this.hash = new DoublyLinkedList[10];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Hash put(Object key, Object value) {
        if(key == null) {
            throw new NullPointerException("Error: Key cannot be null!");
        }

        int index = key.hashCode() % hash.length;
        if (hash[index] == null) {
            hash[index] = new DoublyLinkedList();
        }
        DoublyLinkedList list = hash[index];
        Entry entry = new Entry( key, value);
        list.add(entry);
        size++;
        return this;
    }

    public Object get(Object key) {
        int index = key.hashCode() % hash.length;
        DoublyLinkedList list = hash[index];
        if (list == null) {
            throw new MissingKeyException("Error: cannot find key!");
        }
        Entry entry = (Entry) list.first();
        return entry.getValue();
    }

    public boolean contains(Object key) {
        throw Kamayan.todo(
        );
    }
}
