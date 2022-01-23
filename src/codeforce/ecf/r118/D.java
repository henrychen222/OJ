/**
 * 12/1/21 noon
 * https://codeforces.com/contest/1613/problem/D
 */
package codeforce.ecf.r118;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;
    private final int mod = 998244353;

    // Accepted --- https://codeforces.com/contest/1613/submission/137722953
    void solve(int n, int[] A) {
        long[] a = new long[n + 2], b = new long[n + 2];
        long ans = 0;
        for (int x : A) {
            if (x == 0) {
                ans = add(ans, a[0] + b[x + 1] + 1);
                a[0] = add(a[0], a[0] + 1);
                b[x + 1] = add(b[x + 1], b[x + 1]);
            } else if (x == 1) {
                ans = add(ans, a[1] + a[0] + 1 + b[0] + b[2]);
                a[1] = add(a[1], a[1] + a[0]);
                b[x + 1] = add(b[x + 1], b[x + 1]);
                b[x - 1] = add(b[x - 1], b[x - 1] + 1);
            } else {
                ans = add(ans, a[x - 1] + a[x] + a[x - 2] + b[x - 1] + b[x + 1]);
                a[x] = add(a[x], a[x - 1] + a[x]);
                b[x + 1] = add(b[x + 1], b[x + 1]);
                b[x - 1] = add(b[x - 1], b[x - 1] + a[x - 2]);
            }
        }
        pr(ans);
    }

    // Accepted --- https://codeforces.com/contest/1613/submission/137721582
    // reference: wifi
    void solve1(int n, int[] A) {
        long[] a = new long[n + 2], b = new long[n + 2];
        long ans = 0;
        for (int x : A) {
            if (x == 0) {
                ans = (ans + a[0] + b[x + 1] + 1) % mod;
                a[0] = (a[0] + a[0] + 1) % mod;
                b[x + 1] = (b[x + 1] * 2) % mod;
            } else if (x == 1) {
                ans = (ans + a[1] + a[0] + 1 + b[0] + b[2]) % mod;
                a[1] = (a[1] + a[1] + a[0]) % mod;
                b[x + 1] = (b[x + 1] + b[x + 1]) % mod;
                b[x - 1] = (b[x - 1] + b[x - 1] + 1) % mod;
            } else {
                ans = (ans + a[x - 1] + a[x] + a[x - 2] + b[x - 1] + b[x + 1]) % mod;
                a[x] = (a[x] + a[x - 1] + a[x]) % mod;
                b[x + 1] = (b[x + 1] + b[x + 1]) % mod;
                b[x - 1] = (b[x - 1] + b[x - 1] + a[x - 2]) % mod;
            }
//            pr(ans);
//            tr(a);
//            tr(b);
        }
        pr(ans);
    }

    long add(long x, long y) { // needs to use return otherwise not working for both java and JS
        x += y;
        if (x >= mod) x %= mod;
        return x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new D().run();
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

