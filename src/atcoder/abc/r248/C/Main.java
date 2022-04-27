/**
 * 04/16/22 morning
 * https://atcoder.jp/contests/abc248/tasks/abc248_c
 */
package atcoder.abc.r248.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    private final int mod = 998244353;

    /**
     * reference:
     * https://atcoder.jp/contests/abc248/submissions/31007637
     * https://atcoder.jp/contests/abc248/submissions/31005687
     * Accepted --- https://atcoder.jp/contests/abc248/submissions/31045378
     */
    void solve(int n, int m, int k) {
        int[][] dp = new int[51][n * m + 50];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * m; j++) {
                for (int x = 1; x <= m; x++) {
                    dp[i + 1][j + x] += dp[i][j];
                    dp[i + 1][j + x] %= mod;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < k + 1; i++) res += dp[n][i];
        pr(res % mod);
    }

    //////////////////////////////////////////////////
    /*
     1 2 3 .... 31
     1 2 3 .... 30 32
     */
    // WA don't know
    void solve1(int n, int m, int k) {
        // tr(factorial(5, 5));
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        long res = 1, f = factorial(n, n);
        for (int x = 1; x <= m; x++) {
            for (int i = 0; i < n; i++) {
                int pre = a[i], cnt = 0;
                a[i] = x;
                if (ok(a, k)) {
                    cnt++;
                }
                // tr(a, ok(a, k), cnt);
                res = (res + cnt) % mod;
                // res = res * f % mod;
                a[i] = pre;
            }
            // tr(x, res);
        }
        pr(res % mod);
    }

    long factorial(int m, int n) { // example: A(5, 3) = 5 * 4 * 3 = 60
        long res = 1;
        for (int i = m, cnt = 0; i > 0 && cnt < n; i--, cnt++) res *= i;
        return res;
    }

    boolean ok(int[] a, int k) {
        long sum = 0;
        for (int x : a) sum += x;
        return sum <= k;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(3);
        solve(a[0], a[1], a[2]);
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