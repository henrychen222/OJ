/**
 * 04/15/21 morning
 * https://www.codechef.com/SPYB21B/problems/GOTHAM
 */

package CodeChef.contest.SPYBITS_IIT_BHU;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class MissionGotham {

	int[] cnt;
	int n;
	int[] a;

	// TLE
	void solve(int x, int k) {
//		out.println(Arrays.toString(a));
//		out.println(x + " " + k);
		int res = 0;
		int start = x - 1;
		for (int i = start; i < n && k > 0; i++) {
			if (cnt[i] == a[i])
				continue;
			if (cnt[i] + k <= a[i]) {
				cnt[i] += k;
				res += (i - start) * k;
				k = 0;
				// out.println(i - start + " i - start1");
			} else {
				cnt[i] = a[i];
				res += (i - start) * a[i];
				k -= a[i];
				// out.println(i - start + " i - start2");
			}
			// out.println(i + " " + k + " " + res);
		}
		// out.println(Arrays.toString(cnt));
		prni(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		n = fs.nextInt();
		cnt = new int[n];
		a = fs.readArray(n);
		int q = fs.nextInt();
		while (q-- > 0) {
			int x = fs.nextInt();
			int k = fs.nextInt();
			solve(x, k);
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
		new MissionGotham().run();
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