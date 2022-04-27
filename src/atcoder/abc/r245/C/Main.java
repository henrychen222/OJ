/**
 * 03/26/22 morning
 * https://atcoder.jp/contests/abc245/tasks/abc245_c
 */
package atcoder.abc.r245.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc245/submissions/30485685
    // Accepted --- https://atcoder.jp/contests/abc245/submissions/30485941
    // reference: https://atcoder.jp/contests/abc245/submissions/30432156
    void solve(int n, int k, int[] a, int[] b) {
        boolean[][] dp = new boolean[n][2];
        dp[0][0] = dp[0][1] = true;
        for (int i = 1; i < n; i++) {
//            if (Math.abs(a[i] - a[i - 1]) <= k) {
//                if (dp[i][0] || dp[i - 1][0]) dp[i][0] = true;
//            }
//            if (Math.abs(a[i] - b[i - 1]) <= k) {
//                if (dp[i][0] || dp[i - 1][1]) dp[i][0] = true;
//            }
//            if (Math.abs(b[i] - a[i - 1]) <= k) {
//                if (dp[i][1] || dp[i - 1][0]) dp[i][1] = true;
//            }
//            if (Math.abs(b[i] - b[i - 1]) <= k) {
//                if (dp[i][1] || dp[i - 1][1]) dp[i][1] = true;
//            }
            if (Math.abs(a[i] - a[i - 1]) <= k) {
                if (dp[i - 1][0]) dp[i][0] = true;
            }
            if (Math.abs(a[i] - b[i - 1]) <= k) {
                if (dp[i - 1][1]) dp[i][0] = true;
            }
            if (Math.abs(b[i] - a[i - 1]) <= k) {
                if (dp[i - 1][0]) dp[i][1] = true;
            }
            if (Math.abs(b[i] - b[i - 1]) <= k) {
                if (dp[i - 1][1]) dp[i][1] = true;
            }
        }
        // tr(dp);
        if (dp[n - 1][0] || dp[n - 1][1]) {
            pr("Yes");
        } else {
            pr("No");
        }
    }

    ////////////////////////////////////////////////////
    void solve2(int n, int k, int[] a, int[] b) {
        int[] res = new int[n];
        res[0] = a[0];
        dfs(n, 1, k, a, b, res);
        // tr("res1", res);
        if (ok(res)) {
            pr("Yes");
            return;
        }
        res[0] = b[0];
        dfs(n, 1, k, a, b, res);
        // tr("res2", res);
        pr(ok(res) ? "Yes" : "No");
    }

    void dfs(int n, int pos, int k, int[] a, int[] b, int[] res) {
        if (pos >= n) return;
        // tr("aaa", res[pos], pos, res, Math.abs(a[pos] - res[pos - 1]) <= k);
        if (Math.abs(a[pos] - res[pos - 1]) <= k) {
            res[pos] = a[pos];
            dfs(n, pos + 1, k, a, b, res);
        }
        // tr("bbb", pos, res[pos], res, Math.abs(a[pos] - res[pos - 1]) <= k);
        if (Math.abs(b[pos] - res[pos - 1]) <= k) {
            res[pos] = b[pos];
            dfs(n, pos + 1, k, a, b, res);
        }
    }

    boolean ok(int[] a) {
        for (int x : a) {
            if (x == 0) return false;
        }
        return true;
    }

    void solve1(int n, int k, int[] a, int[] b) {
        for (int i = 1; i < n; i++) {
            int d1 = Math.abs(a[i] - a[i - 1]);
            int d2 = Math.abs(a[i] - b[i - 1]);
            int d3 = Math.abs(b[i] - a[i - 1]);
            int d4 = Math.abs(b[i] - b[i - 1]);
            // tr("cur", a[i] + " " + b[i], d1, d2, d3, d4);
            if (d1 > k && d2 > k && d3 > k && d4 > k) {
                pr("No");
                return;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            int ald1 = Math.abs(a[i] - a[i - 1]);
            int ald2 = Math.abs(a[i] - b[i - 1]);
            int ard1 = Math.abs(a[i] - a[i + 1]);
            int ard2 = Math.abs(a[i] - b[i + 1]);
            boolean oka = currentValid(ald1, ald2, ard1, ard2, k);
            // tr(a[i], ald1, ald2, ard1, ard2, oka);

            int bld1 = Math.abs(b[i] - a[i - 1]);
            int bld2 = Math.abs(b[i] - b[i - 1]);
            int brd1 = Math.abs(b[i] - a[i + 1]);
            int brd2 = Math.abs(b[i] - b[i + 1]);
            boolean okb = currentValid(bld1, bld2, brd1, brd2, k);
            // tr(b[i], bld1, bld2, brd1, brd2, okb);
            if (!oka && !okb) {
                pr("No");
                return;
            }
        }
        pr("Yes");
    }

    boolean currentValid(int ld1, int ld2, int rd1, int rd2, int k) {
        if ((ld1 <= k || ld2 <= k) && (rd1 <= k || rd2 <= k)) return true;
        return false;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n);
        solve(n, k, a, b);
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
        new Main().run();
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