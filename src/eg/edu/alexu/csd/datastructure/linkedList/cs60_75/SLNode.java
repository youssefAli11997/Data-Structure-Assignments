package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

/**
 * @author youssefAli
 * 
 */
public class SLNode {
	private Object element;
	private SLNode next;

	public SLNode(Object element, SLNode next) {
		// TODO Auto-generated constructor stub
		this.element = element;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public SLNode getNext() {
		return next;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public void setNext(SLNode next) {
		this.next = next;
	}

}