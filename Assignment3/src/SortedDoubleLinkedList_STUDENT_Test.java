/*
 * Montana Bazarrgchaa
 * 
 * CMSC 204
 * 
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<String> sortedList;
    private Comparator<String> comparator;

    @Before
    public void setUp() {
        comparator = String::compareTo; // Use natural ordering for strings
        sortedList = new SortedDoubleLinkedList<>(comparator);
    }

    @Test
    public void testAdd() {
        sortedList.add("Brother");
        sortedList.add("Father");
        sortedList.add("Sister");
        sortedList.add("Mother");

        assertEquals("Brother", sortedList.getFirst());
        assertEquals("Sister", sortedList.getLast());
        assertEquals(4, sortedList.getSize());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToEndThrowsException() {
        sortedList.addToEnd("Father"); // Should throw UnsupportedOperationException
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToFrontThrowsException() {
        sortedList.addToFront("Mother"); // Should throw UnsupportedOperationException
    }

    @Test
    public void testRemove() {
        sortedList.add("Father");
        sortedList.add("Mother");
        sortedList.add("Brother");

        BasicDoubleLinkedList<String>.Node removedNode = sortedList.remove("Mother", comparator);
        assertNotNull(removedNode);
        assertEquals("Mother", removedNode.data);
        assertEquals(2, sortedList.getSize());
        assertEquals("Brother", sortedList.getFirst());
        assertEquals("Father", sortedList.getLast());
    }

    @Test
    public void testRetrieveFirstElement() {
        sortedList.add("Father");
        sortedList.add("Mother");
        assertEquals("Father", sortedList.retrieveFirstElement());
        assertEquals("Mother", sortedList.getFirst());
        assertEquals(1, sortedList.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        sortedList.add("Father");
        sortedList.add("Mother");
        assertEquals("Mother", sortedList.retrieveLastElement());
        assertEquals("Father", sortedList.getLast());
        assertEquals(1, sortedList.getSize());
    }

    @Test
    public void testToArrayList() {
        sortedList.add("Father");
        sortedList.add("Mother");
        sortedList.add("Brother");

        ArrayList<String> arrayList = sortedList.toArrayList();
        assertEquals(3, arrayList.size());
        assertEquals("Brother", arrayList.get(0));
        assertEquals("Father", arrayList.get(1));
        assertEquals("Mother", arrayList.get(2));
    }
}