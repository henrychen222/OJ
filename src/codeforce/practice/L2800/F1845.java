/**
 * 05/02/26 morning
 * https://codeforces.com/problemset/problem/1845/F
 *
 * reference:
 * https://cp-algorithms.com/algebra/polynomial.html
 * https://cp-algorithms.com/algebra/fft.html
 * https://cp-algorithms.com/algebra/fft.html#number-theoretic-transform (NTT)
 * https://codeforces.com/contest/1845/submission/211937038
 * deepseek
 */
package codeforce.practice.L2800;

import java.util.*;
import java.io.*;

// Accepted
public class F1845 {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;
    static final int NTT_MOD = 998244353;
    final int G = 3; // primitive root for MOD

    void solve(int l, int t, int n, int[] v) {
        int maxV = 0;
        for (int x : v) {
            if (x > maxV) maxV = x;
        }
        int m = maxV;
        Poly f = new Poly(m + 1);
        for (int x : v) f.set(x, 1);

        // sum = f * f  (convolution)
        Poly sum = f.multiply(f);
        // subtract self-pairs: for each velocity v, reduce coefficient at 2*v by 1
        for (int x : v) {
            int idx = 2 * x;
            if (idx < sum.coeff.length) {
                long val = sum.get(idx) - 1;
                if (val < 0) val += NTT_MOD;
                sum.set(idx, val % NTT_MOD);
            }
        }

        boolean[] g = new boolean[2 * m + 1];
        for (int i = 1; i <= 2 * m; i++) {
            if (sum.get(i) != 0) g[i] = true;
        }

        // differences via middle product
        Poly dif = f.middleProduct(f);
        for (int i = 1; i <= m; i++) {
            if (dif.get(i) != 0) g[i] = true;
        }

        m *= 2;  // now m = 2 * maxV
        // propagate divisors: if a multiple is achievable, the divisor becomes achievable
        for (int i = 1; i <= m; i++) {
            for (int j = i + i; j <= m; j += i) {
                if (g[j]) {
                    g[i] = true;
                    break;
                }
            }
        }
        long[] h = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            h[i] = (long) i * t / (2L * l);   // integer division (floor)
        }
        // Möbius inversion
        for (int i = 1; i <= m; i++) {
            for (int j = 2 * i; j <= m; j += i) {
                h[j] -= h[i];
            }
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            if (g[i]) {
                ans += h[i];
                ans %= mod;
            }
        }
        pr(ans);
    }

    void ntt(long[] a, boolean invert) {
        int n = a.length;
        int j = 0;
        for (int i = 1; i < n; i++) {
            int bit = n >> 1;
            while (j >= bit) {
                j -= bit;
                bit >>= 1;
            }
            j += bit;
            if (i < j) {
                long t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            long wlen = pow_mod(G, (NTT_MOD - 1) / len, NTT_MOD);
            if (invert) wlen = pow_mod(wlen, NTT_MOD - 2, NTT_MOD);
            for (int i = 0; i < n; i += len) {
                long w = 1;
                for (int k = 0; k < len / 2; k++) {
                    long u = a[i + k];
                    long v = a[i + k + len / 2] * w % NTT_MOD;
                    a[i + k] = (u + v) % NTT_MOD;
                    a[i + k + len / 2] = (u - v + NTT_MOD) % NTT_MOD;
                    w = w * wlen % NTT_MOD;
                }
            }
        }
        if (invert) {
            long invN = pow_mod(n, NTT_MOD - 2, NTT_MOD);
            for (int i = 0; i < n; i++) a[i] = a[i] * invN % NTT_MOD;
        }
    }

    long[] multiplyNTT(long[] a, long[] b) {
        int need = a.length + b.length - 1;
        int n = 1;
        while (n < need) n <<= 1;
        long[] fa = Arrays.copyOf(a, n);
        long[] fb = Arrays.copyOf(b, n);
        ntt(fa, false);
        ntt(fb, false);
        for (int i = 0; i < n; i++) fa[i] = fa[i] * fb[i] % NTT_MOD;
        ntt(fa, true);
        return Arrays.copyOf(fa, need);
    }

    // Correct middle product: (a * rev(b)) shifted left by (b.length-1)
    long[] middleProductNTT(long[] a, long[] b) {
        long[] rb = new long[b.length];
        for (int i = 0; i < b.length; i++) rb[i] = b[b.length - 1 - i];
        long[] conv = multiplyNTT(a, rb);
        int shift = b.length - 1;
        int newLen = conv.length - shift;
        long[] res = new long[newLen];
        for (int i = 0; i < newLen; i++) res[i] = conv[i + shift];
        return res;
    }

    // ---------- Poly class ----------
    class Poly {
        long[] coeff;
        Poly(int size) { coeff = new long[size]; }
        Poly(long[] c) { coeff = c; }

        long get(int i) { return i < coeff.length ? coeff[i] : 0; }
        void set(int i, long v) {
            if (i >= coeff.length) coeff = Arrays.copyOf(coeff, i + 1);
            coeff[i] = v;
        }

        Poly multiply(Poly other) {
            return new Poly(multiplyNTT(this.coeff, other.coeff));
        }

        Poly middleProduct(Poly other) {
            return new Poly(middleProductNTT(this.coeff, other.coeff));
        }
    }

    long pow_mod(long a, long b, long mod) {
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
        int l = fs.nextInt(), t = fs.nextInt(), n = fs.nextInt();
        int[] v = fs.readArray(n);
        solve(l, t, n, v);
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
        new F1845().run();
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