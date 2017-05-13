package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.cs75.PlayersFinder;

/**
 * @author youssefAli
 *
 */
public class testCases {

	PlayersFinder pf = new PlayersFinder();

	@Test
	public void testCase1() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3",
				"VNDSD333", "OINFD33X" };

		Point[] ans = new Point[3];
		ans[0] = new Point(4, 5);
		ans[1] = new Point(13, 9);
		ans[2] = new Point(14, 2);

		Point[] ret = test.findPlayers(ph, 3, 16);
		for (int i = 0; i < 3; i++)
			Assert.assertEquals(ans[i], ret[i]);
	}

	@Test
	public void testCase2() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44",
				"44C4D4U444", "4V4Y4KB4M4", "G4W4HP4O4W", "4444ZDQ4S4",
				"4BR4Y4A444", "4G4V4T4444" };
		// (3,8), (4,16), (5,4), (16,3), (16,17), (17,9)
		Point[] ans = new Point[6];
		ans[0] = new Point(3, 8);
		ans[1] = new Point(4, 16);
		ans[2] = new Point(5, 4);
		ans[3] = new Point(16, 3);
		ans[4] = new Point(16, 17);
		ans[5] = new Point(17, 9);

		Point[] ret = test.findPlayers(ph, 4, 16);

		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ans[i], ret[i]);
	}

	@Test
	public void testCase3() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "8D88888J8L8E888", "88NKMG8N8E8JI88",
				"888NS8EU88HN8EO", "LUQ888A8TH8OIH8", "888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8",
				"8MX88D88888T8K8", "8S8A88MGVDG8XK8", "M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8" };
		// (1, 17), (3, 3), (3, 10), (3, 25), (5, 21), (8, 17), (9, 2), (10,9),
		// (12,23), (17,16), (18,3),
		// (18,11), (18,28), (22,20), (23,26), (24,15), (27,2), (28,26), (29,16)
		Point[] ans = new Point[19];
		ans[0] = new Point(1, 17);
		ans[1] = new Point(3, 3);
		ans[2] = new Point(3, 10);
		ans[3] = new Point(3, 25);
		ans[4] = new Point(5, 21);
		ans[5] = new Point(8, 17);
		ans[6] = new Point(9, 2);
		ans[7] = new Point(10, 9);
		ans[8] = new Point(12, 23);
		ans[9] = new Point(17, 16);
		ans[10] = new Point(18, 3);
		ans[11] = new Point(18, 11);
		ans[12] = new Point(18, 28);
		ans[13] = new Point(22, 20);
		ans[14] = new Point(23, 26);
		ans[15] = new Point(24, 15);
		ans[16] = new Point(27, 2);
		ans[17] = new Point(28, 26);
		ans[18] = new Point(29, 16);

		Point[] ret = test.findPlayers(ph, 8, 9);

		for (int i = 0; i < 19; i++)
			Assert.assertEquals(ans[i], ret[i]);
	}

	@Test
	public void testCase4() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };

		Point[] ans = new Point[2];
		ans[0] = new Point(5, 5);
		ans[1] = new Point(5, 5);
		Point[] ret = test.findPlayers(ph, 1, 1);
		Assert.assertEquals(ans[0], ret[0]);
		Assert.assertEquals(ans[1], ret[1]);
	}

	@Test
	public void testCase5() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "HFDFSDFSDF", "HFDFS3FSDF", "HFDFSDFSDF" };

		Point[] ret = test.findPlayers(ph, 3, 2);
		Assert.assertEquals(new Point(11, 3), ret[0]);
	}

	@Test
	public void testCase6() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "E11E11E", "111E111", "111E111", "E11E11E", };

		Point[] ret = test.findPlayers(ph, 1, 5);
		Assert.assertEquals(new Point(3, 4), ret[0]);
		Assert.assertEquals(new Point(11, 4), ret[1]);
	}

	@Test
	public void testCase7() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "YOUSSEF", "YO11SEF", "YO11SEF", "YOUSSEF", };

		Point[] ret = test.findPlayers(ph, 1, 5);
		Assert.assertEquals(new Point(6, 4), ret[0]);
	}

	@Test
	public void testCase8() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "1111111", "1111111", "1111111", "1111111", };

		Point[] ret = test.findPlayers(ph, 1, 20);
		Assert.assertEquals(new Point(7, 4), ret[0]);
	}

	@Test
	public void testCase9() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "1111111", "111E111", "111E111", "1111111", };

		Point[] ret = test.findPlayers(ph, 1, 20);
		Assert.assertEquals(new Point(7, 4), ret[0]);
	}

	@Test
	public void testCase10() {
		IPlayersFinder test = (IPlayersFinder) pf;
		String[] ph = { "1111111", "YO11S11", "1111111", "11USSEF", "1111111", };

		Point[] ret = test.findPlayers(ph, 1, 50);
		Assert.assertEquals(new Point(7, 5), ret[0]);
	}
}
