/**
 * 03/04/21 night
 * https://www.codechef.com/MARCH21C/problems/IRSTXOR
 */

/*
   4
   13
   10
   16
   1000000000
 */
package CodeChef.contest.LONG.MarchChallenge2021;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class InterestingXOR {

	// TLE SubTask 1 Accepted (30/100) 0.45sec
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		// prnl(d);
//		if (Math.pow(2, d) == c)
//			d++;
//		long max = (long) Math.pow(2, d);
//		// prnl(max);
//		long res = 0;
//		for (long a = 0; a <= max; a++) {
//			for (long b = 0; b <= max; b++) {
//				if ((a ^ b) == c) {
//					// System.out.println(a + " " + b);
//					res = Math.max(res, a * b);
//				}
//			}
//		}
//		prnl(res);
//	}

	// TLE
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		if (Math.pow(2, d) == c)
//			d++;
//		long max = (long) Math.pow(2, d);
//		long res = 0;
//		Map<Long, Long> memo = new HashMap<>();
//		for (long a = 0; a <= max; a++) {
//			for (long b = 0; b <= max; b++) {
//				if (a <= b) {
//					if (memo.containsKey(a) && memo.get(a) == b) continue;
//					if ((a ^ b) == c) {
//						res = Math.max(res, a * b);
//						memo.put(a, b);
//					}
//				} else {
//					if (memo.containsKey(b) && memo.get(b) == a) continue;
//					if ((a ^ b) == c) {
//						res = Math.max(res, a * b);
//						memo.put(b, a);
//					}
//				}
//				
//			}
//		}
//		prnl(res);
//	}

	// TLE
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		if (Math.pow(2, d) == c)
//			d++;
//		long max = (long) Math.pow(2, d);
//		long res = 0;
//		Set<String> memo = new HashSet<>();
//		for (long a = 0; a <= max; a++) {
//			for (long b = 0; b <= max; b++) {
//				if (a <= b) {
////					System.out.println(a + " " + b);
//					if (memo.contains(a + " " + b)) continue;
//					if ((a ^ b) == c) {
//						res = Math.max(res, a * b);
//						memo.add(a + " " + b);
//					}
//				} else {
////					System.out.println(b + " " + a);
//					if (memo.contains(b + " " + a)) continue;
//					if ((a ^ b) == c) {
//						res = Math.max(res, a * b);
//						memo.add(b + " " + a);
//					}
//				}
//				
//			}
//		}
//		prnl(res);
//	}

//	// TLE SubTask 1 Accepted (30/100) 0.18sec
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		// prnl(d);
//		if (Math.pow(2, d) == c)
//			d++;
//		long max = (long) Math.pow(2, d);
//		// prnl(max);
//		long res = 0;
//		long mid = 0;
//		if (max % 2 == 0) {
//			mid = max / 2;
//		} else {
//			mid = max / 2 + 1;
//		}
//		for (long a = 0; a <= mid; a++) {
//			for (long b = max; b >= mid; b--) {
//				if ((a ^ b) == c) {
//					res = Math.max(res, a * b);
//				}
//			}
//		}
//		prnl(res);
//	}

	// ***********************030521 night*****************************************
	// //
//	// TLE SubTask 1 (0.08sec) + SubTask 2.3 (0.46sec) AC
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		if (Math.pow(2, d) == c) d++;
//		long max = (long) Math.pow(2, d);
//		long res = 0;
//		for (long a = 0; a <= max; a++) {
//			long b = c ^ a;
//			if (b >= 0 && b <= max) {
//				res = Math.max(res, a * b);
//			}
//		}
//		prnl(res);
//	}

	// TLE SubTask 1 (0.08sec) + SubTask 2.3 (0.36sec) AC
//	void solve(long c) {
//		long d = (long) Math.ceil((Math.log10(c) / Math.log10(2)));
//		if (Math.pow(2, d) == c) d++;
//		long max = (long) Math.pow(2, d);
//		long res = 0;
//		long mid = 0;
//		if (max % 2 == 0) {
//			mid = max / 2;
//		} else {
//			mid = max / 2 + 1;
//		}
//		for (long a = 0; a <= mid; a++) {
//			long b = c ^ a;
//			if (b >= mid && b <= max) {
//				res = Math.max(res, a * b);
//			}
//		}
//		prnl(res);
//	}
	
	 // TLE SubTask 1 (0.08sec) + SubTask 2.3 (0.40sec) AC
//	void solve(long c) {
//		long d = 0;
//		for (long i = 0; i < c; i++) {
//			long tmp = 1 << i;
//			if (tmp == c) {
//				d = i + 1;
//				break;
//			} else if (tmp > c){
//				d = i;
//				break;
//			}
//		}
//		long max = 1 << d;
//		long res = 0;
//		long mid = 0;
//		if (max % 2 == 0) {
//			mid = max / 2;
//		} else {
//			mid = max / 2 + 1;
//		}
//		for (long a = 0; a <= mid; a++) {
//			long b = c ^ a;
//			if (b >= mid && b <= max) {
//				long p = a * b;
//				if (p > res) res = p;
//			}
//		}
//		prnl(res);
//	}
	
	 // TLE SubTask 1 (0.07sec) + SubTask 2.3 (0.38sec) AC
	void solve(long c) {
		long d = (long)(Math.log10(c) / Math.log10(2) + 1);
		long tmp = 1 << d;
		if (tmp == c) d++;
		long max = 1 << d;
		long res = 0;
		long mid = 0;
		if (max % 2 == 0) {
			mid = max / 2;
		} else {
			mid = max / 2 + 1;
		}
		for (long a = 0; a <= mid; a++) {
			long b = c ^ a;
			if (b >= mid && b <= max) {
				long p = a * b;
				if (p > res) res = p;
			}
		}
		prnl(res);
	}
	
	private void run() {
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			long c = fs.nextLong();
			solve(c);
		}
	}

	public static void main(String[] args) {
		new InterestingXOR().run();
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

	void prai(int[] a) {
		out.println(Arrays.toString(a));
	}

	void pral(long[] a) {
		out.println(Arrays.toString(a));
	}

	void prad(double[] a) {
		out.println(Arrays.toString(a));
	}

	void pras(String[] a) {
		out.println(Arrays.toString(a));
	}

	void prac(char[] a) {
		out.println(Arrays.toString(a));
	}

	void prdai(int[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdal(long[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdad(double[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdas(String[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdac(char[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prli(List<Integer> l) {
		out.println(l);
	}

	void prll(List<Long> l) {
		out.println(l);
	}

	void prld(List<Double> l) {
		out.println(l);
	}

	void prls(List<String> l) {
		out.println(l);
	}

	void prlc(List<Character> l) {
		out.println(l);
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