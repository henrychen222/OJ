// 02/19/21 morning and afternoon

package CodeForce.problemset.A_1490_DenseArray;

import java.util.*;
import java.math.*;
import java.io.*;
import static java.lang.System.out;

public class A_scanner_test {

	// Accepted --- 171ms https://codeforces.com/contest/1490/submission/107974901
	void solve(int n, int[] a) {
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

	private void run() { // Scanner is slower than FastScanner in BufferedReader (Don't use)
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			solve(n, a);
		}
	}

	public static void main(String[] args) {
		new A_scanner_test().run();
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