package com.app.mycollections;

import java.util.stream.Stream;

public interface MyList<T> {
    void add(T value);

    void add(T value, int index);

    void addAll (MyList<T> myList);

    T get (int index);

    void set(T value, int index);

    T remove(int index);

    T remove (T value);

    int size();

    boolean isEmpty();

    String toString();

    }
