/**
 * 10/08/21 morning  10/08/21 evening complete
 * https://codeforces.com/contest/1594/problem/B
 */

package codeforce.cf.div2.r747;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;
    private final int mod = (int) (1e9 + 7);

    /*
      3 ^ 0 = 1
      3 ^ 1 = 3
      3 ^ 0 + 3 ^ 1 = 4
      3 ^ 2 = 9

      2 ^ 0 = 1
      2 ^ 1 = 2
      2 ^ 0 + 2 ^ 1 = 3
      2 ^ 2 = 4
      2 ^ 0 + 2 ^ 2 = 5
      2 ^ 1 + 2 ^ 2 = 6
      2 ^ 0 + 2 ^ 1 + 2 ^ 2 = 7
      2 ^ 3 = 8
      2 ^ 0 + 2 ^ 3 = 9
      2 ^ 1 + 2 ^ 3 = 10
      2 ^ 0 + 2 ^ 1 + 2 ^ 3 = 11
     */
    // Accepted --- https://codeforces.com/contest/1594/submission/131262419
    // reference: tourist
    void solve(int n, int k) {
        long res = 0;
        for (int base = 0; base < 30; base++) {
            // if (k << ~base < 0) {
            // if ((1 & (k >> base)) == 1) {
            if ((k & (1 << base)) != 0) {
                // tr(pow_mod(n, base, mod));
                res += pow_mod(n, base, mod);
                res %= mod;
            }
        }
        pr(res);
    }

    long pow_mod(long a, long b, int mod) {
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
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            solve(n, k);
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