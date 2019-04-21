package com.app.mycollections;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private T[] values;
    private int index;
    private static final int CAPACITY = 10;

    public MyArrayList() {

        values = (T[]) new Object[CAPACITY];
    }

    public MyArrayList(int capacity) {
        values = (T[]) new Object[capacity];
    }

    public void add(T value) {
        checkSize();
        values[index] = value;
        index++;
    }

    private void checkSize() {
        if (index == (values.length - 2)) {
            T[] tempArray = (T[]) new Object[values.length / 2];
            values = Arrays.copyOf(values, values.length + tempArray.length);
        } else if (index > CAPACITY && (index * 2) < values.length) {
            values = Arrays.copyOf(values, values.length / 2);
        }
    }

    public void add(T value, int index) {
        checkIndex(index);
        add(values[index]);
        set(value, index);
    }

    public void addAll(MyList<T> list) {
        T[] tempArray = Arrays.copyOf(values, index + list.size());
        values = tempArray;

        for (int i = 0; i < list.size(); i++) {
            values[index] = list.get(i);
            index++;
        }
    }

    public T get(int index) {
        checkIndex(index);
        return values[index];
    }

    public void set(T value, int index) {
        checkIndex(index);
        values[index] = value;
    }

    public T remove(int index) {
        checkIndex(index);
        for (int i = index; i < values.length; i++) {
            if (i < values.length - 1) {
                values[i] = values[i + 1];
            } else {
                values[i] = null;
            }
        }
        this.index--;
        checkSize();
        return values[index];
    }

    public T remove(T value) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                remove(i);
                count = i;
                break;
            }
        }
        return values[count];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException(
                    "Try input correct index" + " Index: " + index + ", Size: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(values[i] + "\n");
        }
        return "MyArrayList values: \n" + sb.toString();
    }
}