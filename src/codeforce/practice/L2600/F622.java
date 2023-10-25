/**
 * 09/09/22 evening
 * https://codeforces.com/problemset/problem/622/F
 */
package codeforce.practice.L2600;

import java.util.*;
import java.io.*;

public class F622 {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;

//    long[] comb_init(int N) {
//        long[] fact = new long[N];
//        fact[0] = 1;
//        for (int i = 1; i < N; i++) fact[i] = fact[i - 1] * i % mod;
//        return fact;
//    }

    // TLE https://codeforces.com/problemset/submission/622/171556225
    // reference: https://codeforces.com/contest/622/submission/15938350
    void solve(int n, int k) {
//         long[] fact = comb_init(k + 3);
        long[] fact = new long[k + 3];
        fact[0] = 1;
        long[] s = new long[k + 3];
        for (int i = 1; i <= k + 2; i++) {
            s[i] = (s[i - 1] + pow_mod(i, k)) % mod;
            fact[i] = fact[i - 1] * i % mod;
        }
        if (n <= k + 2) {
            pr(s[n]);
            return;
        }
        long res = 0, c = 1;
        for (int i = 0; i < k + 2; i++) c = c * (n - i) % mod;
        for (int i = 0; i < k + 2; i++) {
            long b = multi_mod(fact[i], fact[k + 1 - i]);
            long rev2 = n - i;
            if ((k + 1 - i) % 2 != 0) b = mod - b;
            res += multi_mod(multi_mod(multi_mod(s[i], c), pow_mod(rev2, mod - 2)), pow_mod(b, mod - 2));
        }
        pr(res % mod);
    }

    long multi_mod(long x, long y) {
        return x * y % mod;
    }

    // TLE
    void solve1(int n, int k) {
        long pre = 1, res = 1;
        for (int i = 1; i < n; i++) {
            long p = pow_mod(i + 1, k);
            // tr(i + 1, p);
            res = (pre + p) % mod;
            pre = res;
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
        new F622().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}