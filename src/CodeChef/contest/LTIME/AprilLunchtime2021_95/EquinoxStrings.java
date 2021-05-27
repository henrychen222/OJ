/**
 * 04/30/21 morning
 * https://www.codechef.com/LTIME95C/problems/EQUINOX
 */

package CodeChef.contest.LTIME.AprilLunchtime2021_95;

import java.util.*;
import java.io.*;

class EquinoxStrings {

	static PrintWriter pw;

	// Accepted
	void solve(int n, int a, int b, String[] S) {
//		pw.println(n + " " + a + " " + b);
//		pw.println(Arrays.toString(S));
		long Sarthak = 0;
	    long Anuradha = 0;
		for (int i = 0; i < n; i++) {
			if (ok(S[i])) {
				Sarthak += a;
			} else {
				Anuradha += b;
			}
		}
//		pw.println(Sarthak + " " + Anuradha);
		if (Sarthak > Anuradha) {
			prs("SARTHAK");
		} else if (Sarthak < Anuradha) {
			prs("ANURADHA");
		} else {
			prs("DRAW");
		}
	}

	boolean ok(String s) {
		char c = s.charAt(0);
		if (c == 'E' || c == 'Q' || c == 'U' || c == 'I' || c == 'N' || c == 'O' || c == 'X') {
			return true;
		}
		return false;
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int a = fs.nextInt();
			int b = fs.nextInt();
			String[] S = new String[n];
			for (int i = 0; i < n; i++) {
				S[i] = fs.next();
			}
			solve(n, a, b, S);
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
		new EquinoxStrings().run();
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