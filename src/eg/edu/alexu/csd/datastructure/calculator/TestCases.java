package eg.edu.alexu.csd.datastructure.calculator;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
import eg.edu.alexu.csd.datastructure.calculator.cs75.Implementation;

import org.junit.*;

import static org.junit.Assert.*;

public class TestCases {
	Implementation cc = new Implementation();

	public void testAdd() {
		ICalculator instance = (ICalculator) cc;
		try {
			int result = instance.add(3, 4);
			assertEquals("Addition doesn't work '3+4'", 7, result);
		} catch (Throwable e) {
			cc.fail("Fail to get result of '3+4'", e);
		}
	}

	/**
	 * 
	 */
	@org.junit.Test(timeout = 1000)
	public void testDivide() {
		ICalculator instance = (ICalculator) cc;
		try {
			float result = instance.divide(3, 4);
			assertEquals("Division doesn't work '3/4'", 0.75, result, 0.0000001);
		} catch (Throwable e) {
			cc.fail("Fail to get result of '3/4'", e);
		}
		try {
			float result = instance.divide(5, 2);
			assertEquals("Division doesn't work '5/2'", 2.5, result, 0.0000001);
		} catch (Throwable e) {
			cc.fail("Fail to get result of '5/2'", e);
		}
	}
}