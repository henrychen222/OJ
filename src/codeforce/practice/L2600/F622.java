/**
 * 09/09/22 evening  05/02/26 morning
 * https://codeforces.com/problemset/problem/622/F
 * reference:
 * https://codeforces.com/contest/622/submission/15938350
 * deepseek
 */
package codeforce.practice.L2600;

import java.util.*;
import java.io.*;

public class F622 {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;

    // Accepted --- https://codeforces.com/problemset/submission/622/373354085
    void solve(int n, int k) {
        int m = k + 2; // number of points needed
        long[] fact = new long[m + 1];
        long[] ifact = new long[m + 1];
        fact[0] = 1;
        long[] s = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            s[i] = (s[i - 1] + pow_mod(i, k)) % mod;
            fact[i] = fact[i - 1] * i % mod;
        }
        ifact[m] = pow_mod(fact[m], mod - 2);
        for (int i = m - 1; i >= 0; i--) {
            ifact[i] = ifact[i + 1] * (i + 1) % mod;
        }
        if (n <= k + 2) {
            pr(s[n]);
            return;
        }

        long[] pre = new long[m + 1]; // prefix products of (n - j) for j = 0..m-1
        pre[0] = 1;
        for (int i = 1; i <= m; i++) {
            pre[i] = pre[i - 1] * ((n - i + mod) % mod) % mod;   // (n - i)
        }
        long[] suf = new long[m + 2]; // suffix products of (n - j) for j = m-1 down to 0
        suf[m + 1] = 1;
        for (int i = m; i >= 1; i--) {
            suf[i] = suf[i + 1] * ((n - i + mod) % mod) % mod;
        }

        long res = 0;
        for (int i = 1; i <= m; i++) {
            long numerator = s[i] * pre[i - 1] % mod * suf[i + 1] % mod; // numerator = S[i] * ∏_{j≠i} (n - j)
            long denominator = ifact[i - 1] * ifact[m - i] % mod;      // denominator = (i-1)! * (m-i)!
            if ((m - i) % 2 == 1) {
                numerator = mod - numerator;   // sign = (-1)^{m-i}
            }
            res = (res + numerator * denominator) % mod;
        }
        pr(res);
    }

    long pow_mod(long a, long b) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(2);
        solve(a[0], a[1]);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new F622().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignore) {
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}