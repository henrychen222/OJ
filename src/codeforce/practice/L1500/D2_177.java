/**
 * 04/23/26 night
 * https://codeforces.com/problemset/problem/177/D2
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class D2_177 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/177/372311400
    void solve(int[] a, int[] b, int c) {
        int n = a.length, m = b.length;
        DiffArrayMOD da = new DiffArrayMOD(a, c);
        // Each b[i] is added to a[i ... i+(n-m)] inclusive
        for (int i = 0; i < m; i++) {
            da.update(i, i + n - m, b[i]);
        }
        da.simulate();
        long[] res = da.recover();
        outputA(res);
    }

    void outputA(long[] a) {
        for (long e : a) pw.print(e + " ");
        pr("");
    }

    static class DiffArrayMOD {
        int[] a;
        int n;
        long[] diff; // stores the total amount to be added to each index
        int mod;

        DiffArrayMOD(int[] a, int mod) {
            this.a = a;
            this.n = a.length;
            this.diff = new long[n];
            this.mod = mod;
        }

        void update(int l, int r, int v) { // [L, R]
            diff[l] = (diff[l] + v) % mod;
            if (r + 1 < n) diff[r + 1] = (diff[r + 1] - v + mod) % mod;
        }

        void simulate() {
            for (int i = 1; i < n; i++) diff[i] = (diff[i - 1] + diff[i]) % mod;
        }

        long[] recover() {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) res[i] = (a[i] + diff[i]) % mod;
            return res;
        }
    }


//    static class SegmentTreeRMQ {
//        final int h, n;
//        int[] a;
//        final int ini = Integer.MAX_VALUE;
//
//        SegmentTreeRMQ(int n) {
//            this.n = n;
//            this.a = new int[Integer.highestOneBit(Math.max(n - 1, 1)) << 2];
//            this.h = a.length >>> 1;
//            Arrays.fill(a, ini);
//        }
//
//        void update(int pos, int v) {
//            a[h + pos] = v;
//            for (int i = parent(h + pos); i >= 1; i = parent(i)) propagate(i);
//        }
//
//        void propagate(int i) {
//            a[i] = f(a[left(i)], a[right(i)]);
//        }
//
//        int query(int l, int r) {
//            return Query(l, r + 1);
//        }
//
//        int Query(int l, int r) { // [L, R)
//            int res = ini;
//            if (l >= r) return res;
//            l += h;
//            r += h;
//            for (; l < r; l = parent(l), r = parent(r)) {
//                if ((l & 1) == 1) res = f(res, a[l++]);
//                if ((r & 1) == 1) res = f(res, a[--r]);
//            }
//            return res;
//        }
//
//        int f(int x, int y) {
//            return Math.min(x, y);
//        }
//        int parent(int i) {
//            return i >>> 1;
//        }
//        int left(int i) {
//            return 2 * i;
//        }
//        int right(int i) {
//            return 2 * i + 1;
//        }
//    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), c = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(m);
        solve(a, b, c);
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
        new D2_177().run();
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