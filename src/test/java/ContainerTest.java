
import org.example.Container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testAddAndGetElement() {
        container.add("A");
        container.add("B");
        container.add("C");

        assertEquals(3, container.getSize());
        assertEquals("A", container.getElement(0));
        assertEquals("B", container.getElement(1));
        assertEquals("C", container.getElement(2));
    }

    @Test
    void testSetElement() {
        container.add("A");
        container.add("B");

        container.setElement(1, "Z");
        assertEquals("Z", container.getElement(1));
    }

    @Test
    void testGrow() {
        // заполняем до переполнения
        for (int i = 0; i < 15; i++) {
            container.add(i);
        }
        assertEquals(15, container.getSize());
        assertEquals(0, container.getElement(0));
        assertEquals(14, container.getElement(14));
    }

    @Test
    void testRemoveByIndex() {
        container.add("A");
        container.add("B");
        container.add("C");

        container.remove(1);

        assertEquals(2, container.getSize());
        assertEquals("C", container.getElement(1));
    }

    @Test
    void testRemoveByIndex_InvalidIndex() {
        container.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(5));
    }

    @Test
    void testRemoveByValue_FirstOnly() {
        container.add("A");
        container.add("B");
        container.add("A");
        container.add("C");

        container.remove("A", false);

        assertEquals(3, container.getSize());
        assertEquals("B", container.getElement(0));
        assertEquals("A", container.getElement(1));
        assertEquals("C", container.getElement(2));
    }

    @Test
    void testRemoveByValue_RemoveAll() {
        container.add("A");
        container.add("B");
        container.add("A");
        container.add("A");

        container.remove("A", true);

        assertEquals(1, container.getSize());
        assertEquals("B", container.getElement(0));
    }

    @Test
    void testRemoveNullValue() {
        container.add("X");
        container.add(null);
        container.add("Y");

        container.remove(null, false);

        assertEquals(2, container.getSize());
        assertEquals("X", container.getElement(0));
        assertEquals("Y", container.getElement(1));
    }

    @Test
    void testClear() {
        container.add("A");
        container.add("B");
        container.add("C");

        container.clear();

        assertEquals(0, container.getSize());
        assertTrue(container.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> container.getElement(0));
    }

    @Test
    void testIsEmpty() {
        assertTrue(container.isEmpty());
        container.add("A");
        assertFalse(container.isEmpty());
    }

    @Test
    void testGetElement_InvalidIndex() {
        container.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.getElement(10));
    }

    @Test
    void testSetElement_InvalidIndex() {
        container.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> container.setElement(5, "X"));
    }
}

