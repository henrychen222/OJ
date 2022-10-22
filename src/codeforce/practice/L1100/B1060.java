/**
 * 05/08/22 night
 * https://codeforces.com/problemset/problem/1060/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B1060 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/1060/156383637
    // reference  neal  um_nik
    void solve(long n) {
//        long x = n % 2 == 0 ? n / 2 + 1 : n / 2, y = n - x;
//        pr(sumOfDigit(x) + sumOfDigit(y));

        int res = 0;
        for (long x = 0; x <= n; x = x * 10 + 9) {
            long y = n - x;
            // tr(x, y);
            res = Math.max(res, sumOfDigit(x) + sumOfDigit(y));
        }
        pr(res);
    }

    int sumOfDigit(long x) {
        int res = 0;
        String s = x + "";
        for (int i = 0; i < s.length(); i++) res += s.charAt(i) - '0';
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        solve(n);
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
        new B1060().run();
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