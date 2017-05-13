package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author youssefAli
 * 
 */
public class SingleLinkedList implements ILinkedList {
	private SLNode head;
	private int size;

	public SingleLinkedList() {
		head = null;
		size = 0;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		SLNode node = new SLNode(element, null);
		// youssef is here :D
		if (index > size || index < 0)
			throw new RuntimeException("Error"); // should we return or throw an
													// exception ?
		// ---
		if (size == 0) {
			head = node;
			size++;
			return;
		}
		if (index == 0) {
			SLNode current = head;
			head = node;
			node.setNext(current);
			size++;
			return;
		}
		SLNode current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		node.setNext(current.getNext());
		current.setNext(node);
		size++;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		SLNode node = new SLNode(element, null);
		if (size == 0) {
			head = node;
			size++;
			return;
		}
		SLNode current = head;
		while (current.getNext() != null)
			current = current.getNext();
		current.setNext(node);
		size++;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		// youssef is here again :D
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error"); // should we write "return"
													// before "throw" ?
		SLNode current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		return current.getElement();
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		// same error again :D
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (head == null)
			throw new RuntimeException("Error");
		SLNode current = head;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		current.setElement(element);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		// and again :D
		if (index >= size || index < 0)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		SLNode current = head;
		if (index == 0) {
			head = current.getNext();
			size--;
			return;
		}
		for (int i = 0; i < index - 1; i++)
			current = current.getNext();
		SLNode current2 = current.getNext();
		current.setNext(current2.getNext());
		current2.setNext(null);
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
		if (fromIndex > size || toIndex > size || fromIndex < 0 || toIndex < 0
				|| fromIndex > toIndex)
			throw new RuntimeException("Error");
		if (size == 0)
			throw new RuntimeException("Error");
		SLNode current = head;
		for (int i = 0; i < fromIndex; i++)
			current = current.getNext();
		SingleLinkedList list = new SingleLinkedList();
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
		// boolean flag = false;
		SLNode current = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(current.getElement())) {
				return true;
			}
			current = current.getNext();
		}
		// missing return :D
		return false;
	}

	public SLNode getHead() {
		return head;
	}
}