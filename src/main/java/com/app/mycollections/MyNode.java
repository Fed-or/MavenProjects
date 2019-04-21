package com.app.mycollections;

public class MyNode<T> {
    MyNode prev;
    MyNode next;
    T value;

    @Override
    public String toString() {
        return value.toString();
    }

    public MyNode(MyNode prev, MyNode next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}

