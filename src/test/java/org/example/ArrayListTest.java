package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList_ arrayList;
    @Before
    public void setUp() throws Exception {
        arrayList=new ArrayList_();
        for (int i = 0; i < 100; i++) {
             arrayList.add(i);
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100,arrayList.getSize());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(arrayList.removeAt(5));
        assertEquals(99, arrayList.getSize());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        arrayList.add(102);
        assertEquals(101, arrayList.getSize());
        assertTrue(arrayList.remove(102));
        assertEquals(100, arrayList.getSize());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        arrayList.clear();
        assertEquals(0, arrayList.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        arrayList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        int i=arrayList.get(0);
        assertEquals(0, i);
    }

    @Test
    public void insertIntoMiddle() {
        arrayList.add(66, 50);
        assertEquals(66, arrayList.get(50));
    }

    @Test
    public void insertIntoFirstPosition() {
        arrayList.add(0, 0);
        assertEquals(0, arrayList.get(0));
    }

    @Test
    public void insertIntoLastPosition() {
        arrayList.add(100, 100);
        assertEquals(100,arrayList.get(100));
    }
}
