/**
 * 03/04/21 night
 * https://www.codechef.com/MARCH21C/problems/GROUPS
 */

package CodeChef.contest.MarchChallenge2021;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class Groups {

	// TLE
//	void solve(String s) {
//		int n = s.length();
//		int res = 0;
//		outer: for (int i = 0; i < n;) {
//			if (s.charAt(i) == '1') {
//				res++;
//				for (int j = i + 1; j < n; j++) {
//					if (s.charAt(j) == '0') {
//						i = j;
//						continue outer;
//					}
//				}
//			}
//			i++;
//		}
//		prni(res);
//	}

	// RE
//	void solve(String s) {
//		int n = s.length();
//		int res = 0;
//		for (int i = 0; i < n; i++) {
//			if (i == 0) {
//				if (s.charAt(i) == '1') {
//					if (s.charAt(i + 1) != '1')
//						res++;
//				}
//			} else if (i == n - 1) {
//				if (s.charAt(i) == '1') {
//					if (s.charAt(i - 1) != '1')
//						res++;
//				}
//			} else {
//				if (s.charAt(i) == '1') {
//					if (s.charAt(i - 1) != '1' && s.charAt(i + 1) != '1')
//						res++;
//				}
//			}
//		}
//		prni(res);
//	}

	// Accepted 0.34sec
	void solve(String s) {
		int n = s.length();
		String[] a = s.split("0");
		// pras(a);
		int res = 0;
		for (String e : a) {
			if (e.length() != 0) res++;
		}
		prni(res);
	}

	private void run() {
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			String s = fs.next();
			solve(s);
		}
	}

	public static void main(String[] args) {
		new Groups().run();
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