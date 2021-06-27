/**
 * 05/31/21 morning
 * https://www.codechef.com/LTIME96C/problems/CHESUB
 */

package CodeChef.contest.LTIME.MayLunchtime2021_96;

import java.util.*;
import java.io.*;

class KSubarrays {

	static PrintWriter pw;

	// 06/26/21 evening
	// Accepted --- 0.38sec  https://www.codechef.com/viewsolution/48234148
	/**
	 * reference:
	 * https://www.codechef.com/viewsolution/47140992
	 */
	private final long inf = (long) 1e18;
	void solve(int n, int k, int[] a) {
		// tr(n, k, a);
		long[] dp = new long[2 * k + 1];
		Arrays.fill(dp, -inf);
		dp[0] = 0;
		for (int x : a) {
			long[] ndp = new long[2 * k + 1];
			Arrays.fill(ndp, -inf);
			for (int i = 0; i <= 2 * k; i++) {
				if (i % 2 == 0) {
					ndp[i] = Math.max(ndp[i], dp[i]);
					if (i + 1 <= 2 * k) {
						ndp[i + 1] = Math.max(ndp[i + 1], dp[i] + (i + 2) / 2 * x);
					}
				} else {
					ndp[i] = Math.max(ndp[i], dp[i] + (i + 1) / 2 * x);
					ndp[i + 1] = Math.max(ndp[i + 1], dp[i]);
					if (i + 2 <= 2 * k) {
						ndp[i + 2] = Math.max(ndp[i + 2], dp[i] + (i + 3) / 2 * x);
					}
				}
			}
			long[] tmp = ndp;
			ndp = dp;
			dp = tmp;
		}
		pr(Math.max(dp[2 * k - 1], dp[2 * k]));
	}

	// don't know
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
			int[] a = fs.readArray(n);
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
		new KSubarrays().run();
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
