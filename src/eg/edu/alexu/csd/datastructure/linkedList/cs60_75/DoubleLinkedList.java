package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author youssefAli
 * 
 */
public class DoubleLinkedList implements ILinkedList {
	private DLNode head;
	private DLNode tail;
	private int size;

	public DoubleLinkedList() {
		head = new DLNode(null, null, null);
		tail = new DLNode(null, null, head);
		head.setNext(tail);
		size = 0;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0)
			throw new RuntimeException("Error");
		DLNode current = head;
		if (size == 0) {
			DLNode node = new DLNode(element, tail, head);
			head.setNext(node);
			tail.setPrev(node);
			size++;
			return;
		}
		for (int i = 0; i < index; i++)
			current = current.getNext();
		DLNode node = new DLNode(element, current.getNext(), current);
		current.getNext().setPrev(node);
		current.setNext(node);
		size++;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		DLNode node = new DLNode(element, tail, tail.getPrev());
		DLNode current = tail.getPrev();
		current.setNext(node);
		tail.setPrev(node);
		size++;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		DLNode current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		return current.getNext().getElement();
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		DLNode current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		current.getNext().setElement(element);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		DLNode current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		DLNode current2 = current.getNext().getNext();
		DLNode current3 = current.getNext();
		current.setNext(current2);
		current2.setPrev(current);
		current3.setNext(null);
		current3.setPrev(null);
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex >= size || toIndex >= size || fromIndex < 0
				|| toIndex < 0 || fromIndex > toIndex)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		DLNode current = head;
		for (int i = 0; i <= fromIndex; i++)
			current = current.getNext();
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(current.getElement());
		for (int i = fromIndex; i < toIndex; i++) {
			current = current.getNext();
			list.add(current.getElement());
		}
		return list;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (o == null)
			throw new RuntimeException("Error");
		if (size == 0)
			return false;
		DLNode current = head;
		for (int i = 0; i < size; i++) {
			current = current.getNext();
			if (o.equals(current.getElement()))
				return true;
		}
		return false;
	}
}