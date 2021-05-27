/**
 * 05/23/21 noon
 * https://www.codechef.com/COOK129C/problems/TLAPM
 */

package CodeChef.contest.COOK.MayCookOff2021_129;

import java.util.*;
import java.io.*;

class LastProblem {

	static PrintWriter pw;

	// Accepted --- 0.06sec
	// reference: https://www.codechef.com/viewsolution/46799654
	void solve(int x1, int y1, int x2, int y2) {
		long res = 0;
		long d2 = x1 + y1, v = 1, t1 = 1, t2 = y1 + 1, d1 = x2 + y1 - 1;
		// pw.println(res + " " + d2 + " " + v + " " + t1 + " " + t2 + " " + d1);
		for (int i = 1; i < y1; i++) {
			v += t1;
			t1++;
		}
		// pw.println(res + " " + d2 + " " + v + " " + t1 + " " + t2 + " " + d1);
		for (int i = 1; i < x1; i++) {
			v += t2;
			t2++;
		}
		// pw.println(res + " " + d2 + " " + v + " " + t1 + " " + t2 + " " + d1);
		for (int i = x1; i < x2; i++) {
			res += v;
			v += d2;
			d2++;
		}
		// pw.println(res + " " + d2 + " " + v + " " + t1 + " " + t2 + " " + d1);
		for (int i = y1; i <= y2; i++) {
			res += v;
			v += d1;
			d1++;
		}
		// pw.println(res + " " + d2 + " " + v + " " + t1 + " " + t2 + " " + d1);
		prnl(res);
	}

	int N = 1000;
	int[][] g = new int[N][N];

	void makeGrid() {
		int delta = 1;
		int start = 1;
		for (int i = 1; i < N; i++) {
			int t = delta;
			g[i - 1][0] = start;
			for (int j = 2; j < N; j++) {
				g[i - 1][j - 1] = t + g[i - 1][j - 2];
				t += 1;
			}
			delta++;
			start += delta;
		}
	}

//	void makeGrid1() {
//		int tot = N * N;
//		for (int y = 0; y < N; y++)
//			for (int x = 0; x < N; x++)
//				g[y][x] = (x + y < N) ? ((x + y + 1) * (x + y) / 2 + y + 1)
//						: (N * N + 1 - (N - y) - (2 * N - x - y - 1) * (2 * N - x - y - 2) / 2);
//
//		// pw.println(Arrays.deepToString(g));
//	}

	// https://www.codechef.com/viewsolution/46796453 
	// TLE in java, C++ just 0.5sec
	void solve2(int x1, int y1, int x2, int y2) {
		long[][] f = new long[1001][1001];
		for (int i = x1 - 1; i < x2; i++) {
			for (int j = y1 - 1; j < y2; j++) {
				f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]) + g[i][j];
				pw.println(f[i + 1][j + 1] + " " + g[i + 1][j + 1]);
			}
		}
		prnl(f[x2][y2]);
	}

	// WA
	void solve1(int x1, int y1, int x2, int y2) {
		int i = x1 - 1;
		int j = y1 - 1;
		long res = g[i][j];
		while (true) {
			if (i + 1 < x2) {
				if (j + 1 < y2) {
					int down = g[i + 1][j];
					int right = g[i][j + 1];
					if (down > right) {
						res += down;
						i++;
					} else if (down < right) {
						res += right;
						j++;
					} else {
						// may did dfs here
//						int plus = 2;
//						while (i + plus < x2 && j + plus < y2 && g[i + plus][j] == g[i][j + plus]) {
//							plus++;
//						}
//						if (i + plus >= x2) {
//							res += right;
//							j++;
//						} else if (j + plus >= y2) {
//							res += down;
//							i++;
//						} else if (i + plus < x2 && j + plus < y2) {
//							if (g[i + plus][j] > g[i][j + plus]) {
//								res += down;
//								i++;
//							} else {
//								res += right;
//								j++;
//							}
//						}
					}
				} else {
					int down = g[i + 1][j];
					res += down;
					i++;
				}
			} else {
				if (j + 1 < y2) {
					int right = g[i][j + 1];
					res += right;
					j++;
				} else {
					break;
				}
			}
		}
		prnl(res);
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		// makeGrid();
		while (t-- > 0) {
			int x1 = fs.nextInt();
			int y1 = fs.nextInt();
			int x2 = fs.nextInt();
			int y2 = fs.nextInt();
			solve(x1, y1, x2, y2);
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
		new LastProblem().run();
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