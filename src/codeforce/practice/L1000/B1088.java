/**
 * 11/14/21 night
 * https://codeforces.com/problemset/problem/1088/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B1088 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1088/submission/135666703
    // reference: cuiaoxiang
    void solve(int n, int k, int[] a) {
        Arrays.sort(a);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a) pq.add(x);
        int cur = 0;
        while (k-- > 0) {
            while (!pq.isEmpty() && pq.peek() == cur) pq.poll();
            if (pq.isEmpty()) {
                pr(0);
                continue;
            }
            // tr(cur);
            pr(pq.peek() - cur);
            cur = pq.peek();
        }
    }

    // TLE
    void solve1(int n, int k, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        // for (int i = 1; i <= 3; i++) {
        while (k-- > 0) {
            if (m.size() == 0) {
                pr(0);
                continue;
            }
            int min = m.firstKey();
            pr(min);
            TreeMap<Integer, Integer> t = new TreeMap<>();
            for (int x : m.keySet()) {
                int occ = m.get(x);
                if (x - min > 0) {
                    t.put(x - min, occ);
                }
            }
            m = t;
            // tr(m);
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, k, a);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B1088().run();
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
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
