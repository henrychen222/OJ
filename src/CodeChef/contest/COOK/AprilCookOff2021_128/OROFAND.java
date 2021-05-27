/**
 * 04/18/21 noon
 * https://www.codechef.com/COOK128B/problems/OROFAND
 */

package CodeChef.contest.COOK.AprilCookOff2021_128;

import java.util.*;
import java.io.*;

class OROFAND {

	static PrintWriter pw;

	// Accepted --- 0.41sec  05/26/21 evening
	// reference: https://www.codechef.com/viewsolution/45152263
	void solve(int n, int q, long[] a, int[] x, int[] v) {
		// trace(a);
		int[] cnt = new int[35];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 35; j++) {
				if ((a[i] >> j & 1) == 1) {
					// pw.println(a[i] + " " + j);
					cnt[j]++;
				}
			}
		}
		// trace("cnt", cnt);
		int res = 0;
		for (int i = 0; i < 35; i++) {
			if (cnt[i] > 0) {
				// trace("each", cnt[i]);
				res += 1 << i;
				// trace("res", res);
			}

		}
		prni(res);
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 35; j++) {
				if ((1 & a[x[i]] >> j) == 1) {
					cnt[j]--;
				}
			}
			a[x[i]] = v[i];
			for (int j = 0; j < 35; j++) {
				if ((1 & a[x[i]] >> j) == 1) {
					cnt[j]++;
				}
			}
			res = 0;
			for (int k = 0; k < 35; k++) {
				if (cnt[k] > 0)
					res += 1 << k;
			}
			prni(res);
		}
	}

	// don't know
	void solve1(int n, int q, int[] a, int[] x, int[] v) {
		pw.println(1 & 2 & 3);
		pw.println(n + " " + q);
		pw.println("a" + " " + Arrays.toString(a));
//		pw.println(Arrays.toString(x));
//		pw.println(Arrays.toString(v));
		int[] pre = new int[n + 1];
		for (int i = 0; i < n; i++) {
			pre[i + 1] = pre[i] & a[i];
		}
		pw.println("pre" + " " + Arrays.toString(pre));
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int[] sub = Arrays.copyOfRange(a, i, j + 1);
				pw.println(Arrays.toString(sub));
			}
		}
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int q = fs.nextInt();
			long[] a = fs.readlongArray(n);
			int[] x = new int[q];
			int[] v = new int[q];
			for (int i = 0; i < q; i++) {
				x[i] = fs.nextInt() - 1;
				v[i] = fs.nextInt();
			}
			solve(n, q, a, x, v);
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
		new OROFAND().run();
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

		long[] readlongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
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

	void trace(int x) {
		pw.println(x);
	}

	void trace(long x) {
		pw.println(x);
	}

	void trace(char c) {
		pw.println(c);
	}

	void trace(String s) {
		pw.println(s);
	}

	void trace(int[] a) {
		pw.println(Arrays.toString(a));
	}

	void trace(long[] a) {
		pw.println(Arrays.toString(a));
	}

	void trace(int[][] a) {
		pw.println(Arrays.deepToString(a));
	}

	void trace(long[][] a) {
		pw.println(Arrays.deepToString(a));
	}

	//////////////////////////////////////
	void trace(String hint, int x) {
		pw.println(hint + " " + x);
	}

	void trace(String hint, long x) {
		pw.println(hint + " " + x);
	}

	void trace(String hint, char c) {
		pw.println(hint + " " + c);
	}

	void trace(String hint, String s) {
		pw.println(hint + " " + s);
	}

	void trace(String hint, int[] a) {
		pw.println(hint + " " + Arrays.toString(a));
	}

	void trace(String hint, long[] a) {
		pw.println(hint + " " + Arrays.toString(a));
	}

	void trace(String hint, int[][] a) {
		pw.println(hint + " " + Arrays.deepToString(a));
	}

	void trace(String hint, long[][] a) {
		pw.println(hint + " " + Arrays.deepToString(a));
	}

}