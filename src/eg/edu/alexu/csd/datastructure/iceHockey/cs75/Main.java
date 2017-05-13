package eg.edu.alexu.csd.datastructure.iceHockey.cs75;

/**
 * @author youssefAli
 *
 */
public class Main {

	public static void main(String[] args) {
		PlayersFinder pf = new PlayersFinder();
		String[] ph = { "HFDFSDFSDF", "HFDFS3FSDF", "HFDFSDFSDF" };

		pf.findPlayers(ph, 3, 2);
		pf.printPoints();
	}
}