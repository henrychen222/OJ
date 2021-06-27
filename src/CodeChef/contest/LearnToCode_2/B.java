/**
 * 02/25/21 morning
 * https://www.codechef.com/LTC22021/problems/LTC06
 */

package CodeChef.contest.LearnToCode_2;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class B {

	// 06/26/21 evening
	// reference: https://www.codechef.com/viewsolution/43056147
	// Accepted --- 0.05sec https://www.codechef.com/viewsolution/48234209
	void solve(int n) {
		long[] dp = new long[n];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 3;
		for (int i = 3; i < n; i++) {
			dp[i] = dp[i - 3] + dp[i - 1];
		}
		prnl(dp[n - 1]);
	}

	// WA
	void solve1(int n) {
		long[] dp = new long[n];
		dp[0] = 1L;
		dp[1] = 2L;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] * 3 / 2;
		}
		prnl(dp[n - 1]);
		// prs(dp[n - 1] + "");
	}

	private void run() {
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			solve(n);
		}
	}

	public static void main(String[] args) {
		new B().run();
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