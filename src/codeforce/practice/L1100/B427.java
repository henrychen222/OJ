/**
 * 02/11/22 moring
 * https://codeforces.com/problemset/problem/427/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B427 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/427/submission/145947819
    // reference: https://codeforces.com/blog/entry/12082
    void solve(int n, int t, int c, int[] a) {
        long res = 0;
        List<Integer> l = new ArrayList<>(Arrays.asList(-1));
        for (int i = 0; i < n; i++) {
            if (a[i] > t) l.add(i);
        }
        l.add(n);
        // tr(l);
        for (int i = 1; i < l.size(); i++) {
            int len = l.get(i) - l.get(i - 1) - 1;
            int ways = len - c + 1;
            res += Math.max(0, ways);
            // tr(l.get(i), l.get(i - 1), len, ways);
        }
        pr(res);
    }

    // TLE https://codeforces.com/problemset/submission/427/145945277
    void solve1(int n, int t, int c, int[] a) {
        long tot = n - c + 1, no = 0;
        Set<Integer> se = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > t) se.add(i);
        }
        for (int i = 0; i < n; i++) {
            int r = i + c - 1;
            if (r < n) {
                // tr(a[i], a[r]);
                boolean find = false;
                for (int idx : se) {
                    if (idx >= i && idx <= r) {
                        find = true;
                        break;
                    }
                }
                if (find) no++;
            }
        }
        // tr(tot, no);
        pr(Math.max(0, tot - no));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), t = fs.nextInt(), c = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, t, c, a);
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
        new B427().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

