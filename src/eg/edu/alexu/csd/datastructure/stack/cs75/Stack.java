package eg.edu.alexu.csd.datastructure.stack.cs75;

import eg.edu.alexu.csd.datastructure.linkedList.cs60_75.SingleLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * @author youssefAli
 * the class I use to perform stack operations
 * it implements @link IStack interface
 */
public class Stack implements IStack {

	/**
	 * this attribute is an object of SingleLinkedList class that I use as a stack
	 */
	private SingleLinkedList stack = new SingleLinkedList();

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#add(int, java.lang.Object)
	 * this method adds an element to a specific position or throws exception if this position is invalid
	 */
	@Override
	public void add(int index, Object element) {
		if (index > stack.size() || index < 0)
			throw new RuntimeException(element.toString());
		stack.add(stack.size() - index, element);
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#pop()
	 * this method removes the top of the stack and returns its value or throws exception if empty
	 */
	@Override
	public Object pop() {
		Object ret = stack.getHead().getElement();
		stack.remove(0);
		return ret;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#peek()
	 * return the top of the stack
	 */
	@Override
	public Object peek() {
		return stack.getHead().getElement();
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#push(java.lang.Object)
	 * inserts an element on the top of the stack
	 */
	@Override
	public void push(Object element) {
		stack.add(0, element);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public int size() {
		return stack.size();
	}
}