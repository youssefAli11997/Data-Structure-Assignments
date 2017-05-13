package eg.edu.alexu.csd.datastructure.stack.cs75;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author youssefAli
 * implementation of @link IExpressionEvaluator interface
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

	/**
	 * the stack I use in conversion from infix to postfix 
	 */
	private Stack helper = new Stack();
	/**
	 * the stack I use in evaluating postfix expressions
	 */
	private Stack helper2 = new Stack();

	/**
	 * a consturctor to initailize 'helper' stack with a '$' to avoid some errors and exceptions
	 */
	public ExpressionEvaluator() {
		helper.push('$');
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator#infixToPostfix(java.lang.String)
	 * Takes a symbolic/numeric infix expression as input and converts it to
	 * postfix notation.
	 * @param expression
	 *            infix expression
	 * @return postfix expression
	 */
	@Override
	public String infixToPostfix(String expression) {
		int len = expression.length();
		if (expression.equals(null) || len == 0)
			throw new RuntimeException("Error");
		StringBuilder out = new StringBuilder();
		int openPar = 0;
		boolean prevIsOpr = false;
		for (int i = 0; i < len; i++) {
			char curr = expression.charAt(i);
			if (curr == ' ')
				continue;
			else if (curr >= '0' && curr <= '9') {
				prevIsOpr = false;
				if (out.length() > 0)
					out.append(' ');
				out.append(curr);
				if (i + 1 < len) {
					if (expression.charAt(i + 1) >= '0'
							&& expression.charAt(i + 1) <= '9') {
						out.append(expression.charAt(i + 1));
						i++;
					}
				}
			} else if ((curr >= 'a' && curr <= 'z')
					|| (curr >= 'A' && curr <= 'Z')) {
				prevIsOpr = false;
				if (out.length() > 0)
					out.append(' ');
				out.append(curr);
			} else if (curr == '(') {
				helper.push(curr);
				openPar += 1;
			} else if (curr == ')') {
				if (openPar == 0 || i == 0)
					throw new RuntimeException("Error");
				while (!helper.peek().equals('(')) {
					if (out.length() > 0)
						out.append(' ');
					out.append(helper.pop());
				}
				if (!helper.peek().equals('$'))
					if (helper.peek().equals('(')) {
						helper.pop();
					}
				openPar--;
			} else if (curr == '+' || curr == '-') {
				if (prevIsOpr || i == 0)
					throw new RuntimeException("Error");
				if (i + 1 == len)
					throw new RuntimeException("Error");
				if ((helper.peek().equals('+') || helper.peek().equals('-')
						|| helper.peek().equals('*') || helper.peek().equals(
						'/'))
						&& !helper.peek().equals('$')) {
					while (helper.peek().equals('+')
							|| helper.peek().equals('-')
							|| helper.peek().equals('*')
							|| helper.peek().equals('/')) {
						if (out.length() > 0)
							out.append(' ');
						out.append(helper.pop());
					}
				}
				prevIsOpr = true;
				helper.push(curr);
			} else if (curr == '*' || curr == '/') {
				if (prevIsOpr || i == 0)
					throw new RuntimeException("Error");
				if (i + 1 == len)
					throw new RuntimeException("Error");
				if ((helper.peek().equals('*') || helper.peek().equals('/'))
						&& !helper.peek().equals('$')) {
					while (helper.peek().equals('*')
							|| helper.peek().equals('/')) {
						if (out.length() > 0)
							out.append(' ');
						out.append(helper.pop());
					}
				}
				helper.push(curr);
				prevIsOpr = true;
			} else
				throw new RuntimeException("Error");
		}
		while (!helper.peek().equals('$')) {
			if (out.length() > 0)
				out.append(' ');
			out.append(helper.pop());
		}
		return out.toString();
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator#evaluate(java.lang.String)
	 *  Evaluate a postfix numeric expression, with a single space separator
	 * 
	 * @param expression
	 *            postfix expression
	 * @return the expression evaluated value
	 */
	@Override
	public int evaluate(String expression) {
		if (expression.equals(null) || expression.length() == 0)
			throw new RuntimeException("Error");

		for (int i = 0; i < expression.length(); i++) {
			char curr = expression.charAt(i);
			if (curr == ' ')
				continue;
			else if (curr >= '0' && curr <= '9') {
				if (i + 1 == expression.length())
					throw new RuntimeException("Error");
				int num = (int) (curr - '0');
				if (i + 1 < expression.length()) {
					if (expression.charAt(i + 1) >= '0'
							&& expression.charAt(i + 1) <= '9') {
						num *= 10;
						num += expression.charAt(i + 1) - '0';
						i++;
					}
				}
				helper2.push((double) num);

			} else if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
				if (helper2.size() < 2)
					throw new RuntimeException("Error");

				double o1 = (double) helper2.pop();
				double o2 = (double) helper2.pop();
				double r = 0;
				if (curr == '+')
					r = o1 + o2;
				if (curr == '-')
					r = o2 - o1;
				if (curr == '*')
					r = o1 * o2;
				if (curr == '/')
					r = o2 / o1;
				helper2.push(r);
			} else
				throw new RuntimeException("Error");
		}

		if (helper2.size() > 1)
			return 0;

		if (helper2.isEmpty())
			throw new RuntimeException("Error");

		double ret = (double) helper2.pop();

		return (int) ret;
	}

}
