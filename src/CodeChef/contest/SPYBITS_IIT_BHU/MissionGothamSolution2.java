// 04/15/21 evening
// reference: https://www.codechef.com/viewsolution/45056746
package CodeChef.contest.SPYBITS_IIT_BHU;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class MissionGothamSolution2 {

	static PrintWriter pw;
	TreeMap<Integer, Integer> tm;
	int n;
	int[] a;
	
	// Accepted --- 0.73sec use PrintWriter
	void solve(int x, int k) {
		// pw.println(Arrays.toString(a));
		long res = 0, val, min = Long.MAX_VALUE;
		while (k > 0) {
			Integer ke = tm.ceilingKey(x);
			if (ke == null)
				break;
			val = tm.get(ke);
			min = Math.min(val, k);
			val -= min;
			k -= min;
			if (val > 0) {
				tm.put(ke, (int) val);
			} else {
				tm.remove(ke);
			}
			res += (ke - x) * min;
		}
		pw.println(res); // difference
	}
	
	// Accepted --- 1.25sec https://www.codechef.com/submit/GOTHAM
	void solve1(int x, int k) {
		// out.println(Arrays.toString(a));
		long res = 0, val, min = Long.MAX_VALUE;
		while (k > 0) {
			Integer ke = tm.ceilingKey(x);
			if (ke == null)
				break;
			val = tm.get(ke);
			min = Math.min(val, k);
			val -= min;
			k -= min;
			if (val > 0) {
				tm.put(ke, (int) val);
			} else {
				tm.remove(ke);
			}
			res += (ke - x) * min;
//			out.println(res + " " + k + " " + val);
//			out.println(tm);
		}
		// prnl(res);
		pw.println(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		n = fs.nextInt();
		a = fs.readArray(n);
		tm = new TreeMap<>();
		for (int i = 0; i < n; i++)
			tm.put(i + 1, a[i]);
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
		pw = new PrintWriter(System.out);
		new MissionGothamSolution2().run();
		pw.close();
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