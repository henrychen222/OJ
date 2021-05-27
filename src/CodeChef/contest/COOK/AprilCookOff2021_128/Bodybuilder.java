/**
 * 04/18/21 noon
 * https://www.codechef.com/COOK128B/problems/BUILDB
 */

package CodeChef.contest.COOK.AprilCookOff2021_128;

import java.util.*;
import java.io.*;

class Bodybuilder {

	static PrintWriter pw;

	// Accepted --- 0.31sec  05/26/21 evening
	// reference: https://www.codechef.com/viewsolution/45144135
	void solve(int n, int r, int[] a, int[] b) {
		int preT = a[0];
		long tension = 0;
		long res = 0;
		for (int i = 0; i < n; i++) {
			tension = Math.max(0, tension - (a[i] - preT) * r);
			tension += b[i];
			res = Math.max(res, tension);
			preT = a[i];
		}
		prnl(res);
	}

	// WA
	void solve2(int n, int r, int[] a, int[] b) {
		int preT = a[0];
		long tension = b[0];
		long res = b[0];
		for (int i = 1; i < n; i++) {
			tension -= r * (a[i] - preT); // issue
			tension += b[i];
			res = Math.max(res, tension);
			preT = a[i];
		}
		prnl(res);
	}

	void solve1(int n, int r, int[] a, int[] b) {
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			tm.put(a[i], b[i]);
		}
		int preT = tm.firstKey();
		int sten = tm.get(preT);
		long tension = sten;
		long res = sten;
		tm.remove(preT);
		for (int k : tm.keySet()) {
			int v = tm.get(k);
			tension -= r * (k - preT);
			tension += v;
			res = Math.max(res, tension);
			preT = k;
		}
		prnl(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int r = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] b = fs.readArray(n);
			solve(n, r, a, b);
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
		new Bodybuilder().run();
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