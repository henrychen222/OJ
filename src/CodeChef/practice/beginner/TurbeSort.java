// 02/20/21 evening
package CodeChef.practice.beginner;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

// Accepted --- 4.95 sec https://www.codechef.com/viewsolution/42923549
class TurbeSort {

	void solve(int n, int[] a) {
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			prni(a[i]);
		}
	}

	private void run() {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int[] a = fs.readArray(n);
		solve(n, a);
	}

	public static void main(String[] args) {
		new TurbeSort().run();
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