/**
 * 03/27/22 morning
 * https://codeforces.com/contest/1658/problem/B
 */
package codeforce.cf.div2.r779;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;
    private final int mod = 998244353;

    // Pretests passed
    void solve(int n) {
        if (n % 2 != 0) {
            pr(0);
            return;
        }
        long h = n / 2;
        // test(n);
        long res = factorial(h, h) * factorial(h, h) % mod;
        pr(res);
    }

    long factorial(long m, long n) {
        long res = 1;
        long cnt = 0;
        for (long i = m; i > 0; i--) {
            if (cnt == n) break;
            res *= i;
            res %= mod;
            cnt++;
        }
        return res;
    }


    void test(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        int[] rev = reverseA(a);
        tr(a, rev);
        long res = 0;
        if (isBeautiful(a)) res++;
        // for (int i = 0; i < 10; i++) {
        while (!Arrays.equals(rev, a)) {
            next_permutation(a);
            if (isBeautiful(a)) res++;
        }
        tr(res);
    }

    boolean isBeautiful(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[i] * (i + 1);
        int g = gcdArray(b);
        if (g > 1) tr(a, "g", g);
        return g > 1;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int gcdArray(int[] a) {
        int res = 0;
        for (int x : a) {
            res = gcd(res, x);
            if (res == 1) {
                return 1;
            }
        }
        return res;
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    boolean next_permutation(int[] a) { // array inside can be char ('0' ~ '9', 'a' ~ 'z') and int[]
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
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
        new B().run();
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