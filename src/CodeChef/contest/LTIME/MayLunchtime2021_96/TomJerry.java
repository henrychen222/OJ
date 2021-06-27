/**
 * 05/31/21 morning
 * https://www.codechef.com/LTIME96C/problems/TANDJ1
 */

package CodeChef.contest.LTIME.MayLunchtime2021_96;

import java.util.*;
import java.io.*;

class TomJerry {

	static PrintWriter pw;

	// Accepted
	void solve(int x1, int y1, int x2, int y2, int k) {
		int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		if (k < dis) {
			prs("NO");
		} else if (k == dis) {
			prs("YES");
		} else {
			int rest = k - dis;
			if (rest % 2 == 0) {
				prs("YES");
			} else {
				prs("NO");
			}
		}
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int x1 = fs.nextInt();
			int y1 = fs.nextInt();
			int x2 = fs.nextInt();
			int y2 = fs.nextInt();
			int k = fs.nextInt();
			solve(x1, y1, x2, y2, k);
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
		new TomJerry().run();
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

	void tr(Object... o) {
		pw.println(Arrays.deepToString(o));
	}
}
