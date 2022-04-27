/**
 * 03/10/22 morning
 * https://codeforces.com/contest/1651/problem/C
 */
package codeforce.ecf.r124;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1651/submission/149176272
    // reference: SecondThread
    void solve(int n, int[] a, int[] b) {
//        Arrays.sort(a);
//        Arrays.sort(b);
//        int amin = Arrays.stream(a).min().getAsInt();
//        int bmin = Arrays.stream(b).min().getAsInt();
//        long res1 = 0, res2 = 0;
//        for (int i = 0; i < n; i++) res1 += Math.abs(a[i] - bmin);
//        for (int i = 0; i < n; i++) res2 += Math.abs(b[i] - amin);
//        tr(res1, res2);

        long res = Long.MAX_VALUE;
        res = Math.min(res, diff(a[0], b[0]) + diff(a[n - 1], b[n - 1]));
        res = Math.min(res, diff(a[0], b[n - 1]) + diff(a[n - 1], b[0]));

        res = Math.min(res, diff(a[0], b[0]) + minDiff(a, b[n - 1]) + minDiff(b, a[n - 1]));
        res = Math.min(res, diff(a[n - 1], b[n - 1]) + minDiff(a, b[0]) + minDiff(b, a[0]));

        res = Math.min(res, diff(a[0], b[n - 1]) + minDiff(a, b[0]) + minDiff(b, a[n - 1]));
        res = Math.min(res, diff(a[n - 1], b[0]) + minDiff(a, b[n - 1]) + minDiff(b, a[0]));

        res = Math.min(res, minDiff(a, b[0]) + minDiff(b, a[0]) + minDiff(a, b[n - 1]) + minDiff(b, a[n - 1]));

        pr(res);
    }

    int diff(int x, int y) {
        return Math.abs(x - y);
    }

    long minDiff(int[] a, int x) {
        long res = Long.MAX_VALUE;
        for (int e : a) res = Math.min(res, Math.abs(e - x));
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int[] b = fs.readArray(n);
            solve(n, a, b);
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
        new C().run();
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


