/**
 * 10/21/26 afternoon
 * https://codeforces.com/problemset/problem/276/C
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class C276 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/276/395423518
    // reference: https://codeforces.com/blog/entry/6778
    void solve(int n, int q, int[] a, int[][] queries) {
        DiffArray da = new DiffArray(n);
        for (int[] e : queries) {
            da.update(e[0], e[1], 1);
        }
        da.simulate();
        // tr(da.diff);
        long res = 0;
        Arrays.sort(a);
        Arrays.sort(da.diff);
        // greedy: pair max val with max freq
        for (int i = 0; i < n; i++) res += da.diff[i] * a[i];
        pr(res);
    }

    static class DiffArray {
        int n;
        long[] diff; // stores the total amount to be added to each index

        DiffArray(int n) {
            this.n = n;
            this.diff = new long[n];
        }

        void update(int l, int r, int v) { // [L, R]
            diff[l] += v;
            if (r + 1 < n) diff[r + 1] -= v;
        }

        void simulate() {
            for (int i = 1; i < n; i++) diff[i] += diff[i - 1];
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = fs.readArray(n);
        int[][] queries = new int[q][];
        for (int i = 0; i < q; i++) queries[i] = new int[]{fs.nextInt() - 1, fs.nextInt() - 1};
        solve(n, q, a, queries);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new C276().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignored) {
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