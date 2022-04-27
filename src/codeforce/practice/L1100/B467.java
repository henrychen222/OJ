/**
 * 03/03/22 noon
 * https://codeforces.com/problemset/problem/467/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B467 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/467/148230926
    // reference: https://codeforces.com/blog/entry/13870  uwi
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(m + 1);
        int res = 0, lastArmy = a[m];
        for (int i = 0; i < m; i++) {
            int army = a[i], diff = bitsDiffSum(army, lastArmy);
            // tr(army, lastArmy, diff);
            int types = Integer.bitCount(diff);
            if (types <= k) res++;
        }
        pr(res);
    }

    int bitsDiff1(int x, int y) {
        String s = Integer.toBinaryString(x);
        String t = Integer.toBinaryString(y);
        // tr(s, t);
        if (s.length() < 32) s = "0".repeat(32 - s.length()) + s;
        if (t.length() < 32) t = "0".repeat(32 - t.length()) + t;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (s.charAt(i) != t.charAt(i)) cnt++;
        }
        return cnt;
    }

    int bitsDiffSum(int x, int y) {
        return x ^ y;
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
        new B467().run();
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