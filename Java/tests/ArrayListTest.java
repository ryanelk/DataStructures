import com.rek.datastructures.ArrayList.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {

    ArrayList arr;

    @Before
    public void setUp() {
        arr = new ArrayList();
    }

    @Test
    public void add() {
        // simple insertion
        arr.add("hello");
        assertEquals(arr.get(0), "hello");
    }

    @Test
    public void outOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arr.add(-1, "hello");
        });
    }

    @Test
    public void size() {
        // add and remove
        assertEquals(arr.isEmpty(), true);
        arr.add("hello");
        assertEquals(arr.isEmpty(), false);
        assertEquals(arr.size(), 1);
        arr.add(0, "shello");
        assertEquals(arr.size(), 2);
        arr.remove(1);
        assertEquals(arr.size(), 1);
    }

    @Test
    public void remove() {
        // remove from empty
        assertEquals(arr.remove("hello"), false);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arr.remove(10);
                });

        // add and remove
        arr.add("hello");
        assertEquals(arr.remove("hello"), true);
        assertEquals(arr.isEmpty(), true);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arr.add(0, "lol");
                });
        arr.add("hello");
        assertEquals(arr.size(), 1);
        assertEquals(arr.remove(0), "hello");
        assertEquals(arr.isEmpty(), true);
    }

    @Test
    public void addCapacity() {
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");
        arr.add("f");
        arr.add("g");
        arr.add("h");
        arr.add("i");
        arr.add("j");
        arr.add("k");
        arr.add("l");
        arr.add("m");
        assertEquals(arr.get(12), "m");
    }

    @Test
    public void set() {
        // set on nonexistent
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arr.set(20, "hello");
        });
        arr.add("hello");
        assertEquals(arr.get(0), "hello");
        arr.set(0, "shello");
        assertEquals(arr.get(0), "shello");
    }


}