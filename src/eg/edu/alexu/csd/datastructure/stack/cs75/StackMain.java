package eg.edu.alexu.csd.datastructure.stack.cs75;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack sk = new Stack();
		System.out
				.println("----------- Stack Operations Application -----------");
		System.out
				.println("1: Push\n2: Pop\n3: Peek\n4: Get size\n5: Check if empty\n6: Close");
		while (true) {
			System.out
					.println("----------- Choose an option from 1 to 6 -----------");
			int opt = in.nextInt();
			if (!(opt >= 1 && opt <= 6)) {
				System.out.println("Invalid Entry");
				continue;
			}
			if (opt == 1) {
				System.out
						.println("-- Enter a number to push into the stack --");
				int num = in.nextInt();
				sk.push(num);
				System.out.println("-- Pushed Successfully --");
			} else if (opt == 2) {
				if (!sk.isEmpty()) {
					sk.pop();
					System.out.println("-- Poped Successfully --");
				} else
					System.out.println("-- Invalid; the stack is Empty --");
			} else if (opt == 3) {
				if (!sk.isEmpty()) {
					int top = (int) sk.peek();
					System.out.println("-- Peek Element is : " + top + " --");
				} else
					System.out.println("-- Invalid; the stack is Empty --");
			} else if (opt == 4) {
				System.out.println("-- Size of stack : " + sk.size() + " --");
			} else if (opt == 5) {
				if (sk.isEmpty())
					System.out.println("-- Stack is EMPTY --");
				else
					System.out.println("-- Stack is NOT EMPTY --");
			} else if (opt == 6) {
				System.out.println("----------- Good Bye -----------");
				break;
			}
		}
	}
}