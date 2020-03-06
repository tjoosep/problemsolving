package com.impro.datastructures;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T>{

    private LinkedList<T> list = new LinkedList<>();

    public Queue() {}

    public Queue(T element) {
        offer(element);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* peek the element at the front of the queue
       will not remove element from queue */
    public T peek() {
        if (isEmpty()) { throw new RuntimeException("Queue is empty"); }
        return list.peekFirst();
    }

    /* poll an element from the front of the queue
       first element will be removed from the queue */
    public T poll() {
        if (isEmpty()) { throw new RuntimeException("Queue is empty"); }
        return list.removeFirst();
    }

    // add element to the back of the queue
    public void offer(T element) {
        if (element == null) { throw new IllegalArgumentException("null not allowed"); }
        list.addLast(element);
    }

    public void add(T element) {
        if (element == null) { throw new IllegalArgumentException("null not allowed"); }
        list.addFirst(element);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        while (list.iterator().hasNext()) {
            T element = list.pop();
            builder.append(element);
            if (list.peek() != null) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>(10);
        System.out.println(myQueue);        // 10

        myQueue.add(20);
        System.out.println(myQueue.size()); // 2

        System.out.println(myQueue.poll()); // 20
    }
}
