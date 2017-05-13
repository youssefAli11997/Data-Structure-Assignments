package eg.edu.alexu.csd.datastructure.queue.cs75;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayBasedQueue implements IArrayBased, IQueue {

	private int size;
	private int f;
	private int r;
	private int limit;
	private Object[] queue;

	public ArrayBasedQueue(int n) {
		this.size = 0;
		this.f = 0;
		this.r = 0;
		this.limit = n;
		this.queue = new Object[n];
	}

	@Override
	public void enqueue(Object item) {
		if (this.size == this.limit)
			throw new RuntimeException("Full");

		this.queue[r] = item;
		r = (r + 1) % this.limit;
		this.size++;
	}

	@Override
	public Object dequeue() {
		if (isEmpty())
			throw new RuntimeException("Empty");

		Object ret = queue[f];
		f = (f + 1) % this.limit;
		this.size--;
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

}
