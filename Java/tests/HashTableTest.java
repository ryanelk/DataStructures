import com.rek.datastructures.HashTable.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    HashTable testTable;

    @Before
    public void setUp() {
        testTable = new HashTable();
    }

    @Test
    public void add() {
        // simple insertion
        testTable.add("hello", 17);
        assertEquals(testTable.getSize(), 1);
    }

    @Test
    public void remove() {
        // add and remove
        testTable.add("hello", 17);
        assertEquals(testTable.getSize(), 1);
        testTable.remove("hello", 17);
        assertEquals(testTable.getSize(), 0);

    }

    @Test
    public void get() {
        testTable.add("trash", 20);
        assertEquals(testTable.get("trash"), 20);
        testTable.add(20, "trash");
        assertEquals(testTable.get(20), "trash");
    }

    @Test
    public void addCapacity() {
        testTable.add("a", 1);
        testTable.add("b", 2);
        testTable.add("c", 3);
        testTable.add("d", 4);
        testTable.add("e", 5);
        testTable.add("f", 6);
        testTable.add("g", 7);
        testTable.add("h", 8);
        testTable.add("i", 9);
        testTable.add("j", 10);
        testTable.add("k", 11);
        testTable.add("l", 12);

    }

    @Test
    public void removeEmpty() {
        testTable.remove(18, "fake");
    }

    @Test
    public void insertDuplicate() {
        // only one should be inserted
        testTable.add("hello", 17);
        testTable.add("hello", 17);
        assertEquals(testTable.get("hello"), 17);
        assertEquals(testTable.getSize(), 1);
        // same key, diff value
        testTable.add("hello", 16);
        assertEquals(testTable.get("hello"), 16);
    }


}