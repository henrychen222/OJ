/**
 * 05/06/22 evening
 * https://codeforces.com/contest/1670/problem/F
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1670/submission/156147440
// reference: um_nik
public class F {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;
    int bit = 62, N = 1005;
    long[][] cnt;
    long[][] dp;

    long solve(int n, long r, long z) {
        for (int i = 0; i < bit; i++) {
            for (int j = 0; j <= n; j++) dp[i][j] = 0;
        }
        dp[bit - 1][0] = 1;
        for (int k = bit - 2; k >= 0; k--) {
            int c = (int) ((z >> k) & 1);
            for (int x = 0; x <= n; x++) {
                if (dp[k + 1][x] == 0) continue;
                long y = 2L * x + ((r >> k) & 1);
                // tr(c, y);
                for (int t = c; t <= y && t <= n; t += 2) {
                    long mul = multi_mod(dp[k + 1][x], cnt[n][t]);
                    dp[k][(int) Math.min(n, y - t)] = add_mod(dp[k][(int) Math.min(n, y - t)], mul);
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= n; i++) res = add_mod(res, dp[0][i]);
        // tr("res", res);
        return res;
    }

    void prepare() {
        cnt = new long[N][N];
        dp = new long[bit][N];
        for (int i = 0; i < N; i++) cnt[i][0] = cnt[i][i] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < i; j++) {
                cnt[i][j] = add_mod(cnt[i - 1][j - 1], cnt[i - 1][j]);
            }
        }
    }

    long add_mod(long x, long y) {
        x += y;
        if (x >= mod) x -= mod;
        return x;
    }

    long minus_mod(long x, long y) {
        x += mod - y;
        if (x >= mod) x -= mod;
        return x;
    }

    long multi_mod(long x, long y) {
        return x * y % mod;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        prepare();
        int n = fs.nextInt();
        long l = fs.nextLong(), r = fs.nextLong(), z = fs.nextLong();
        long res1 = solve(n, r, z), res2 = solve(n, l - 1, z);
        long res = minus_mod(res1, res2);
        pr(res);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}