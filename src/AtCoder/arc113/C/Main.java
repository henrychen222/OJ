/**
 * 02/21/21 morning
 * https://atcoder.jp/contests/arc113/tasks/arc113_c
 */
package AtCoder.arc113.C;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class Main {

	// TLE: algorithm is correct
	void solve(String s) {
		int n = s.length();
		List<Integer> repeat = new ArrayList<>();
		char[] a = s.toCharArray();
		for (int i = 1; i < n - 1; i++) {
			if (a[i - 1] == a[i] && a[i] != a[i + 1]) {
				repeat.add(i - 1);
			}
		}
		int nr = repeat.size();
		int res = 0;
		for (int i = nr - 1; i >= 0; i--) {
			int cnt = 0;
			int idx = repeat.get(i);
			for (int j = idx; j < n; j++) {
				if (a[idx] == a[j])
					continue;
				cnt++;
			}
			res += cnt;
			for (int k = idx + 2; k < n; k++) {
				a[k] = a[idx];
			}
		}
		prni(res);
	}

	private void run() {
		FastScanner fs = new FastScanner();
		String s = fs.next();
		solve(s);
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