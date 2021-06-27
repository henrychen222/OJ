/**
 * 05/31/21 morning
 * https://www.codechef.com/LTIME96C/problems/TANDJ1
 * 
 * reference:
 * https://www.codechef.com/viewsolution/47214060 (use)
 * https://www.codechef.com/viewsolution/47165292
 */

package CodeChef.contest.LTIME.MayLunchtime2021_96;

import java.util.*;
import java.io.*;

class TotalComponents {

	static PrintWriter pw;

	int MAX = 10000000;
	boolean[] p = new boolean[MAX + 1];
	int[] dp = new int[MAX + 1];

	void solve(int n) {
		prni(dp[n] - dp[n / 2] + 1);
	}

	void makePrimeArray(int n) {
		Arrays.fill(p, true);
		p[1] = false;
		for (int i = 2; i <= n; i++) {
			if (p[i]) {
				for (int j = 2; j * i <= n; j++) {
					p[i * j] = false;
				}
			}
		}
	}

	// WA
//	void solve1(int n) {
//		int[] prime = sieveEratosthenes(n);
//		HashSet<Integer> ps = new HashSet<>();
//		for (int i = 1; i < prime.length; i++) {
//			ps.add(prime[i]);
//		}
//		// tr(ps);
//		int[] group = new int[n + 5];
//		for (int x = 2; x <= n; x += 2) {
//			group[x] = 2;
//		}
//		// tr("intial prime", ps);
//		for (int x : prime) {
//			for (int i = 2; i * x <= n; i++) {
//				if (group[x] == 0)
//					group[x] = i;
//				if (group[i * x] == 0)
//					group[i * x] = i;
//				ps.remove(x);
//				ps.remove(i * x);
//			}
//		}
//		// tr("rest prime", ps);
//		for (int e : ps) {
//			group[e] = e;
//		}
//		HashSet<Integer> se = new HashSet<>();
//		for (int i = 2; i <= n; i++) {
//			if (group[i] != 0) {
//				se.add(group[i]);
//			}
//		}
//		// tr(group);
//		prni(se.size());
//	}

	int[] sieveEratosthenes(int n) {
		if (n <= 32) {
			int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
			for (int i = 0; i < primes.length; i++) {
				if (n < primes[i]) {
					return Arrays.copyOf(primes, i);
				}
			}
			return primes;
		}
		int u = n + 32;
		double lu = Math.log(u);
		int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
		ret[0] = 2;
		int pos = 1;
		int[] isnp = new int[(n + 1) / 32 / 2 + 1];
		int sup = (n + 1) / 32 / 2 + 1;
		int[] tprimes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		for (int tp : tprimes) {
			ret[pos++] = tp;
			int[] ptn = new int[tp];
			for (int i = (tp - 3) / 2; i < tp << 5; i += tp)
				ptn[i >> 5] |= 1 << (i & 31);
			for (int j = 0; j < sup; j += tp) {
				for (int i = 0; i < tp && i + j < sup; i++) {
					isnp[j + i] |= ptn[i];
				}
			}
		}
		int[] magic = { 0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17,
				9, 6, 16, 5, 15, 14 };
		int h = n / 2;
		for (int i = 0; i < sup; i++) {
			for (int j = ~isnp[i]; j != 0; j &= j - 1) {
				int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
				int p = 2 * pp + 3;
				if (p > n)
					break;
				ret[pos++] = p;
				if ((long) p * p > n)
					continue;
				for (int q = (p * p - 3) / 2; q <= h; q += p)
					isnp[q >> 5] |= 1 << q;
			}
		}
		return Arrays.copyOf(ret, pos);
	}

	// Accepted --- 0.77sec
	int[] pa;
	HashSet<Integer> pse;

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		pa = sieveEratosthenes(MAX);
		pse = new HashSet<>();
		for (int p : pa) {
			pse.add(p);
		}
		dp[1] = 1;
		dp[2] = 1;
		for (int x = 3; x <= MAX; x++) {
			if (pse.contains(x)) {
				dp[x] = dp[x - 1] + 1;
			} else {
				dp[x] = dp[x - 1];
			}
		}
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			solve(n);
		}
	}

	// Accepted --- 0.45sec
	private void run2() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		makePrimeArray(MAX);
		dp[1] = 1;
		dp[2] = 1;
		for (int x = 3; x <= MAX; x++) {
			if (p[x]) {
				dp[x] = dp[x - 1] + 1;
			} else {
				dp[x] = dp[x - 1];
			}
		}
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			solve(n);
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
		new TotalComponents().run();
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

	void tr(Object... o) {
		pw.println(Arrays.deepToString(o));
	}
}
