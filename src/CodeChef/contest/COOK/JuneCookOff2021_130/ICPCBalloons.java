/**
 * 06/20/21 noon
 * https://www.codechef.com/COOK130C/problems/BALLOON
 */

package CodeChef.contest.COOK.JuneCookOff2021_130;

import java.util.*;
import java.io.*;

class ICPCBalloons {

	static PrintWriter pw;

	// Accepted --- 0.18sec
	void solve(int n, int[] a) {
       for (int i = n - 1; i >= 0; i--) {
    	   if (a[i] >= 1 && a[i] <= 7) {
    		   pr(i + 1);
    		   return;
    	   }
       }
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			solve(n, a);
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
		new ICPCBalloons().run();
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