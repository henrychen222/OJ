/**
 * 06/26/21 noon
 * https://www.codechef.com/LTIME97C/problems/UNONE
 */
package CodeChef.contest.LTIME.JuneLunchtime2021_97;

import java.util.*;
import java.io.*;

class UnpleasantOnes {

	static PrintWriter pw;

	// Accepted --- 0.49sec https://www.codechef.com/viewsolution/48226464
	/*
	 * reference:
	 * https://www.codechef.com/viewsolution/48126783
	 * idea: greedy, concat all even, then all odd
	 */
	void solve(int n, int[] a) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for (int x : a) {
			if (x % 2 == 0) {
				even.add(x);
			} else {
				odd.add(x);
			}
		}
		for (int x : even) {
			pw.print(x + " ");
		}
		for (int x : odd) {
			pw.print(x + " ");
		}
//		for (int i = 0; i < n; i++) {
//			if (i % 2 == 0) {
//				pw.print(odd.get(0));
//				odd.remove(0);
//			} else {
//				pw.print(even.get(0));
//				even.remove(0);
//			}
//			pw.print(" ");
//		}
		pr("");
	}

	// don't know
	void solve1(int n, int[] a) {
		String[][] d = new String[n][3];
		for (int i = 0; i < n; i++) {
			d[i][0] = Integer.toBinaryString(a[i]);
			d[i][1] = i + "";
			d[i][2] = a[i] + "";
		}
		tr(d);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			solve(n, a);
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
		new UnpleasantOnes().run();
		pw.close();
	}

	void pr(int num) {
		pw.println(num);
	}

	void pr(long num) {
		pw.println(num);
	}

	void pr(double num) {
		pw.println(num);
	}

	void pr(String s) {
		pw.println(s);
	}

	void pr(char c) {
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