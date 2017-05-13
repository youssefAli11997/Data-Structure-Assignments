package eg.edu.alexu.csd.datastructure.maze.cs75;

import java.io.File;
import java.io.FileNotFoundException;

public class testingUI {

	public static void main(String[] args) throws FileNotFoundException {
		MazeSolver ms = new MazeSolver();
		// you should give it the full path
		File f = new File("C:\\Users\\arabtech\\git\\data-structure\\src\\eg\\edu\\alexu\\csd\\datastructure\\maze\\cs75\\testCase.txt");
		ms.solveBFS(f);
		System.out.println("------------------------------------------------------------");
		ms.solveDFS(f);
	}

}
