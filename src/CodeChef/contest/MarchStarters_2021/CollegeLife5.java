/**
 * 03/28/21 morning
 * https://www.codechef.com/START2C/problems/COLGLF5
 */

package CodeChef.contest.MarchStarters_2021;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class CollegeLife5 {

	// Accepted
	void solve(int n, int m, int[] f, int[] c) {
//      System.out.println(n + " " + m);
//      System.out.println(Arrays.toString(f));
//      System.out.println(Arrays.toString(c));
		int[] a = new int[n + m];
		HashSet<Integer> fset = new HashSet<>();
		HashSet<Integer> cset = new HashSet<>();
		for (int i = 0; i < n; i++) {
			a[i] = f[i];
			fset.add(f[i]);
		}
		for (int i = 0; i < m; i++) {
			a[n + i] = c[i];
			cset.add(c[i]);
		}
		Arrays.sort(a);
//		System.out.println(fset);
//		System.out.println(cset);
//		System.out.println(Arrays.toString(a));
		int res = 0;
		char channel = 'f';
		if (cset.contains(a[0])) {
			res++;
			channel = 'c';
		}
		for (int i = 1; i < n + m; i++) {
			if (fset.contains(a[i])) {
				if (channel == 'c') {
					res++;
					channel = 'f';
				}
			} else if (cset.contains(a[i])) {
				if (channel == 'f') {
					res++;
					channel = 'c';
				}
			}
		}
		prni(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			int[] f = fs.readArray(n);
			int[] c = fs.readArray(m);
			solve(n, m, f, c);
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
		new CollegeLife5().run();
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