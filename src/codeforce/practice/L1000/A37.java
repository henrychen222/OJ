/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/37/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A37 {

    static PrintWriter pw;

    /**
     * Accepted
     * https://codeforces.com/problemset/submission/37/133867263 (uncomment read file) 404ms
     * https://codeforces.com/problemset/submission/37/133867329 (comment read file) 404ms
     */
    void solve(int n, int[] a) {
        // tr(a);
        int[] cnt = new int[1001];
        for (int x : a) cnt[x]++;
        // tr(cnt);
        int max = 0, tot = 0;
        for (int i = 1000; i >= 0; i--) {
            if (cnt[i] == 0) continue;
            max = Math.max(max, cnt[i]);
            tot++;
        }
        pr(max + " " + tot);
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
        new A37().run();
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