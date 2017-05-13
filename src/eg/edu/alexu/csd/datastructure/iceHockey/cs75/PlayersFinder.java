package eg.edu.alexu.csd.datastructure.iceHockey.cs75;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayersFinder implements IPlayersFinder {

	private final int MAX = 5000;
	private boolean[][] vis = new boolean[MAX][MAX];
	private Point[] players = new Point[MAX];
	private int idx = 0;
	private int minX, minY, maxX, maxY, area;
	private int tmp;

	public Point[] findPlayers(String[] photo, int team, int threshold) {

		idx = 0;
		for (int i = 0; i < MAX; i++)
			for (int j = 0; j < MAX; j++)
				vis[i][j] = false;

		for (int i = 0; i < photo.length; i++)
			for (int j = 0; j < photo[0].length(); j++)
				if (!vis[i][j] && photo[i].charAt(j) - '0' == team) {
					minX = 10000;
					minY = 10000;
					maxX = -10000;
					maxY = -10000;
					area = 0;
					dfs(photo, team, threshold, i, j);
					if (area >= threshold)
						players[idx++] = new Point(minX + maxX + 1, minY + maxY
								+ 1);
				}
		tmp = idx;
		return sortPointArray(players, tmp);
	}

	private void dfs(String[] photo, int team, int threshold, int i, int j) {
		if (!(j < photo[0].length() && j >= 0 && i < photo.length && i >= 0
				&& !vis[i][j] && photo[i].charAt(j) - '0' == team))
			return;

		vis[i][j] = true;
		area += 4;

		if (minY > i)
			minY = i;
		if (minX > j)
			minX = j;
		if (maxY < i)
			maxY = i;
		if (maxX < j)
			maxX = j;

		dfs(photo, team, threshold, i, j + 1);
		dfs(photo, team, threshold, i, j - 1);
		dfs(photo, team, threshold, i - 1, j);
		dfs(photo, team, threshold, i + 1, j);
	}

	/**
	 * @param pArr
	 * @param indx
	 * @return
	 */
	public Point[] sortPointArray(Point[] pArr, int indx) {
		for (int i = 0; i < indx; i++) {
			for (int j = i + 1; j < indx; j++) {
				if (pArr[i].x > pArr[j].x) { // then swap
					Point tmp = pArr[i];
					pArr[i] = pArr[j];
					pArr[j] = tmp;
				} else if (pArr[i].x == pArr[j].x && pArr[i].y > pArr[j].y) { // then
																				// swap
					Point tmp = pArr[i];
					pArr[i] = pArr[j];
					pArr[j] = tmp;
				}
			}
		}
		try {
			Point[] New = new Point[indx];
			for (int i = 0; i < indx; i++)
				New[i] = pArr[i];
			return New;
		} catch (Exception e) {
			return null;
		}
	}

	public void printPoints() {
		for (int i = 0; i < idx; i++)
			System.out.println("(" + players[i].x + " , " + players[i].y + ")");
	}
}
