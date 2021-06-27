/**
 * 06/20/21 noon
 * https://www.codechef.com/COOK130C/problems/WAV2
 */

package CodeChef.contest.COOK.JuneCookOff2021_130;

import java.util.*;
import java.io.*;

// Accepted --- 0.45sec
class TheWave {

	static PrintWriter pw;
//	Set<Integer> zero = new HashSet<>();
//	Map<Integer, String> memo = new HashMap<>();

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int q = fs.nextInt();
		int[] a = fs.readArray(n);
		Arrays.sort(a);
		// tr(a);
		for (int i = 0; i < q; i++) {
			int x = fs.nextInt();
//			if (zero.contains(x)) {
//				pr(0);
//				continue;
//			}
//			if (memo.containsKey(x)) {
//				pr(memo.get(x));
//				continue;
//			}
			int idx = Arrays.binarySearch(a, x);
			// tr(x, idx);
			if (idx >= 0) {
				// zero.add(x);
				pr(0);
			} else {
				int neg = n - (-idx) + 1;
				// tr(neg);
				String res = neg % 2 == 1 ? "NEGATIVE" : "POSITIVE";
				// memo.put(idx, res);
				pr(res);
			}
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
		new TheWave().run();
		pw.close();
	}

	void pr(int num) {
		pw.println(num);
	}

	void pr(long num) {
		pw.println(num);
	}

	void pr(double num) {
		pw.println(num);
	}

	void pr(String s) {
		pw.println(s);
	}

	void pr(char c) {
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