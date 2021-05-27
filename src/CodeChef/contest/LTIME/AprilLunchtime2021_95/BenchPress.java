/**
 * 04/30/21 morning
 * https://www.codechef.com/LTIME95C/problems/BENCHP
 */

package CodeChef.contest.LTIME.AprilLunchtime2021_95;

import java.util.*;
import java.io.*;

class BenchPress {

	static PrintWriter pw;

	// tourist: https://www.codechef.com/viewsolution/45649837
	// Accepted --- 0.52sec
	void solve(int n, int w, int wr, int[] a) {
		long res = wr;
		TreeSet<Integer> ts = new TreeSet<>();
		for (int e : a) {
			if (ts.contains(e)) {
				res += 2 * e;
				ts.remove(e);
			} else {
				ts.add(e);
			}
			// pw.println(res + " " + ts);
		}
		prs(res >= w ? "YES" : "NO");
	}

	// don't know
	void solve1(int n, int w, int wr, int[] a) {
		if (w <= wr) {
			prs("YES");
			return;
		}
		int rest = w - wr;
		pw.println(rest);
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		for (int e : a) {
			if (e > rest)
				continue;
			tm.put(e, tm.getOrDefault(e, 0) + 1);
		}
		pw.println(tm);
		Set<Integer> ke = tm.keySet();
		List<long[]> d = new ArrayList<>();
		for (int k : ke) {
			int occ = tm.get(k);
			for (int i = 1; i * k <= rest; i++) {
				d.add(new long[] { 1L * k, 1L * k * i });
			}
		}
		pw.println(d);
		Collections.sort(d, (x, y) -> (int) x[0] - (int) y[0]);
		TreeMap<Long, HashSet<String>> res = new TreeMap<>(Collections.reverseOrder());
		int half = rest / 2;
		int dn = d.size();
		for (int i = 0; i < dn; i++) {
			long ti = d.get(i)[1];
			long baseI = d.get(i)[0];
			int iocc = (int) (ti / baseI);
			for (int j = i + 1; j < dn; j++) {
				String tmp = i + " " + j;
				long tj = d.get(j)[1];
				long baseJ = d.get(j)[0];
				int jocc = (int) (tj / baseJ);
				long sum = ti + tj;
				if (sum >= half && iocc < tm.get((int) baseI) && jocc < tm.get((int) baseJ)) {
					if (baseI == baseJ) {
						pw.println(baseI + " " + baseJ + " " + iocc + " " + jocc);
						if (iocc + jocc > tm.get((int) baseI))
							continue;
					}
					if (!res.containsKey(sum)) {
						res.put(sum, new HashSet<String>());
					}
					res.get(sum).add(tmp);
				}
			}
		}
		pw.println(res);
		for (HashSet<String> e : res.values()) {
			if (e.size() >= 2) {
				prs("YES");
				return;
			}
		}
		prs("NO");
	}

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int w = fs.nextInt();
			int wr = fs.nextInt();
			int[] a = fs.readArray(n);
			solve(n, w, wr, a);
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
		new BenchPress().run();
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