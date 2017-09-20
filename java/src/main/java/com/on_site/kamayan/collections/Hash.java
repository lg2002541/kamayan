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

    // public boolean addEntry( entry ) {
    //     return key == otherKey;
    // }

    public Hash put(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException("Error: Key cannot be Null!");
        }
        int index = key.hashCode() % hash.length;
        Entry entry = new Entry(key, value);
        if (hash[index] == null) {
            hash[index] = new DoublyLinkedList();
            this.size++;
        }
        //search Key in the linked link for the key, increase size if key is not found
        // hash[index].each((element) -> (if element.getKey() == ) )
        // list.each( (element) -> list.addEntry(entry);
        DoublylinkedList list = hash[index];
        list.add(entry);
        return this;
    }

    public Object get(Object key) {
        int index = key.hashCode() % hash.length;
        DoublyLinkedList list = hash[index];
        if (list == null) {
            throw new MissingKeyException("Error: Key cannot be found: " + key);
        }
        Entry result = (Entry) list.first();
        if (result.getKey() == key) {
            return result.getValue();
        }
        return 1; //
    }

    public boolean contains(Object key) {
        int index = key.hashCode() % hash.length;
        DoublyLinkedList list = hash[index];
        if (list == null) {
            return false;
        }
        Node currentNode = list;
        while (currentNode != null){
            if (currentNode.getKey() == key) {
                return true;
            }
            currentNode = currentNode.child;
        }
    }
}
