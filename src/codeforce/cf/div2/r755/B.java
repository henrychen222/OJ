/**
 * 11/13/21 night
 * https://codeforces.com/contest/1589/problem/B
 */
package codeforce.cf.div2.r755;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1589/submission/135395735
    // reference:
    void solve(int n, int m) {
        int tot = n * m;
        pr(tot % 3 == 0 ? tot / 3 : tot / 3 + 1);
    }

    /*
     1 * 2  1 * 3  paint 1
     2 * 2  paint 2

     10   2 + 2 + 3 + 3    ans: 4
          2 + 2 + 2 + 4    ans: 5

          2 * 5 ->  2 * (2 + 3)
     */
    // don't know
    void solve1(int n, int m) {
        int tot = n * m;
//        long[] dp = new long[tot + 1];
//        dp[2] = dp[3] = 1;
//        dp[4] = 2;
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        tr(tot, min, max);
        pr((max / min) * min);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            solve(n, m);
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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