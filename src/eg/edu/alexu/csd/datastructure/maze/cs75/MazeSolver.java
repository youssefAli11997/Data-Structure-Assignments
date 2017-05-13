package eg.edu.alexu.csd.datastructure.maze.cs75;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs75.LinkedBasedQueue;
import eg.edu.alexu.csd.datastructure.stack.cs75.Stack;

public class MazeSolver implements IMazeSolver {

	private class myPoint {
		private Point[] p = new Point[2];

		private myPoint(Point ch, Point pa) {
			p[0] = ch;
			p[1] = pa;
		}
	}

	private int rows = 0;
	private int cols = 0;
	private int[] sPos = new int[2];
	private ArrayList<myPoint> path = new ArrayList<myPoint>();
	private char[][] aMaze;
	private boolean[][] vis;

	@Override
	public int[][] solveBFS(File maze) {

		try {
			aMaze = getMaze(maze);
			vis = new boolean[rows][cols];
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		LinkedBasedQueue BFSContainer = new LinkedBasedQueue();
		myPoint start = new myPoint(new Point(sPos[0], sPos[1]), new Point(
				sPos[0], sPos[1]));
		BFSContainer.enqueue(start);
		vis[sPos[0]][sPos[1]] = true;
		path.add(start);
		while (!BFSContainer.isEmpty()) {
			myPoint tmp = (myPoint) BFSContainer.dequeue();
			char T = aMaze[tmp.p[0].x][tmp.p[0].y];
			int i = tmp.p[0].x;
			int j = tmp.p[0].y;
			if (T == 'E') {
				path.add(tmp);
				return getPath(path, i, j);
			}
			if (T == '#')
				continue;
			path.add(tmp);
			if (isValid(i + 1, j, T))
				if (!vis[i + 1][j]) {
					BFSContainer.enqueue(new myPoint(new Point(i + 1, j),
							new Point(i, j)));
					vis[i + 1][j] = true;
				}
			if (isValid(i, j - 1, T))
				if (!vis[i][j - 1]) {
					BFSContainer.enqueue(new myPoint(new Point(i, j - 1),
							new Point(i, j)));
					vis[i][j - 1] = true;
				}
			if (isValid(i, j + 1, T))
				if (!vis[i][j + 1]) {
					BFSContainer.enqueue(new myPoint(new Point(i, j + 1),
							new Point(i, j)));
					vis[i][j + 1] = true;
				}
		}
		return null;
	}

	@Override
	public int[][] solveDFS(File maze) {
		try {
			aMaze = getMaze(maze);
			vis = new boolean[rows][cols];
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		Stack DFSContainer = new Stack();
		myPoint start = new myPoint(new Point(sPos[0], sPos[1]), new Point(
				sPos[0], sPos[1]));
		DFSContainer.push(start);
		vis[sPos[0]][sPos[1]] = true;
		path.add(start);
		while (!DFSContainer.isEmpty()) {
			myPoint tmp = (myPoint) DFSContainer.pop();
			char T = aMaze[tmp.p[0].x][tmp.p[0].y];
			int i = tmp.p[0].x;
			int j = tmp.p[0].y;
			if (T == 'E') {
				path.add(tmp);
				return getPath(path, i, j);
			}
			if (T == '#')
				continue;
			path.add(tmp);
			if (isValid(i, j - 1, T))
				if (!vis[i][j - 1]) {
					DFSContainer.push(new myPoint(new Point(i, j - 1),
							new Point(i, j)));
					vis[i][j - 1] = true;
				}
			if (isValid(i, j + 1, T))
				if (!vis[i][j + 1]) {
					DFSContainer.push(new myPoint(new Point(i, j + 1),
							new Point(i, j)));
					vis[i][j + 1] = true;
				}
			if (isValid(i - 1, j, T))
				if (!vis[i - 1][j]) {
					DFSContainer.push(new myPoint(new Point(i - 1, j),
							new Point(i, j)));
					vis[i - 1][j] = true;
				}
			if (isValid(i + 1, j, T))
				if (!vis[i + 1][j]) {
					DFSContainer.push(new myPoint(new Point(i + 1, j),
							new Point(i, j)));
					vis[i + 1][j] = true;
				}
		}
		return null;
	}

	private int[][] getPath(ArrayList<myPoint> path, int Ex, int Ey) {
		Point[][] g = new Point[rows][cols];
		ArrayList<Point> coPathList = new ArrayList<Point>();
		for (int i = 0; i < path.size(); i++)
			g[path.get(i).p[0].x][path.get(i).p[0].y] = new Point(
					path.get(i).p[1].x, path.get(i).p[1].y);
		int i = Ex, j = Ey;
		while (i != g[i][j].x || j != g[i][j].y) {
			coPathList.add(new Point(i, j));
			int tmpI = i;
			i = g[i][j].x;
			j = g[tmpI][j].y;
		}
		coPathList.add(new Point(i, j));
		int size = coPathList.size();
		int[][] coPath = new int[size][2];
		for (int m = 0; m < size; m++) {
			coPath[size - 1 - m][0] = coPathList.get(m).x;
			coPath[size - 1 - m][1] = coPathList.get(m).y;
		}
		return coPath;
	}

	private boolean isValid(int i, int j, char T) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || T == '#') {
			return false;
		}
		return true;
	}

	public char[][] getMaze(File maze) throws FileNotFoundException {
		Scanner sc = new Scanner(maze);
		try {
			this.rows = sc.nextInt();
			this.cols = sc.nextInt();
		} catch (Exception e) {
			throw new RuntimeException("Invalid File");
		}
		sc.nextLine();
		boolean hasStart = false;
		boolean hasEnd = false;
		char[][] aMaze = new char[rows][cols];
		for (int i = 0; i < this.rows; i++) {
			String dummy = sc.next();
			for (int j = 0; j < this.cols; j++) {
				aMaze[i][j] = dummy.charAt(j);
				if (aMaze[i][j] == 'S') {
					hasStart = true;
					sPos[0] = i;
					sPos[1] = j;
				}
				if (aMaze[i][j] == 'E')
					hasEnd = true;
			}
		}
		if (!hasEnd || !hasStart)
			throw new RuntimeException("Has no end");
		return aMaze;
	}
}