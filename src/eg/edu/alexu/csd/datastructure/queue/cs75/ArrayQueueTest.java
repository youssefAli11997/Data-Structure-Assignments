package eg.edu.alexu.csd.datastructure.queue.cs75;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	public int n = 8;
	public ArrayBasedQueue test = new ArrayBasedQueue(n);

	@Test
	public void testEnqueue() {
		for (int i = 0; i < n; i++)
			test.enqueue(i);
		assertEquals(test.size(), n);
		assertEquals(test.isEmpty(), false);
	}

	@Test(expected = RuntimeException.class)
	public void testDeque() {
		ArrayBasedQueue emp = new ArrayBasedQueue(0);
		emp.dequeue();
	}

	@Test
	public void testEnqueueDeque() {
		for (int i = 0; i < n; i++)
			test.enqueue(i);
		for (int i = 0; i < n - 1; i++)
			test.dequeue();
		Object t = test.dequeue();
		assertEquals(t, n - 1);
	}

}
