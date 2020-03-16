package com.datastructures;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public Stack() { }

    public Stack(T firstElement) {
        push(firstElement);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T element) {
        list.addLast(element);
    }

    // pop the first element and remove that element from stack
    public T pop() {
        if(isEmpty()) { throw new EmptyStackException(); }
        return list.removeLast();
    }

    // peek top element w/o removing an element
    public T peek() {
        if (isEmpty()) {throw new EmptyStackException(); }
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());  // remember: last in first out e.g 3
        System.out.println(myStack.peek()); // now top element is 2
        System.out.println(myStack.pop());  // 2
        System.out.println(myStack.pop());  // 1
        System.out.println(myStack.isEmpty()); // should be empty now
    }
}
