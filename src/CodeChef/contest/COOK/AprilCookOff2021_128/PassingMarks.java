/**
 * 04/18/21 noon
 * https://www.codechef.com/COOK128B/problems/PSGRADE
 */

package CodeChef.contest.COOK.AprilCookOff2021_128;

import java.util.*;
import java.io.*;

class PassingMarks {

	static PrintWriter pw;

	// Accepted --- 0.05sec
	void solve(int am, int bm, int cm, int tm, int a, int b, int c) {
		if (a < am || b < bm || c < cm || (a + b + c) < tm) {
			pw.println("NO");
			return;
		}
		pw.println("YES");
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int am = fs.nextInt();
			int bm = fs.nextInt();
			int cm = fs.nextInt();
			int tm = fs.nextInt();
			int a = fs.nextInt();
			int b = fs.nextInt();
			int c = fs.nextInt();
			solve(am, bm, cm, tm, a, b, c);
		}
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
		pw = new PrintWriter(System.out);
		new PassingMarks().run();
		pw.close();
	}

	void prni(int num) {
		pw.println(num);
	}

	void prnl(long num) {
		pw.println(num);
	}

	void prnd(double num) {
		pw.println(num);
	}

	void prs(String s) {
		pw.println(s);
	}

	void prc(char c) {
		pw.println(c);
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

		Integer[] readIntegerArray(int n) {
			Integer[] a = new Integer[n];
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