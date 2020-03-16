package com.datastructures;


import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable <T> {

    private int size = 0;
    private Node<T> head = null;       // first element
    private Node<T> tail = null;       // last element

    // internal node class for data representation
    private static class Node<T> {
        T data;
        // pointers
        Node<T> next;
        Node<T> previous;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    // clear everything, e.g set everything to null
    public void clear() {
        Node <T> pointer = head;
        while (pointer != null) {
            Node<T> next = pointer.next;
            pointer.previous = null;
            pointer.next = null;
            pointer.data = null;
            pointer  = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // add element to the beginning of the LL, O(1)
    // changing heads pointer
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<T> (element, null, null);
        } else {
            head.previous = new Node<T> (element, null, head);
            head = head.previous;
        }
        size++;
    }

    // add element to the end of the LL, O(1)
    // changing tails pointer
    public void addLast(T element) {
        if (isEmpty()) {
           head = tail = new Node<T> (element, null, null);
        } else {
            tail.next = new Node<T> (element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // check the first element of the LList if exists, O(1)
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedList is empty");
        }
        return head.data;
    }

    // check the last element of the LList if exists, O(1)
    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedList is empty");
        }
        return tail.data;
    }

    // remove first (e.g the head) element in LList, O(1)
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedList is empty");
        }
        T data = head.data;
        head = head.next; //
        size--;

        if (isEmpty()) {
            tail = null;
        } else {
            // clean the previous node that we just removed
            head.previous = null;
        }
        return data;
    }

    public T removeLast() {
        if (isEmpty()) { throw new RuntimeException("LinkedList is empty"); }

        T data = tail.data;
        tail = tail.previous;
        size--;

        if (isEmpty()) { head = null; }
        else { tail.next = null; }

        return data;
    }

    private T remove(Node<T> node) {

        if (node.next     == null) { return removeLast(); }
        if (node.previous == null) { return removeFirst(); }

        // make pointers to skip over 'node' arg
        node.next.previous = node.previous;
        node.previous.next = node.next;

        T data = node.data;

        // memory cleanup
        node.data = null;
        node = node.previous = node.next = null;
        size--;

        // data that we just removed
        return data;
    }

    // remove a node at certain index, O(n)
    public T removeAt(int index) {
        if (index < 0 || index >= size) { throw new IllegalArgumentException(); }

        int i;
        Node<T> pointer;

        // start to search at the beginning
        if (index < size / 2) {
            for (i = 0, pointer = head; i != index  ; i++) {
                pointer = pointer.next;
            }
        } else {
            for (i = size-1, pointer = tail; i != index ; i--) {
                pointer = pointer.previous;
            }
        }
        return remove(pointer);
    }

    public int indexOf(Object o) {
        int index = 0;
        Node<T> pointer = head;

        if (o == null) {
            for (pointer = head; pointer != null; pointer = pointer.next, index++) {
                if (pointer.data == null) {
                    return index;
                }
            }
        } else {
            for (pointer = head; pointer != null; pointer = pointer.next, index++) {
                if (o.equals(pointer.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> pointer =  head;
            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public T next() {
                T data = pointer.data;
                pointer = pointer.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Node<T> pointer = head;
        while (pointer != null) {
            builder.append(pointer.data);
            // just for better printing, but last node points to null as well
            if (pointer.next != null) {
                builder.append(" -> ");
            }
            pointer = pointer.next;
        }

        builder.append(" ]");
        return builder.toString();
    }

    // demo
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(5);
        dll.addLast(6);
        System.out.println(dll);        // [5 -> 6]
        System.out.println(dll.size()); // 2

        dll.removeFirst();
        System.out.println(dll.peek()); // 6
    }

}
