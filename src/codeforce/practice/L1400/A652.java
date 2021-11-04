/**
 * 11/04/21 morning
 * https://codeforces.com/problemset/problem/652/A
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class A652 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/652/submission/134315423
    // reference: kmjp
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int h1 = fs.nextInt(), h2 = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
        long cur = h1;
        for (int d = 0; d < 100001; d++) {
            for (int hour = 0; hour < 24; hour++) {
                if (hour < 8 || hour >= 20) {
                    cur += a;
                } else {
                    cur -= b;
                }
                if (hour <= 12 && cur >= h2){
                    pr(d);
                    return;
                }
            }
        }
        pr(-1);
    }

    // WA don't understand this problem
    private void run1() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int h1 = fs.nextInt(), h2 = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
        // tr(h1, h2, a, b);
        if (a < b) {
            pr(-1);
            return;
        }
        long res = 0, cur = 0;
        while (true) {
            cur += a * 13L;
            // tr(cur);
            if (cur >= h2) break;
            cur -= b * 12L;
            cur = Math.max(0, cur);
            res++;
        }
        pr(res);
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
        new A652().run();
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