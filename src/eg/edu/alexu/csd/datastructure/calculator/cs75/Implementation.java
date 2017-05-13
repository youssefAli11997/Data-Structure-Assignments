package eg.edu.alexu.csd.datastructure.calculator.cs75;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class Implementation implements ICalculator {

	public int add(int x, int y) {
		return x + y;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.calculator.ICalculator#divide(int, int)
	 */
	public float divide(int x, int y) {
		// if(y==0) return (float) 1e9; //infinity
		try {
			return (float) x / y;
		} catch (Exception e) {
			return (float) 1e9;
		}
	}

	public void fail(String string, Throwable e) {

	}

}