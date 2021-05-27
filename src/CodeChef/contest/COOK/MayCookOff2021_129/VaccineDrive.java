/**
 * 05/23/21 noon
 * https://www.codechef.com/COOK129C/problems/VACCINE3
 */

package CodeChef.contest.COOK.MayCookOff2021_129;

import java.util.*;
import java.io.*;

class VaccineDrive {

	static PrintWriter pw;

	// reference: https://www.codechef.com/viewsolution/46781107
	// Accepted --- 0.24sec 
	void solve(int g, int p, int[] a) {
		// pw.println(g + " " + p + " " + Arrays.toString(a));
		int sum = 0;
		for (int i = g - 1; i < 10; i++) {
			sum += a[i];
		}
//		int n = a.length;
//		for (int i = n - 1; i >= g - 1; i--) { // Accepted --- 0.24sec
//			sum += a[i];
//		}
		int pre = sum - a[g - 1];
		pw.println(a[g - 1] + " " + sum + " " + pre);
		int cur = a[g - 1];
		int rest = pre % p;
		int preD = pre / p;
		if (rest == 0) {
			int min = preD;
			int max = preD;
			min++;
			if (cur % p == 0) {
				max += cur / p;
			} else {
				max += cur / p + 1;
			}
			pw.println(min + " " + max);
		} else {
			int min = preD + 1;
			int max = preD;
			int fi = rest + cur;
			if (fi % p == 0) {
				max += fi / p;
			} else {
				max += fi / p + 1;
			}
			pw.println(min + " " + max);
		}
	}

	// don't know, close
	void solve2(int g, int p, int[] a) {
		// pw.println(g + " " + p + " " + Arrays.toString(a));
		int n = a.length;
		int pre = 0;
		for (int i = n - 1; i > g; i--) {
			pre += a[i];
		}

		int rest = pre % p;
		int preD = pre / p;
		int min = preD;
		int max = preD;
		int curP = p;
		if (rest > 0) {
			curP -= rest;
		}
		if (curP > 0) {
			min = preD + 1;
		} else {
			min = preD + 2;
		}
		pw.println(pre + " " + preD + " " + rest);
		int cur = a[g];
		int fi = rest + cur;
		if (fi % p == 0) {
			max += fi / p;
		} else {
			max += (fi / p + 1);
		}
		pw.println(min + " " + max);

	}

	// WA
	void solve1(int g, int p, int[] a) {
		// pw.println(g + " " + p + " " + Arrays.toString(a));
		int n = a.length;
		int sum = 0;
		for (int i = g - 1; i < n; i++) {
			sum += a[i];
		}
		// pw.println(sum);
		int res = sum / p;
		int rest = sum % p;
		if (rest == 0) {
			prs(res + " " + res);
		} else {
			prs(res + " " + (res + rest));
		}
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int[] a = fs.readArray(12);
			solve(a[0], a[1], Arrays.copyOfRange(a, 2, 12));
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
		new VaccineDrive().run();
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
}