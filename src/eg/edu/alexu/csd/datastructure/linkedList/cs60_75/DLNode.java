package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

/**
 * @author youssefAli
 *
 */
/**
 * @author youssefAli
 * 
 */
public class DLNode {
	private Object element;
	private DLNode next;
	private DLNode prev;

	public DLNode(Object element, DLNode next, DLNode prev) {
		// TODO Auto-generated constructor stub
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	public Object getElement() {
		return element;
	}

	public DLNode getNext() {
		return next;
	}

	public DLNode getPrev() {
		return prev;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public void setNext(DLNode next) {
		this.next = next;
	}

	public void setPrev(DLNode prev) {
		this.prev = prev;
	}
}