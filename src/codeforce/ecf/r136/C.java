/**
 * 09/29/22 morning
 * https://codeforces.com/contest/1739/problem/B
 */
package codeforce.ecf.r136;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1739/submission/174013381
// refefence: kmjp
public class C {
    static PrintWriter pw;
    final int mod = 998244353;
    long[] fact, ifact, inv;
    int N = 70;

    void comb_init() {
        fact = new long[N];
        ifact = new long[N];
        inv = new long[N];
        fact[0] = ifact[0] = inv[1] = 1;
        for (int i = 2; i < N; i++) inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % mod;
            ifact[i] = ifact[i - 1] * inv[i] % mod;
        }
    }

    long comb(int n, int k) {
        if (n < k || k < 0) return 0;
        return fact[n] * ifact[k] % mod * ifact[n - k] % mod;
    }

    // C(n-1, n/2)
    /*
      [1, 2, 6]  [1, 3, 6]  [1, 4, 6]  [1, 5, 6]
      [2, 3, 6]  [2, 4, 6]  [2, 5, 6]
      [3, 4, 6]  [3, 5, 6]
      [4, 5, 6]
     */
    void solve(int n) {
//        tr(n, n / 2 - 1);
//        long tot = comb(n, n / 2);
//        long A = comb(n - 1, n / 2 - 1), B = tot - 1 - A;
//        tr("tot", tot, "A", A, "B", B);

        long A = 0, B = 0;
        for (int i = 0; i < n / 2; i++) {
            int rest = n - i * 2;
            A += comb(rest - 2, rest / 2);
            A %= mod;
            B += comb(rest - 2, rest / 2);
            B %= mod;
            if (i % 2 == 0) {
                A += comb(rest - 2, rest / 2 - 1);
                A %= mod;
            } else {
                B += comb(rest - 2, rest / 2 - 1);
                B %= mod;
            }
        }
        pr(A + " " + B + " " + 1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        comb_init();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new C().run();
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
