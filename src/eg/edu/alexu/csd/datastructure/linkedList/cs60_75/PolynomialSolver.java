package eg.edu.alexu.csd.datastructure.linkedList.cs60_75;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class PolynomialSolver implements IPolynomialSolver {
	private SingleLinkedList A = new SingleLinkedList();
	private SingleLinkedList B = new SingleLinkedList();
	private SingleLinkedList C = new SingleLinkedList();
	private SingleLinkedList R = new SingleLinkedList();

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub

		int length = terms.length;

		if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R'
				&& poly != 'a' && poly != 'b' && poly != 'c' && poly != 'r') {
			throw new RuntimeException();
		}
		if (length == 0 || terms == null) {
			throw new RuntimeException("error");
		}
		int max_term = terms[0][1];
		if (max_term < 0) {
			throw new RuntimeException("error");
		}

		int found = 0;
		for (int k = 1; k < length; k++) {
			if (terms[k][1] > max_term) {
				found = 1;
			}
			if (terms[k][1] < 0) {
				found = 1;
			}
		}

		if (found == 1) {
			throw new RuntimeException("wrong poly");
		}

		Point x;
		SingleLinkedList X = null;
		if (poly == 'A' || poly == 'a')
			X = A;
		if (poly == 'B' || poly == 'b')
			X = B;
		if (poly == 'C' || poly == 'c')
			X = C;
		if (poly == 'R' || poly == 'r')
			X = R;
		if (X != null)
			for (int i = 0; i < terms.length; i++) {
				x = new Point(terms[i][0], terms[i][1]);
				X.add(x);
			}
	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub
		Point x;
		StringBuffer st = new StringBuffer();
		SingleLinkedList X = null;
		if (poly == 'A' || poly == 'a')
			X = A;
		else if (poly == 'B' || poly == 'b')
			X = B;
		else if (poly == 'C' || poly == 'c')
			X = C;
		else if (poly == 'R' || poly == 'r')
			X = R;
		else
			throw new RuntimeException("error");
		if (X.size() == 0)
			return null;
		if (X != null)
			for (int i = 0; i < X.size(); i++) {
				x = (Point) X.get(i);
				if (x.getX() == 0) {
					continue;
				}
				if (st.length() == 0) {
					if (x.getX() < 0) {
						st.append('-');
						if (x.getX() < -1)
							st.append((int) Math.abs(x.getX()));
					} else {
						if (x.getX() > 1)
							st.append((int) Math.abs(x.getX()));
					}
					if (x.getY() > 0) {
						st.append('x');
						if (x.getY() > 1) {
							st.append('^');
							st.append((int) Math.abs(x.getY()));
						}
					}
				} else {
					if (x.getX() < 0) {
						st.append('-');
						if (x.getX() < -1)
							st.append((int) Math.abs(x.getX()));
						if (x.getX() == -1 && x.getY() == 0)
							st.append((int) Math.abs(x.getX()));
					} else {
						st.append('+');
						if (x.getX() > 1)
							st.append((int) Math.abs(x.getX()));
						if (x.getX() == 1 && x.getY() == 0)
							st.append((int) Math.abs(x.getX()));
					}
					if (x.getY() > 0) {
						st.append('x');
						if (x.getY() > 1) {
							st.append('^');
							st.append((int) Math.abs(x.getY()));
						}
					}
				}
			}
		return st.toString();
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub

		if (poly == 'A' || poly == 'a') {
			if (A.isEmpty()) {
				throw new RuntimeException();
			}
		} else if (poly == 'B' || poly == 'b') {
			if (B.isEmpty()) {
				throw new RuntimeException();
			}
		} else if (poly == 'C' || poly == 'c') {
			if (C.isEmpty()) {
				throw new RuntimeException();
			}
		} else if (poly == 'R' || poly == 'r') {
			if (R.isEmpty()) {
				throw new RuntimeException();
			}
		} else if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R'
				&& poly != 'a' && poly != 'b' && poly != 'c' && poly != 'r') {
			throw new RuntimeException();
		}

		if (poly == 'A' || poly == 'a')
			A = new SingleLinkedList();
		else if (poly == 'B' || poly == 'b')
			B = new SingleLinkedList();
		else if (poly == 'C' || poly == 'c')
			C = new SingleLinkedList();
		else if (poly == 'R' || poly == 'r')
			R = new SingleLinkedList();
		else
			throw new RuntimeException("error");
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub

		Point p;
		float res = 0;
		SingleLinkedList X = null;
		if ((poly == 'A' || poly == 'a') && !A.isEmpty())
			X = A;
		if ((poly == 'B' || poly == 'b') && !B.isEmpty())
			X = B;
		if ((poly == 'C' || poly == 'c') && !C.isEmpty())
			X = C;

		if (X != null) {
			SLNode curr = X.getHead();
			for (int i = 0; i < X.size(); i++) {
				p = ((Point) curr.getElement());
				res += p.getX() * Math.pow(value, p.getY());
				curr = curr.getNext();
			}
		} else
			throw new RuntimeException("error");

		return res;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		R.clear();
		SLNode first = null, second = null;
		if ((poly1 == 'A' || poly1 == 'a') && !A.isEmpty())
			first = A.getHead();
		if ((poly1 == 'B' || poly1 == 'b') && !B.isEmpty())
			first = B.getHead();
		if ((poly1 == 'C' || poly1 == 'c') && !C.isEmpty())
			first = C.getHead();
		if ((poly2 == 'A' || poly2 == 'a') && !A.isEmpty())
			second = A.getHead();
		if ((poly2 == 'B' || poly2 == 'b') && !B.isEmpty())
			second = B.getHead();
		if ((poly2 == 'C' || poly2 == 'c') && !C.isEmpty())
			second = C.getHead();

		if (first == null || second == null)
			throw new RuntimeException("error");

		int[][] fr = new int[10000][2], sc = new int[10000][2];
		int i = 0, j = 0;
		while (first != null) {
			fr[i][0] = (int) ((Point) first.getElement()).getX();
			fr[i][1] = (int) ((Point) first.getElement()).getY();
			i++;
			first = first.getNext();
		}
		while (second != null) {
			sc[j][0] = (int) ((Point) second.getElement()).getX();
			sc[j][1] = (int) ((Point) second.getElement()).getY();
			j++;
			second = second.getNext();
		}

		int[][] res = new int[10000][2];
		for (int n = 0; n < i; n++) {
			res[n][0] = fr[n][0];
			res[n][1] = fr[n][1];
		}
		for (int m = 0; m < j; m++) {
			boolean flag = false;
			int n = 0;
			for (; n < i; n++)
				if (res[n][1] == sc[m][1]) {
					flag = true;
					break;
				}
			if (flag)
				res[n][0] += sc[m][0];
			else {
				res[i][0] = sc[m][0];
				res[i++][1] = sc[m][1];
				if (res[i - 1][0] == 0)
					i--;
			}
		}

		res = sortPoly(res);
		for (int d = 0; d < i; d++)
			R.add(new Point(res[d][0], res[d][1]));

		int[][] ret = new int[i][2];
		for (int f = 0; f < i; f++) {
			ret[f][0] = res[f][0];
			ret[f][1] = res[f][1];
		}

		return ret;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		R.clear();
		SLNode first = null, second = null;
		if (poly1 == 'A' || poly1 == 'a')
			first = A.getHead();
		if (poly1 == 'B' || poly1 == 'b')
			first = B.getHead();
		if (poly1 == 'C' || poly1 == 'c')
			first = C.getHead();
		if (poly2 == 'A' || poly2 == 'a')
			second = A.getHead();
		if (poly2 == 'B' || poly2 == 'b')
			second = B.getHead();
		if (poly2 == 'C' || poly2 == 'c')
			second = C.getHead();

		if (first == null || second == null)
			throw new RuntimeException("error");
		if (first == second) {
			int length = 0;
			if (poly1 == 'A' || poly1 == 'a')
				length = A.size();
			if (poly1 == 'B' || poly1 == 'b')
				length = A.size();
			if (poly1 == 'C' || poly1 == 'c')
				length = A.size();
			int ress[][] = new int[length][2];
			for (int i = 0; i < length; i++)
				for (int j = 0; j < 2; j++)
					ress[i][j] = 0;
			return ress;
		}
		int[][] fr = new int[10000][2], sc = new int[10000][2];
		int i = 0, j = 0;
		while (first != null) {
			fr[i][0] = (int) ((Point) first.getElement()).getX();
			fr[i][1] = (int) ((Point) first.getElement()).getY();
			i++;
			first = first.getNext();
		}
		while (second != null) {
			sc[j][0] = (int) ((Point) second.getElement()).getX();
			sc[j][1] = (int) ((Point) second.getElement()).getY();
			j++;
			second = second.getNext();
		}

		int[][] res = new int[10000][2];
		// add first
		for (int n = 0; n < i; n++) {
			res[n][0] = fr[n][0];
			res[n][1] = fr[n][1];
		}
		// subtract second
		for (int m = 0; m < j; m++) {
			boolean flag = false;
			int n = 0;
			for (; n < i; n++)
				if (res[n][1] == sc[m][1]) {
					flag = true;
					break;
				}
			if (flag)
				res[n][0] -= sc[m][0];
			else {
				res[i][0] -= sc[m][0];
				res[i++][1] = sc[m][1];
			}
		}

		res = sortPoly(res);
		for (int d = 0; d < i; d++)
			if (res[d][0] != 0)
				R.add(new Point(res[d][0], res[d][1]));

		int[][] ret = new int[i][2];
		for (int f = 0; f < i; f++) {
			ret[f][0] = res[f][0];
			ret[f][1] = res[f][1];
		}

		return ret;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		R.clear();
		SLNode first = null, second = null;
		if (poly1 == 'A' || poly1 == 'a')
			first = A.getHead();
		if (poly1 == 'B' || poly1 == 'b')
			first = B.getHead();
		if (poly1 == 'C' || poly1 == 'c')
			first = C.getHead();
		if (poly2 == 'A' || poly2 == 'a')
			second = A.getHead();
		if (poly2 == 'B' || poly2 == 'b')
			second = B.getHead();
		if (poly2 == 'C' || poly2 == 'c')
			second = C.getHead();

		if (first == null || second == null)
			throw new RuntimeException("error");

		int[][] fr = new int[10000][2], sc = new int[10000][2];
		int i = 0, j = 0;
		while (first != null) {
			fr[i][0] = (int) ((Point) first.getElement()).getX();
			fr[i][1] = (int) ((Point) first.getElement()).getY();
			i++;
			first = first.getNext();
		}
		while (second != null) {
			sc[j][0] = (int) ((Point) second.getElement()).getX();
			sc[j][1] = (int) ((Point) second.getElement()).getY();
			j++;
			second = second.getNext();
		}

		int[][] res = new int[10000][2];
		int itr = 0;
		for (int m = 0; m < i; m++) {
			for (int k = 0; k < j; k++) {
				Point ans = new Point(fr[m][0] * sc[k][0], fr[m][1] + sc[k][1]);
				res[itr][0] = (int) ans.getX();
				res[itr][1] = (int) ans.getY();
				itr++;
			}
		}

		int[][] resFinal = new int[10000][2];
		int c = 0;
		boolean[] taken = new boolean[10000];
		for (int m = 0; m < itr; m++)
			if (!taken[m]) {
				taken[m] = true;
				resFinal[c][0] = res[m][0];
				resFinal[c][1] = res[m][1];
				for (int n = 0; n < itr; n++)
					if (!taken[n] && resFinal[c][1] == res[n][1]) {
						resFinal[c][0] += res[n][0];
						taken[n] = true;
						if (resFinal[c][0] == 0)
							c--;
					}
				c++;
			}

		resFinal = sortPoly(resFinal);

		for (int d = 0; d < c; d++)
			R.add(new Point(resFinal[d][0], resFinal[d][1]));

		int[][] ret = new int[c][2];
		for (int f = 0; f < c; f++) {
			ret[f][0] = resFinal[f][0];
			ret[f][1] = resFinal[f][1];
		}

		return ret;
	}

	private int[][] sortPoly(int[][] poly) {
		for (int i = 0; i < poly.length; i++) {
			for (int j = i + 1; j < poly.length; j++) {
				if (poly[i][1] < poly[j][1]) {
					int tmp = poly[i][1];
					poly[i][1] = poly[j][1];
					poly[j][1] = tmp;

					tmp = poly[i][0];
					poly[i][0] = poly[j][0];
					poly[j][0] = tmp;
				}
			}
		}
		return poly;
	}

	public SLNode getRFirst() {
		return R.getHead();
	}

	public boolean isSet(char poly) {
		if (poly == 'a' || poly == 'A')
			return !A.isEmpty();
		if (poly == 'b' || poly == 'B')
			return !B.isEmpty();
		if (poly == 'c' || poly == 'C')
			return !C.isEmpty();
		if (poly == 'r' || poly == 'R')
			return !R.isEmpty();
		return false;
	}
}