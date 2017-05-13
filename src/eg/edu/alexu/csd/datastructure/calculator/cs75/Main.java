package eg.edu.alexu.csd.datastructure.calculator.cs75;

import java.util.Scanner;

/**
 * @author youssefAli
 *
 */
public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Implementation calc = new Implementation();

		int n1, n2;
		System.out.println("Enter two numbers to add: ");
		n1 = in.nextInt();
		n2 = in.nextInt();

		System.out.println(n1 + " + " + n2 + " = " + calc.add(n1, n2));

		System.out.println("Enter two numbers to divide: ");
		n1 = in.nextInt();
		n2 = in.nextInt();

		System.out.println(n1 + " / " + n2 + " = " + calc.divide(n1, n2));
	}
}