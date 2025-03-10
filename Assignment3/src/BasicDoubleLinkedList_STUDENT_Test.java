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
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList_STUDENT_Test {
    private BasicDoubleLinkedList<String> linkedList;
    private Comparator<String> comparator;

    @Before
    public void setUp() {
        linkedList = new BasicDoubleLinkedList<>();
        comparator = String::compareTo; // Use natural ordering for strings
    }

    @Test
    public void testAddToEnd() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        assertEquals("Father", linkedList.getFirst());
        assertEquals("Mother", linkedList.getLast());
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void testAddToFront() {
        linkedList.addToFront("Brother");
        linkedList.addToFront("Sister");
        assertEquals("Sister", linkedList.getFirst());
        assertEquals("Brother", linkedList.getLast());
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void testRemove() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        linkedList.addToEnd("Brother");

        BasicDoubleLinkedList<String>.Node removedNode = linkedList.remove("Mother", comparator);
        assertNotNull(removedNode);
        assertEquals("Mother", removedNode.data);
        assertEquals(2, linkedList.getSize());
        assertEquals("Father", linkedList.getFirst());
        assertEquals("Brother", linkedList.getLast());
    }

    @Test
    public void testRetrieveFirstElement() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        assertEquals("Father", linkedList.retrieveFirstElement());
        assertEquals("Mother", linkedList.getFirst());
        assertEquals(1, linkedList.getSize());
    }

    @Test
    public void testRetrieveLastElement() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        assertEquals("Mother", linkedList.retrieveLastElement());
        assertEquals("Father", linkedList.getLast());
        assertEquals(1, linkedList.getSize());
    }

    @Test
    public void testToArrayList() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        linkedList.addToEnd("Brother");

        ArrayList<String> arrayList = linkedList.toArrayList();
        assertEquals(3, arrayList.size());
        assertEquals("Father", arrayList.get(0));
        assertEquals("Mother", arrayList.get(1));
        assertEquals("Brother", arrayList.get(2));
    }

    @Test
    public void testIterator() {
        linkedList.addToEnd("Father");
        linkedList.addToEnd("Mother");
        linkedList.addToEnd("Brother");

        ListIterator<String> iterator = linkedList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Father", iterator.next());
        assertEquals("Mother", iterator.next());
        assertEquals("Brother", iterator.next());
        assertFalse(iterator.hasNext());

        assertTrue(iterator.hasPrevious());
        assertEquals("Brother", iterator.previous());
        assertEquals("Mother", iterator.previous());
        assertEquals("Father", iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementExceptionNext() {
        linkedList.addToEnd("Father");
        ListIterator<String> iterator = linkedList.iterator();
        iterator.next();
        iterator.next(); // Should throw NoSuchElementException
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementExceptionPrevious() {
        linkedList.addToEnd("Father");
        ListIterator<String> iterator = linkedList.iterator();
        iterator.next();
        iterator.previous();
        iterator.previous(); // Should throw NoSuchElementException
    }
}