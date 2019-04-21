package com.app.mycollections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MyLinkedListTest {

    protected MyLinkedList<User> expectedList = new MyLinkedList<>();
    protected MyLinkedList<User> currentList;

    @Before
    public void initList() {
        expectedList.add((new User(1, "Tramp")));
        expectedList.add((new User(2, "Macron")));
        expectedList.add((new User(3, "Merkel")));
        expectedList.add((new User(4, "Castro")));
    }

    @Test
    public void tryAddElement() {
        currentList = new MyLinkedList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            currentList.add(expectedList.get(i));
        }
        Assert.assertEquals(currentList.get(0).getName(), "Tramp");
    }


    @Test
    public void tryAddElementByIndex() {
        expectedList.add(new User(100, "NoName"), 3);
        Assert.assertEquals(expectedList.get(3).getName(), "NoName");
    }

    @Test
    public void TryAddAllElements() {
        currentList = new MyLinkedList<>();
        currentList.add(new User(111, "Whois"));
        currentList.add(new User(222, "Its me"));
        int oldSize = expectedList.size();
        expectedList.addAll(currentList);
        int newSize = expectedList.size();
        Assert.assertEquals(currentList.get(5).getName(), "Its me");
    }

    @Test
    public void trySetElements() {
        User newUser = expectedList.get(0);
        expectedList.set(newUser, 1);
        Assert.assertThat(expectedList.get(0).getName(), is("Tramp"));
    }


    @Test
    public void tryRemoveElement() {
        currentList = new MyLinkedList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            currentList.add(expectedList.get(i));
        }
        currentList.remove(2);
        Assert.assertEquals(currentList.get(2).getName(), "Castro");
    }

    @Test
    public void tryKnowSize() {
        Assert.assertEquals(expectedList.size(), 4);
    }

    @Test
    public void tryMethodIsEmpty() {
        currentList = new MyLinkedList<>();
        currentList.add(expectedList.get(0));

        Assert.assertEquals(expectedList.isEmpty(), true);
    }
}