/**
 * 06/26/21 noon
 * https://www.codechef.com/LTIME97C/problems/HTMLTAGS
 */
package CodeChef.contest.LTIME.JuneLunchtime2021_97;

import java.util.*;
import java.io.*;

class HTMLTags {

	static PrintWriter pw;

	// Accepted 0.13sec
	void solve(String s) {
		int n = s.length();
		if (n <= 3) { // bug: case like < </>
			pr("Error");
			return;
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (i == 0) {
				if (c != '<') {
					pr("Error");
					return;
				}
			} else if (i == 1) {
				if (c != '/') {
					pr("Error");
					return;
				}
			} else if (i == n - 1) {
				if (c != '>') {
					pr("Error");
					return;
				}
			} else {
				if (!Character.isDigit(c) && !Character.isLowerCase(c)) {
					pr("Error");
					return;
				}
			}
		}
		pr("Success");
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			String s = fs.next();
			solve(s);
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
		new HTMLTags().run();
		pw.close();
	}

	void pr(int num) {
		pw.println(num);
	}

	void pr(long num) {
		pw.println(num);
	}

	void pr(double num) {
		pw.println(num);
	}

	void pr(String s) {
		pw.println(s);
	}

	void pr(char c) {
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

	void tr(Object... o) {
		pw.println(Arrays.deepToString(o));
	}
}