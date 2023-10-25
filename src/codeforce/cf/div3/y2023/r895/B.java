/**
 * 09/07/23 evening
 * https://codeforces.com/contest/1872/problem/B
 */
package codeforce.cf.div3.y2023.r895;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[][] ds) {
        // tr(ds);
        double res = Double.MAX_VALUE;
        for (int[] e : ds) {
            double k = (double) e[1] / 2 + e[0];
            // tr(k);
            res = Math.min(res, k);
        }
        if (isInteger(res)) {
            pr((int) res - 1);
        } else {
            pr((int) Math.floor(res));
        }
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[][] ds = new int[n][];
            for (int i = 0; i < n; i++) ds[i] = fs.readArray(2);
            solve(n, ds);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}