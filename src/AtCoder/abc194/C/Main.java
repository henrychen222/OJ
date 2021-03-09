/**
 * 03/06/21 morning
 * https://atcoder.jp/contests/abc194/tasks/abc194_c
 */

package AtCoder.abc194.C;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Main {

	// TLE
//	void solve(int n, long[] a) {
//		long res = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = i + 1; j < n; j++) {
//				res += (a[i] - a[j]) * (a[i] - a[j]);
//			}
//		}
//		prnl(res);
//	}

	// Accepted --- 257ms https://atcoder.jp/contests/abc194/submissions/20732703 
	void solve(int n, long[] a) {
		long res = 0;
		long s1 = 0;
		long s2 = 0;
		for (long e : a) {
			s1 += e;
			s2 += e * e;
		}
		prnl(s2 * n - s1 * s1);
	}

	private void run() {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextLong();
		}
		solve(n, a);

	}

	public static void main(String[] args) {
		new Main().run();
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

	void prai(int[] a) {
		out.println(Arrays.toString(a));
	}

	void pral(long[] a) {
		out.println(Arrays.toString(a));
	}

	void prad(double[] a) {
		out.println(Arrays.toString(a));
	}

	void pras(String[] a) {
		out.println(Arrays.toString(a));
	}

	void prac(char[] a) {
		out.println(Arrays.toString(a));
	}

	void prdai(int[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdal(long[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdad(double[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdas(String[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdac(char[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prli(List<Integer> l) {
		out.println(l);
	}

	void prll(List<Long> l) {
		out.println(l);
	}

	void prld(List<Double> l) {
		out.println(l);
	}

	void prls(List<String> l) {
		out.println(l);
	}

	void prlc(List<Character> l) {
		out.println(l);
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
	}
}
