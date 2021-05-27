// 04/15/21 afternoon

package CodeChef.contest.SPYBITS_IIT_BHU;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class MissionGothamSolution {

	TreeSet<Integer> cnt;
	int n;
	int[] a;

	// issue https://www.codechef.com/viewsolution/45054303
	// WA
	void solve(int x, int k) {
		long res = 0;
		x--;
		// out.println("x " + x + " " + lower_bound(cnt, x));
		for (int i = lower_bound(cnt, x); i != cnt.size() && k > 0;) {
//			out.println(cnt);
//			out.println(i);
			int c = Math.min(a[i], k);
			res += c * (i - x);
			k -= c;
			a[i] -= c;
			int next = lower_bound(cnt, i);
			cnt.remove(i);
			i = next;
			// out.println("res: " + res + " " + i);
			if (i == cnt.last()) break;
		}
		prnl(res);
	}

	public int lower_bound(TreeSet<Integer> se, int t) {
		int res = -1;
		if (se.contains(t)) {
			res = t;
		} else {
			if (se.higher(t) == null) {
				return se.last();
			}
			res = se.higher(t);
		}
		return res;
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		n = fs.nextInt();
		a = fs.readArray(n);
		cnt = new TreeSet<>();
		for (int i = 0; i < n; i++)
			cnt.add(i);
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
		new MissionGothamSolution().run();
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