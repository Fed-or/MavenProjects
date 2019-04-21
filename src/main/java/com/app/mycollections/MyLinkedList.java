package com.app.mycollections;

public class MyLinkedList<T>{
    private MyNode<T> firstNode;
    private MyNode<T> lastNode;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public void add(T value) {
        if (size == 0) {
            firstNode = new MyNode<>(null, null, value);
            lastNode = firstNode;
        } else if (size == 1) {
            lastNode = new MyNode<>(firstNode, null, value);
            firstNode.next = lastNode;
        } else {
            MyNode<T> currentNode = new MyNode<>(lastNode, null, value);
            lastNode.next = currentNode;
            lastNode = currentNode;
        }
        size++;
    }

    public void add(T value, int index) {
        if (index >= size) {
            this.add(value);
            return;
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> currentNode = findNode(index);
        MyNode<T> newNode = new MyNode<T>(currentNode.prev, currentNode, value);
        currentNode.prev.next = newNode;
        currentNode.prev = newNode;
        this.size++;
    }

    public void addAll(MyLinkedList<User> myList) {
        lastNode.next = ((MyLinkedList) myList).firstNode;
    }

    public T get(int index) {
        return findNode(index).value;
    }

    public void set(T value, int index) {
        MyNode<T> currentNode = findNode(index);
        currentNode.value = value;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> currentNode = findNode(index);
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        this.size--;
        return (T) currentNode.value;
    }

    public T remove(T item) {
        MyNode<T> currentNode = findNode(item);
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        if ((T) currentNode.value != null) {
            this.size--;
            return (T) currentNode.value;
        }
        throw new NullPointerException("Item not found");
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size >=0;
    }

    private MyNode<T> findNode(T value) {
        MyNode<T> currentNode = firstNode;
        while (currentNode.next != null) {
            if (currentNode.value == value) {
                break;
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private MyNode<T> findNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> currentNode = firstNode;
        int tmpIndex = 0;
        while (currentNode.next != null) {
            if (tmpIndex == index) {
                break;
            }
            currentNode = currentNode.next;
            tmpIndex++;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        MyNode<T> currentNode = firstNode;
        StringBuilder result = new StringBuilder(currentNode.value.toString());
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result.append(", ").append(currentNode.value.toString());
        }
        return result.toString();
    }
}
