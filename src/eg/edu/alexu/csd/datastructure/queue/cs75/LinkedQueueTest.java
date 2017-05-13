package eg.edu.alexu.csd.datastructure.queue.cs75;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedQueueTest {

	public int n = 8;
	public LinkedBasedQueue test = new LinkedBasedQueue();

	@Test
	public void testEnqueue() {
		for (int i = 0; i < n; i++)
			test.enqueue(i);
		assertEquals(test.size(), n);
		assertEquals(test.isEmpty(), false);
	}

	@Test(expected = RuntimeException.class)
	public void testDeque() {
		LinkedBasedQueue emp = new LinkedBasedQueue();
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
