// 03/14/21 6:24 PM finished

package AtCoder.arc114.C;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class Main {
	private final int MAX = 5001;
	private final long MOD = 998244353;

	// Accepted --- 1636ms https://atcoder.jp/contests/arc114/submissions/20953012
	void solve(int n, int m) {
		int [][] dp = new int[MAX][MAX];
		for (int x = 0; x < MAX; x++) {
			dp[x][0] = 1;
			for (int i = 1; i < MAX; i++)
				dp[x][i] = (int) multi(dp[x][i - 1], x);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int x = 1; x <= m; x++)
				res = (int) add(res, multi(dp[m - x][i], dp[m][n - 1 - i]));

		}
		for (int d = 1; d < n; d++) {
			for (int x = 1; x <= m; x++)
				res = (int) add(res, multi(multi(n - d, x - 1), multi(dp[m - x][d - 1], dp[m][n - 1 - d])));
		}
		prnl(res);

	}

	long add(long x, long y) {
		x += y;
		if (x >= MOD)
			return x - MOD;
		return x;
	}

	long multi(long x, long y) {
		return x * y % MOD;
	};

	private void run() {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int m = fs.nextInt();
		solve(n, m);
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