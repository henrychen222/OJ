package CodeForce.Template;

import java.util.*;
import java.io.*;

public class N_S {

	static PrintWriter pw;

	void solve(int n, String s) {
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			String s = fs.next();
			solve(n, s);
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
		new N_S().run();
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

	void trace(int x) {
		pw.println(x);
	}

	void trace(long x) {
		pw.println(x);
	}

	void trace(char c) {
		pw.println(c);
	}

	void trace(String s) {
		pw.println(s);
	}

	void trace(int[] a) {
		pw.println(Arrays.toString(a));
	}

	void trace(long[] a) {
		pw.println(Arrays.toString(a));
	}

	void trace(int[][] a) {
		pw.println(Arrays.deepToString(a));
	}

	void trace(long[][] a) {
		pw.println(Arrays.deepToString(a));
	}

	////////////////////////////////////////////
	void trace(String hint, int x) {
		pw.println(hint + " " + x);
	}

	void trace(String hint, long x) {
		pw.println(hint + " " + x);
	}

	void trace(String hint, char c) {
		pw.println(hint + " " + c);
	}

	void trace(String hint, String s) {
		pw.println(hint + " " + s);
	}

	void trace(String hint, int[] a) {
		pw.println(hint + " " + Arrays.toString(a));
	}

	void trace(String hint, long[] a) {
		pw.println(hint + " " + Arrays.toString(a));
	}

	void trace(String hint, int[][] a) {
		pw.println(hint + " " + Arrays.deepToString(a));
	}

	void trace(String hint, long[][] a) {
		pw.println(hint + " " + Arrays.deepToString(a));
	}
}