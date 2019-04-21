package com.app.mycollections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MyArrayListTest {

    private MyList<String> expectedList;
    private MyList<String> listForTesting;

    @Before
    public void initArray() {
        expectedList = new MyArrayList<>();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("3");
        expectedList.add("4");
    }

    @Test
    public void tryAddElement() {
        listForTesting = new MyArrayList<>();
        listForTesting.add("1");
        listForTesting.add("2");
        listForTesting.add("3");
        listForTesting.add("4");
        Assert.assertEquals(expectedList.get(3), "4");
    }

    @Test
    public void tryingAddElementByIndex() {
        expectedList.add("Five", 3);
        Assert.assertEquals(expectedList.get(3), "Five");
    }

    @Test
    public void tryingAddAll() {
        listForTesting = new MyArrayList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.add(expectedList.get(i));
        }
        Assert.assertEquals(Integer.parseInt(expectedList.get(3)) -
                (Integer.parseInt(listForTesting.get(1))), 2);
        Assert.assertEquals(expectedList.size(), listForTesting.size());
    }

    @Test
    public void tryGetElement() {
        listForTesting = new MyArrayList<>();
        listForTesting.add("1");
        Assert.assertEquals(listForTesting.get(0), "1");
    }

    @Test
    public void trySetElement() {
        listForTesting = new MyArrayList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.add(expectedList.get(i));
        }
        boolean equalsBefore = listForTesting.get(0).equals(expectedList.get(0));
        listForTesting.set(expectedList.get(0), 3);
        boolean equalsAfter = (listForTesting.get(0).equals(expectedList.get(0)));
        Assert.assertEquals(equalsAfter, equalsBefore);
    }


    @Test
    public void removeByIndex() {
        listForTesting = new MyArrayList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.add(expectedList.get(i));
        }
        listForTesting.remove(3);
        Assert.assertNull(listForTesting.get(expectedList.size() - 1));
    }

    @Test
    public void removeByValue() {
        listForTesting = new MyArrayList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.add(" " + i);
        }
        listForTesting.remove(" 1");
        Assert.assertEquals(listForTesting.get(1), " 2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void size() {
        expectedList.set("9", -5);
        expectedList.set("10", 100);
    }

    @Test
    public void isEmpty() {
        listForTesting = new MyArrayList<>();
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.add(expectedList.get(i));
        }
        int resultBefore = Integer.parseInt(listForTesting.get(1));
        for (int i = 0; i < expectedList.size(); i++) {
            listForTesting.remove(i);
        }
        int resultAfter = Integer.parseInt(listForTesting.get(1));
        Assert.assertFalse(resultBefore == (resultBefore - resultAfter));
    }
}
