/**
 * 09/06/21 night fix
 * https://codeforces.com/contest/1527/problem/E
 */
package codeforce.cf.div2.r721;

import java.util.*;
import java.io.*;

public class F {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1527/submission/128109085 2932ms
    void solve(int n, int k, int[] a) {
        int[] pre = new int[n + 1];
        Arrays.fill(pre, -1);
        int[] p = new int[n + 1];
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = pre[a[i]];
            pre[a[i]] = i;
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = 1L << 60;
        }
        for (int i = 1; i <= k; i++) {
            SegmentTreeRSQ st = new SegmentTreeRSQ(1 << 16);
            for (int j = 0; j < n; j++) st.update(j, j + 1, dp[i - 1][j], 0, n, 1);
            for (int j = 0; j < n; j++) {
                if (p[j] >= 0) st.update(0, p[j] + 1, j - p[j], 0, n, 1);
                // tr("value", st.query(0, j + 1, 0, n, 1));
                dp[i][j + 1] = st.query(0, j + 1, 0, n, 1);
            }
        }
        pr(dp[k][n]);
    }

    class SegmentTreeRSQ {
        long[] tree;
        long[] ma;

        SegmentTreeRSQ(int n) {
            tree = new long[2 * n];
            ma = new long[2 * n];
        }

        long query(int l, int r, int tl, int tr, int vi) {
            if (l >= tr || r <= tl) return 1L << 60;
            // if (l >= tr || r <= tl) return Long.MAX_VALUE; // Accepted --- 2869ms https://codeforces.com/contest/1527/submission/128109701
            if (l <= tl && r >= tr) return ma[vi];
            return tree[vi] + Math.min(query(l, r, tl, (tl + tr) / 2, vi * 2), query(l, r, (tl + tr) / 2, tr, vi * 2 + 1));
        }

        void update(int l, int r, long v, int tl, int tr, int vi) {
            if (tl >= tr) return;
            if (l <= tl && tr <= r) {
                tree[vi] += v;
                ma[vi] += v;
            } else if (tl < r && l < tr) {
                update(l, r, v, tl, (tl + tr) / 2, vi * 2);
                update(l, r, v, (tl + tr) / 2, tr, vi * 2 + 1);
                ma[vi] = tree[vi] + Math.min(ma[vi * 2], ma[vi * 2 + 1]);
            }
        }
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int k = fs.nextInt();
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

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new F().run();
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