/**
 * 04/30/21 morning
 * https://www.codechef.com/LTIME95C/problems/ARRROT
 */

package CodeChef.contest.LTIME.AprilLunchtime2021_95;

import java.util.*;
import java.io.*;

class ArrayRotation {

	static PrintWriter pw;

	final int MOD = (int) (1e9 + 7);
	
	// tourist https://www.codechef.com/viewsolution/45648052
	// Accepted --- 0.36sec
	void solve(int n, List<Integer> a, int qn, int[] q) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a.get(i);
		}
		// pw.println(sum);
		sum = (sum % MOD + MOD) % MOD;
		// pw.println(sum);
		for (int i = 0; i < qn; i++) {
			sum = 2 * sum % MOD;
			pw.println(sum);
		}
	}
	
	// TLE
	void solve1(int n, List<Integer> a, int qn, int[] q) {
//		pw.println(n + " " + a);
//		pw.println(qn + " " + Arrays.toString(q));
		List<Integer> cur = a;
		for (int x : q) {
			if (x >= 0) {
				cur = rlx(x, cur);
				// pw.print(cur);
				sum(cur);
			} else {
				cur = llx(x, cur);
				// pw.print(cur);
				sum(cur);
			}
		}
	}

	void sum (List<Integer> cur) {
		int n = cur.size();
		long res = 0;
		for (int i = 0; i < n; i++) {
			res += cur.get(i);
		}
		prnl(res);
	}
	
	List<Integer> rlx(int x, List<Integer> list) { // last to begin
		int n = list.size();
		int t = x % n;
		List<Integer> c = list;
		while (t-- > 0) {
			int last = list.get(n - 1);
			c.add(0, last);
//			pw.println(c);
			c.remove(n);
//			pw.println(c);
		}
//		pw.println(c);
		list.addAll(c);
		return list;
	}

	List<Integer> llx(int x, List<Integer> list) { // begin to last
		int n = list.size();
		int t = x % n;
		List<Integer> c = list;
		while (t-- > 0) {
			int begin = list.get(0);
			c.add(begin);
			c.remove(0);
		}
		list.addAll(c);
		return list;
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		List<Integer> a = fs.readIntegerList(n);
		int qn = fs.nextInt();
		int[] q = fs.readArray(qn);
		solve(n, a, qn, q);
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
		new ArrayRotation().run();
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

		List<Integer> readIntegerList(int n) {
			List<Integer> a = new ArrayList<>();
			for (int i = 0; i < n; i++)
				a.add(nextInt());
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