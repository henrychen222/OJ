/**
 * 11/04/22 night
 * https://codeforces.com/problemset/problem/41/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B41 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/41/179406007
    void BestTimeBuySellStockOneTransactionTotal(int n, int b, int[] a) {
        int[] R = new int[n];
        R[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) R[i] = Math.max(R[i + 1], a[i]);
//        tr(a);
//        tr(R);
        long max = 0;
        for (int i = 0; i < n - 1; i++) {
            int cnt = b / a[i], followingMax = R[i + 1];
            if (followingMax > a[i]) {
                int profit = followingMax - a[i];
                // tr(a[i], "followingMax", followingMax, "profit", profit);
                max = Math.max(max, (long) profit * cnt);
            }
        }
        pr(max + b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), b = fs.nextInt();
        int[] a = fs.readArray(n);
        BestTimeBuySellStockOneTransactionTotal(n, b, a);
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
        new B41().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}