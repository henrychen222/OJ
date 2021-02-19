// 02/19/21 morning and afternoon
// don't know how to run in local, only use custom test in cf

package CodeForce.problemset.A_1490_DenseArray;

import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.System.out;

public class A {
	// Accepted --- 124ms https://codeforces.com/contest/1490/submission/107974255
	void solve1(int n, int[] a) {
		int res = 0;
		for (int i = 0; i + 1 < n; i++) {
			int min = Math.min(a[i], a[i + 1]);
			int max = Math.max(a[i], a[i + 1]);
			while (max > min && max / (double) min > 2) {
				if (max % 2 == 0) {
					max /= 2;
				} else {
					max = max / 2 + 1;
				}
				res++;
			}
		}
		prni(res);
	}

	void solve(int n, int[] a) {
		int res = 0;
		for (int i = 0; i + 1 < n; i++) {
			int min = Math.min(a[i], a[i + 1]);
			int max = Math.max(a[i], a[i + 1]);
			while (max > min && max / (double) min > 2) {
				max = (int) Math.ceil((max / (double) 2));
				res++;
			}
		}
		prni(res);
	}
	
	private void run() {
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			solve(n, a);
		}
	}

	public static void main(String[] args) {
		new A().run();
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