// 02/21/21 morning
package AtCoder.arc113.B;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

// From LayCurse
public class Main {

	// Accepted --- 79ms https://atcoder.jp/contests/arc113/submissions/20405020
	void solve(long a, long b, long c) {
		long k, res;
		// prnl(powL(b, c));
		if (powL(b, c) > 10) {
			k = powmod(b, c, 4) + 4;
		} else {
			k = powL(b, c);
		}
		res = powmod(a, k, 10);
		prnl(res);
	}

	long powL(long a, long b) {
		return (long) Math.pow(a, b);
	};

	long powmod(long a, long b, long mod) {
		long r = 1;
		while (b > 0) {
			if ((b & 1) == 1)
				r = r * a % mod;
			b >>= 1;
			a = a * a % mod;
		}
		return r;
	};

	private void run() {
		FastScanner fs = new FastScanner();
		long a = fs.nextLong();
		long b = fs.nextLong();
		long c = fs.nextLong();
		solve(a, b, c);
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