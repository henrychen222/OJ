// 04/19/21 afternoon

package KickStart.RoundB_2021;

import java.util.*;
import java.io.*;

public class Solution {

	static PrintWriter pw;

	Map<Boolean, Integer> counter (boolean [] a) {
		Map<Boolean, Integer> m = new HashMap<>();
		for (boolean e : a) {
			m.put(e, m.getOrDefault(e, 0) + 1);
		}
		return m;
	}
	
	// Accepted --- uwi
	void solve(long Z) {
		int[] primes = sieveEratosthenes(100000);
		int S = (int) Math.sqrt(Z);
		int inf = Math.max(1, S - 5000);
		int sup = S + 5000;
		pw.println("inf sup" + " " + inf + " " + sup);
		boolean[] ss = sieveBySegment(inf, sup, primes);
		pw.println("ss length" + " " + ss.length);
		
		pw.println(counter(ss));
		long pre = 0;
		for (int i = ss.length - 1; i >= 0; i--) {
			// pw.println("idx: " + i + " " + ss[i]);
			if (ss[i]) {
				// pw.println("111");
				long v = inf + i;
				if (pre != 0 && pre * v <= Z) {
					pw.println(pre * v);
					return;
				}
				pre = v;
			}
		}
	}

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
		pw.println(ret.length);
		int[] isnp = new int[(n + 1) / 32 / 2 + 1];
		int sup = (n + 1) / 32 / 2 + 1;
		pw.println("sup" + " " + sup);
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

		// 3,5,7
		// 2x+3=n
		int[] magic = { 0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17,
				9, 6, 16, 5, 15, 14 };
		int h = n / 2;
		for (int i = 0; i < sup; i++) {
			for (int j = ~isnp[i]; j != 0; j &= j - 1) {
				int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
				pw.println("pp" + " " + pp + " " + (0x076be629 >>> 27));
				int p = 2 * pp + 3;
				if (p > n)
					break;
				pw.println("p" + " " + p);
				ret[pos++] = p;
				if ((long) p * p > n)
					continue;
				pw.println("p go" + " " + p);
				for (int q = (p * p - 3) / 2; q <= h; q += p)
					isnp[q >> 5] |= 1 << q;
			}
		}
		pw.println(Arrays.toString(ret) + " " + pos);
		return Arrays.copyOf(ret, pos);
	}

	boolean[] sieveBySegment(long low, long high, int[] primes) {
		int m = (int) (high - low + 1);
		boolean[] isp = new boolean[m];
		Arrays.fill(isp, true);
		if (low == 1)
			isp[0] = false;
		for (int p : primes) {
			if ((long) p * p > high)
				break;
			long sp = (-low) % p;
			if (sp < 0)
				sp += p;
			if (sp + low <= (long) p * p)
				sp = (long) p * p - low;
			pw.println(sp + " " + p + " " + counter(isp));
			int cnt = 0;
			for (int u = (int) sp; u < m; u += p) {
				// pw.println("u" + " " + u);
				cnt ++;
				isp[u] = false;
			}
			pw.println("cnt: " + cnt);
		}
		pw.println("m: " + m);
		return isp;
	}

	void test() {
//		pw.println(counter(sieveBySegment(1, 10, sieveEratosthenes(10))));
//		pw.println(counter(sieveBySegment(1, 5044, sieveEratosthenes(10))));
		// pw.println(counter(sieveBySegment(1, 5044, sieveEratosthenes(100))));
//		pw.println(counter(sieveBySegment(1, 5044, sieveEratosthenes(1000))));
//		pw.println(counter(sieveBySegment(1, 5044, sieveEratosthenes(10000))));
//		pw.println(counter(sieveBySegment(1, 5044, sieveEratosthenes(100000))));
		
		pw.println(Arrays.toString(sieveEratosthenes(40)));
		// pw.println(Arrays.toString(sieveEratosthenes(50)));
        // pw.println(Arrays.toString(sieveEratosthenes(100)));
//    	pw.println(sieveEratosthenes(100000)[sieveEratosthenes(100000).length - 1]);
	}

	private void run() {
		test();
//		read_write_file(); // comment this before submission
//		FastScanner fs = new FastScanner();
//		int t = fs.nextInt();
//		for (int cas = 1; cas <= t; cas++) {
//			long num = fs.nextLong();
//		    // pw.print("Case #" + cas + ": ");
//			solve(num);
//		}
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
		new Solution().run();
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
}
