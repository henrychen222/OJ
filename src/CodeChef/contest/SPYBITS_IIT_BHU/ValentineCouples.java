/**
 * 04/15/21 morning
 * https://www.codechef.com/SPYB21B/problems/VCOUPLE
 */

package CodeChef.contest.SPYBITS_IIT_BHU;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class ValentineCouples {

	// Accepted --- 0.35sec
	void solve(int n, int[] b, int[] g) {
		Arrays.sort(b);
		Arrays.sort(g);
		int res = 0;
		for (int i = 0, j = n - 1; i < n; i++, j--) {
			res = Math.max(res, b[i] + g[j]);
		}
		prni(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int[] b = fs.readArray(n);
			int[] g = fs.readArray(n);
			solve(n, b, g);
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
		new ValentineCouples().run();
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