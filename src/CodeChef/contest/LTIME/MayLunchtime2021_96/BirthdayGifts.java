/**
 * 05/31/21 morning
 * https://www.codechef.com/LTIME96C/problems/TWINGFT
 */

package CodeChef.contest.LTIME.MayLunchtime2021_96;

import java.util.*;
import java.io.*;

class BirthdayGifts {

	static PrintWriter pw;

	// Accepted --- 0.22sec
	/**
	 * reference: https://www.youtube.com/watch?v=4Qx2WL0hozA
	 * https://www.codechef.com/viewsolution/47192675
	 */
	void solve3(int n, int k, int[] a) {
		Arrays.sort(a);
		long res1 = 0;
		long res2 = 0;
		int i;
		for (i = n - 1; i >= 0 && k-- > 0; i -= 2) {
			res1 += a[i];
			res2 += a[i - 1];
		}
		res2 += a[i];
		pr(Math.max(res1, res2));
	}

	// Accepted --- 0.55sec
	// reference: https://www.codechef.com/viewsolution/47147672
	void solve2(int n, int k, Integer[] a) {
		Arrays.sort(a, (x, y) -> y - x);
		long res1 = 0;
		long res2 = 0;
		for (int i = 0; i < k; i++) {
			res1 += a[2 * i];
			res2 += a[2 * i + 1];
		}
		res2 += a[2 * k];
		pr(Math.max(res1, res2));
	}

	////////////////////////////////////////////////
	// Accepted --- 0.20sec
	// even odd is the same condition
	void solve(int n, int k, int[] a) {
		Arrays.sort(a);
		long res1 = 0;
		long res2 = 0;
		if (n % 2 == 1) {
			int i;
			for (i = n - 1; i - 2 >= 0 && k-- > 0; i -= 2) {
				res1 += a[i];
				res2 += a[i - 1];
			}
			res2 += a[i];
			pr(Math.max(res1, res2));
		} else {
			int i;
			for (i = n - 1; i - 2 >= 0 && k-- > 0; i -= 2) {
				res1 += a[i];
				res2 += a[i - 1];
			}
			res2 += a[i];
			pr(Math.max(res1, res2));
		}
	}

	// WA
	void solve1(int n, int k, int[] a) {
		Arrays.sort(a);
		// tr(a, k);
		long res1 = 0;
		long res2 = 0;
		if (n % 2 == 1) {
			int i;
			for (i = n - 1; i > 2 && k > 1; i -= 2) {
				res1 += a[i];
				res2 += a[i - 1];
				// k--; // miss
			}
			// tr(res1, res2, "stop", a[i]);
			res1 += a[i];
			res2 = res2 + a[i - 1] + a[i - 2];
			// tr(res1, res2);
			pr(Math.max(res1, res2));
		} else {
			int i;
			for (i = n - 1; i > 1 && k > 1; i -= 2) {
				res1 += a[i];
				res2 += a[i - 1];
				k--;
			}
//			res1 += a[i];
//			res2 += a[i - 1];
			res2 = res2 + a[i] + a[i - 1];
			pr(Math.max(res1, res2));
		}
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			int[] a = fs.readArray(n);
			// Integer[] a = fs.readIntegerArray(n);
			solve(n, k, a);
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
		new BirthdayGifts().run();
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
