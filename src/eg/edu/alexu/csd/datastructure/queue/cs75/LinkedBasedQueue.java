package eg.edu.alexu.csd.datastructure.queue.cs75;

import eg.edu.alexu.csd.datastructure.linkedList.cs60_75.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs60_75.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class LinkedBasedQueue implements ILinkedBased, IQueue {

	private int size;
	private DoubleLinkedList queue = new DoubleLinkedList();

	@Override
	public void enqueue(Object item) {
		this.size++;
		queue.add(item);
	}

	@Override
	public Object dequeue() {
		if (isEmpty())
			throw new RuntimeException("Empty");
		Object ret = queue.get(0);
		queue.remove(0);
		this.size--;
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

}
