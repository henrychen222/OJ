/**
 * 03/21/21 noon
 * https://www.codechef.com/COOK127C/problems/WEIGHTBL
 * 
 * wrote a post: https://discuss.codechef.com/t/cook127-weightba-tle-solution-get-ac/86977
 */

package CodeChef.contest.COOK.MarchCookOff2021_127;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class WeightBalance {

	// 03/22/21 night Accepted --- 0.65sec
	void solve(int w1, int w2, int x1, int x2, int M) {
		int min = x1 * M;
		int max = x2 * M;
		int increase = w2 - w1;
		if (increase < min || increase > max) {
			prni(0);
			return;
		}
		prni(1);
	}

	// WA, thought it is TLE then switch to C++, pass
//	void solve(int w1, int w2, int x1, int x2, int M) {
//		int min = x1 * x2;
//		int max = x2 * M;
//		int increase = w2 - w1;
//		if (increase < min || increase > max) {
//			prni(0);
//			return;
//		}
//		prni(1);
//	}

	private void run() {
		read_write_file();
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int w1 = fs.nextInt();
			int w2 = fs.nextInt();
			int x1 = fs.nextInt();
			int x2 = fs.nextInt();
			int M = fs.nextInt();
			solve(w1, w2, x1, x2, M);
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
		new WeightBalance().run();
	}

	void prni(int num) {
		out.println(num);
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
}