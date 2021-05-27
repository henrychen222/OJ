/**
 * 04/18/21 noon
 * https://www.codechef.com/COOK128B/problems/CM164364
 */

package CodeChef.contest.COOK.AprilCookOff2021_128;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class ChocolateMonger {
    
	static PrintWriter pw;
	
	public static Map<Integer, Integer> sortMapByValues(Map<Integer, Integer> map) {
		List<Entry<Integer, Integer>> data = new ArrayList<>(map.entrySet());
		Collections.sort(data, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Map<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
		for (Iterator<Entry<Integer, Integer>> it = data.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	
	// Accepted --- 0.49sec
	void solve(int n, int x, int[] a) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int e : a) {
			m.put(e, m.getOrDefault(e, 0) + 1);
		}
		m = sortMapByValues(m);
		// pw.println(m);
		int remove = 0;
		for (int k: m.keySet()) {
			int v = m.get(k);
			if (x > 0) {
				x -= v - 1;
				remove += v - 1;
				m.put(k, 1);
			} else {
				break;
			}
		}
//		pw.println(m);
//		pw.println(x + " " + remove);
		if (x <= 0) {
			pw.println(m.size());
			return;
		}
		pw.println(m.size() - x);
	}
	

	private void run() {
		read_write_file(); // comment this before submission
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int x = fs.nextInt();
			int[] a = fs.readArray(n);
			solve(n, x, a);
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
		new ChocolateMonger().run();
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