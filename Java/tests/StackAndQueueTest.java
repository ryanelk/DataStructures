import com.rek.datastructures.HashTable.HashTable;
import com.rek.datastructures.StackAndQueue.Queue;
import com.rek.datastructures.StackAndQueue.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackAndQueueTest {

    Stack<String> stack;
    Queue<String> queue;

    @Before
    public void setUp() {
        stack = new Stack<>();
        queue = new Queue<>();
    }

    @Test
    public void addSimpleStack() {
        // simple insertion
        stack.push("hello");
        assertEquals(stack.peek(), "hello");
        assertEquals(stack.pop(), "hello");
    }

    @Test
    public void emptyStack() {
        assertEquals(stack.pop(), null);
    }

    @Test
    public void addMultipleStack() {
        stack.push("cart");
        stack.push("intransigent");
        stack.push("ball");
        assertEquals(stack.pop(), "ball");
        assertEquals(stack.pop(), "intransigent");
        assertEquals(stack.pop(), "cart");
    }

    @Test
    public void addSimpleQueue() {
        // simple insertion
        queue.add("hello");
        assertEquals(queue.element(), "hello");
        assertEquals(queue.poll(), "hello");
    }

    @Test
    public void emptyQueue() {
        assertEquals(queue.poll(), null);
    }

    @Test
    public void addMultipleQueue() {
        queue.add("cart");
        queue.add("intransigent");
        queue.add("ball");
        assertEquals(queue.remove(), "cart");
        assertEquals(queue.poll(), "intransigent");
        assertEquals(queue.remove(), "ball");
    }

}