/**
 * 04/19/26 afternoon
 * https://csacademy.com/contest/archive/task/array-removal/
 * same problem
 * https://leetcode.com/problems/maximum-segment-sum-after-removals/
 */
package fii.practice.medium.ArrayRemoval;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://csacademy.com/submission/7533531
    void maximumSegmentSumAfterRemovals(int n, int[] a, int[] b) {
        b = Arrays.stream(b).map(x -> x - 1).toArray();
        long[] res = new long[n];
        Set<Integer> used = new HashSet<>();
        DJSetPrefixSum ds = new DJSetPrefixSum(n);
        long max = 0;
        for (int i = n - 1; i >= 0; i--) {
            used.add(b[i]);
            ds.update(b[i], a[b[i]]);
//            tr(b[i], ds.pre, used.contains(b[i] - 1), used.contains(b[i] + 1));
            if (used.contains(b[i] - 1)) ds.union(b[i], b[i] - 1);
            if (used.contains(b[i] + 1)) ds.union(b[i], b[i] + 1);
//            tr(b[i], ds.pre);
            int par = ds.find(b[i]);
            max = Math.max(max, ds.pre[par]);
            res[i] = max;
        }
        for (long e : res) pr(e);
    }

    static class DJSetPrefixSum {
        int[] p;
        int n;
        long[] pre; // group prefix sum

        DJSetPrefixSum(int n) {
            this.p = new int[n];
            this.n = n;
            Arrays.fill(p, -1);
            this.pre = new long[n];
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (p[x] < p[y]) {
                int d = x;
                x = y;
                y = d;
            }
            p[x] += p[y];
            p[y] = x;
            pre[x] += pre[y];
            return true;
        }

        void update(int idx, int v) {
            pre[idx] += v;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n);
        maximumSegmentSumAfterRemovals(n, a, b);
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
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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