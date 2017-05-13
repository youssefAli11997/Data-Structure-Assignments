package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

import java.util.Scanner;

/**
 * @author youssefAli
 * 
 */
public class PolySolverApp {
	public static void main(String[] args) {
		boolean flag = true, flag2 = true, flag3 = true;
		int tempInput = 0, termsCounter = 0, tempVal = 0;
		char tempChar = 0, tempChar2 = 0;
		int[][] termsTemp = new int[1000][2];
		int[][] terms;
		String temp = null;
		PolynomialSolver polySolver = new PolynomialSolver();
		Scanner sc = new Scanner(System.in);
		System.out.println("<<<<--------------->>>>");
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Set a polynomial variable");
		System.out.println("2 - Print the value of a polynomial variable");
		System.out.println("3 - Add two polynomials");
		System.out.println("4 - Subtract two polynomials");
		System.out.println("5 - Multiply two polynomials");
		System.out.println("6 - Evaluate a polynomial at some point");
		System.out.println("7 - Clear a polynomial variable");
		System.out.println("8 - Close the Program");
		System.out
				.println("====================================================================");
		while (flag) {
			System.out.println("Enter number of an option to perform:");
			if (flag3 == true) {
				tempInput = sc.nextInt();
				sc.nextLine();
			}
			flag3 = true;
			if (tempInput == 1) {
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				if (polySolver.isSet(tempChar))
					polySolver.clearPolynomial(tempChar);
				System.out.println("How many terms ?");
				int num = sc.nextInt();
				sc.nextLine();
				for (int c = 0; c < num; c++) {
					System.out.println("Enter term " + c + " Coefficient");
					int coeff = sc.nextInt();
					System.out.println("Enter term " + c + " Exponent");
					int power = sc.nextInt();
					termsTemp[termsCounter][0] = coeff;
					termsTemp[termsCounter][1] = power;
					termsCounter++;
				}
				sc.nextLine();
				terms = new int[termsCounter + 1][2];
				for (int i = 0; i <= termsCounter; i++) {
					terms[i][0] = termsTemp[i][0];
					terms[i][1] = termsTemp[i][1];
				}
				polySolver.setPolynomial(tempChar, terms);
			}

			else if (tempInput == 2) {
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				System.out.println(polySolver.print(tempChar));
			}

			else if (tempInput == 3) {
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar2 = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				polySolver.add(tempChar, tempChar2);
				System.out.println(polySolver.print('R'));
			}

			else if (tempInput == 4) {
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar2 = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				polySolver.subtract(tempChar, tempChar2);
				System.out.println(polySolver.print('R'));
			}

			else if (tempInput == 5) {
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				while (flag3) {
					System.out.println("Insert the variable name : A , B or C");
					temp = sc.nextLine();
					if (temp.length() == 1) {
						if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
								|| temp.charAt(0) == 'B'
								|| temp.charAt(0) == 'b'
								|| temp.charAt(0) == 'C'
								|| temp.charAt(0) == 'c') {
							tempChar2 = temp.charAt(0);
							flag3 = false;
						}
					}
				}
				flag3 = true;
				polySolver.multiply(tempChar, tempChar2);
				System.out.println(polySolver.print('R'));
			}

			else if (tempInput == 6) {
				while (flag3)
					System.out.println("Insert the variable name : A , B or C");
				temp = sc.next();
				if (temp.length() == 1) {
					if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
							|| temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
							|| temp.charAt(0) == 'C' || temp.charAt(0) == 'c') {
						tempChar = temp.charAt(0);
						flag3 = false;
					}
				}
				flag3 = true;
				System.out.println("Insert the value");
				tempVal = sc.nextInt();
				System.out.println(polySolver.evaluatePolynomial(tempChar,
						tempVal));
			}

			else if (tempInput == 7) {
				while (flag3)
					System.out.println("Insert the variable name : A , B or C");
				temp = sc.next();
				if (temp.length() == 1) {
					if (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
							|| temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
							|| temp.charAt(0) == 'C' || temp.charAt(0) == 'c') {
						tempChar = temp.charAt(0);
						flag3 = false;
					}
				}
				flag3 = true;
				polySolver.clearPolynomial(tempChar);
			}

			else if (tempInput == 8) {
				flag = false;
			} else {
				while (flag2) {
					System.out
							.println("Wrong input Please enter a valid number");
					tempInput = sc.nextInt();
					if (tempInput == 1 || tempInput == 2 || tempInput == 3
							|| tempInput == 4 || tempInput == 5
							|| tempInput == 6 || tempInput == 7
							|| tempInput == 8) {
						flag2 = false;
						flag3 = false;
					}
				}
			}
		}
		sc.close();
		System.out.println("Bye Bye :D");
		System.out.println("<-------->");
	}
}