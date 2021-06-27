/**
 * 05/31/21 morning
 * https://www.codechef.com/LTIME96C/problems/CHARGES
 */

package CodeChef.contest.LTIME.MayLunchtime2021_96;

import java.util.*;
import java.io.*;

class Charges {

	static PrintWriter pw;

	// Accepted
	void solve(int n, int k, String s, int[] Q) {
		// tr(n, k, s, q);
		char[] a = s.toCharArray();
		if (n == 1) {
			// prni(2);
			prni(0); // fuck here
			return;
		}
		long sum = cal(a);
		for (int q : Q) {
			int i = q - 1;
			if (i == 0) {
				char[] pre = { a[i], a[i + 1] };
				a[i] ^= 1;
				char[] cur = { a[i], a[i + 1] };
				sum = sum - cal(pre) + cal(cur);
			} else if (i == n - 1) {
				char[] pre = { a[i - 1], a[i] };
				a[i] ^= 1;
				char[] cur = { a[i - 1], a[i] };
				sum = sum - cal(pre) + cal(cur);
			} else {
				char[] pre = { a[i - 1], a[i], a[i + 1] };
				a[i] ^= 1;
				char[] cur = { a[i - 1], a[i], a[i + 1] };
				sum = sum - cal(pre) + cal(cur);
			}
			prnl(sum);
		}
	}

	long cal(char[] a) {
		int n = a.length;
		long sum = 0;
		for (int i = 0; i + 1 < n; i++) {
			if (a[i] == a[i + 1]) {
				sum += 2;
			} else {
				sum++;
			}
		}
		return sum;
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			String s = fs.next();
			int[] q = fs.readArray(k);
			solve(n, k, s, q);
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
		new Charges().run();
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
