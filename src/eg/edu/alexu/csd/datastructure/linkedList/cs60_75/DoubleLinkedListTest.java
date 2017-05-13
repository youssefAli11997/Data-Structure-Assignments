package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

/**
 * @author youssefAli
 * 
 */
public class DoubleLinkedListTest {

	@Test
	public void test() {
		DoubleLinkedList n = new DoubleLinkedList();
		Point[] myPoints = { new Point(5, 3), new Point(1, 4), new Point(6, 4),
				new Point(3, 3), new Point(200, 54), new Point(4, 5) };
		for (int i = 0; i < myPoints.length; i++)
			n.add(myPoints[i]);
		for (int i = 0; i < myPoints.length; i++)
			assertEquals("Missed element at index " + i, myPoints[i], n.get(i));
		System.out.println("Tested correct insertion");
		try {
			n.add(100, myPoints[0]);
		} catch (RuntimeException e) {
			final String msg = "Error";
			assertEquals(msg, e.getMessage());
		}
		System.out.println("Tested Wrong Adding");
		Point x = new Point(63, 78);
		n.add(3, x);
		assertEquals("Wrong element at index " + 3, x, n.get(3));
		System.out.println("Tested correct insertion at middle");
		x = new Point(2114, 8541);
		n.set(4, x);
		assertEquals("Wrong element at index " + 3, x, n.get(4));
		System.out.println("Tested correct element setting");
		DoubleLinkedList testList = (DoubleLinkedList) n.sublist(3, 6);
		assertEquals("Size isn't right", 4, testList.size());
		System.out.println("Sublist size");
		Point[] pointTest = { new Point(63, 78), new Point(2114, 8541),
				new Point(200, 54), new Point(4, 5) };
		for (int i = 0; i < 4; i++)
			assertEquals("Missed element at index " + i, pointTest[i],
					testList.get(i));
		System.out.println("Tested SubList items");
		n.remove(0);
		assertEquals("Size isn't right", 6, n.size());
		System.out.println("Tested Correct size after removal");
		Point[] pointTest2 = { new Point(1, 4), new Point(6, 4),
				new Point(63, 78), new Point(2114, 8541), new Point(200, 54),
				new Point(4, 5) };
		for (int i = 0; i < 6; i++)
			assertEquals("Missed element at index " + i, pointTest2[i],
					n.get(i));
		System.out.println("Tested List after removal");
		x = new Point(2114, 8541);
		assertTrue(n.contains(x));
		System.out.println("Tested element existance");
		x = new Point(66, 45);
		assertFalse(n.contains(x));
		System.out.println("Tested element non existance");
		n.clear();
		assertTrue(n.isEmpty());
		System.out.println("Tested List clearance");
	}

}
