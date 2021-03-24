/**
 * 03/23/21 afternoon
 * https://www.codechef.com/problems/FCTRL2
 */

package CodeChef.practice.beginner;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

class SmallFactorials {

	// Accepted --- 0.1sec with scanner,
	// Accepted --- 0.07sec with fast scanner
	void solve(int n) {
		BigInteger res = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			res = res.multiply(BigInteger.valueOf(i));
		}
		prnbi(res);
	}

	// Accepted --- 0.08sec with FastScanner
	void solve1(int n) {
		BigInteger[] a = new BigInteger[n];
		a[0] = new BigInteger("1");
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1].multiply(new BigInteger(i + 1 + ""));
		}
		prnbi(a[n - 1]);
	}

	private void run2() {
		// read_write_file();
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			solve(n);
		}
	}

	// Accepted --- 0.07sec
	private void run() {
		// read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			solve(n);
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
		new SmallFactorials().run();
	}

	void prnbi(BigInteger num) {
		out.println(num);
	}

// fucking issue, have to remove the unused code, complain file is too long
//	void prni(int num) {
//		out.println(num);
//	}
//	
//	void prnl(long num) {
//		out.println(num);
//	}
//
//	void prnd(double num) {
//		out.println(num);
//	}
//
//	void prs(String s) {
//		out.println(s);
//	}
//
//	void prc(char c) {
//		out.println(c);
//	}
//
//	void prai(int[] a) {
//		out.println(Arrays.toString(a));
//	}
//
//	void pral(long[] a) {
//		out.println(Arrays.toString(a));
//	}
//
//	void prad(double[] a) {
//		out.println(Arrays.toString(a));
//	}
//
//	void pras(String[] a) {
//		out.println(Arrays.toString(a));
//	}
//
//	void prac(char[] a) {
//		out.println(Arrays.toString(a));
//	}
//
//	void prdai(int[][] a) {
//		out.println(Arrays.deepToString(a));
//	}
//
//	void prdal(long[][] a) {
//		out.println(Arrays.deepToString(a));
//	}
//
//	void prdad(double[][] a) {
//		out.println(Arrays.deepToString(a));
//	}
//
//	void prdas(String[][] a) {
//		out.println(Arrays.deepToString(a));
//	}
//
//	void prdac(char[][] a) {
//		out.println(Arrays.deepToString(a));
//	}
//
//	void prli(List<Integer> l) {
//		out.println(l);
//	}
//
//	void prll(List<Long> l) {
//		out.println(l);
//	}
//
//	void prld(List<Double> l) {
//		out.println(l);
//	}
//
//	void prls(List<String> l) {
//		out.println(l);
//	}
//
//	void prlc(List<Character> l) {
//		out.println(l);
//	}

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

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}