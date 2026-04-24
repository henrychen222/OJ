/**
 * 04/13/26 morning
 * https://codeforces.com/problemset/problem/91/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B91 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/91/371038899
    void solve(int n, int[] a) {
        int[][] b = new int[n][];
        for (int i = 0; i < n; i++) {
            b[i] = new int[]{a[i], i};
        }
        Arrays.sort(b, Comparator.comparingInt(x -> x[0]));
//        tr(b);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            int curIdx = b[i][1];
            if (maxIdx > curIdx) {
                int dis = maxIdx - b[i][1] - 1;
//                tr(b[i], maxIdx, dis);
                res[b[i][1]] = dis;
            }
            maxIdx = Math.max(maxIdx, b[i][1]);
        }
//        int[][] d = suffixMinWithFurthestIndices(a);
//        int[] R = d[0], idx = d[1];
//        tr(R, idx);
//        for (int i = 0; i < n; i++) {
//            if (R[i] < a[i]) {
//                int dis = idx[i] - i - 1;
//                res[i] = dis;
//            }
//        }
        outputA(res);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    int[][] suffixMinWithFurthestIndices(int[] a) {
        int n = a.length;
        int[] R = new int[n];
        int[] idx = new int[n];
        R[n - 1] = a[n - 1];
        idx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < R[i + 1]) {
                R[i] = a[i];
                idx[i] = i;
            } else {
                R[i] = R[i + 1];
                idx[i] = idx[i + 1];
            }
        }
        return new int[][]{R, idx};
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new B91().run();
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