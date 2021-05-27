/**
 * 05/23/21 noon
 * https://www.codechef.com/COOK129C/problems/MARARUN
 */

package CodeChef.contest.COOK.MayCookOff2021_129;

import java.util.*;
import java.io.*;

class Marathon {

	static PrintWriter pw;

	// Accepted --- 0.05sec
	void solve(int D, int d, int A, int B, int C) {
		int m = D * d;
		if (m >= 42) {
			prni(C);
		} else if (m >= 21) {
			prni(B);
		} else if (m >= 10) {
			prni(A);
		} else {
			prni(0);
		}
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int D = fs.nextInt();
			int d = fs.nextInt();
			int A = fs.nextInt();
			int B = fs.nextInt();
			int C = fs.nextInt();
			solve(D, d, A, B, C);
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
		new Marathon().run();
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