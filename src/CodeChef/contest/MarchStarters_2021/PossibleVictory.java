/**
 * 03/28/21 morning
 * https://www.codechef.com/START2C/problems/T20MCH
 */

package CodeChef.contest.MarchStarters_2021;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class PossibleVictory {

	// Accepted
	void solve(int R, int O, int C) {
		if ((20 - O) * 6 * 6 + C > R) {
			prs("YES");
		} else {
			prs("NO");
		}
	}

	private void run() {
		// read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int R = fs.nextInt();
		int O = fs.nextInt();
		int C = fs.nextInt();
		solve(R, O, C);
	}

	private final String INPUT = "input.txt";
	private final String OUTPUT = "output.txt";

	void read_write_file() {
		FileInputStream instream = null;
		PrintStream outstream = null;
		try {
			instream = new FileInputStream(INPUT);
			outstream = new PrintStream(new FileOutputStream(OUTPUT));
			System.setIn(instream);
			System.setOut(outstream);
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		new PossibleVictory().run();
	}

	void prni(int num) {
		out.println(num);
	}

	void prnl(long num) {
		out.println(num);
	}

	void prnd(double num) {
		out.println(num);
	}

	void prs(String s) {
		out.println(s);
	}

	void prc(char c) {
		out.println(c);
	}

	class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}