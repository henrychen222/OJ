/**
 * 05/04/22 afternoon
 * https://codeforces.com/problemset/problem/365/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B365 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/365/155877648
    // reference: uwi
    void solve(int n, int[] a) {
        if (n == 1 || n == 2) {
            pr(n);
            return;
        }
        int max = 2, cur = 2;
        for (int i = 2; i < n; i++) {
            if (a[i - 2] + a[i - 1] == a[i]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 2;
            }
        }
        pr(max);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new B365().run();
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