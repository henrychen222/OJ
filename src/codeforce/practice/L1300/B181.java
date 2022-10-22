/**
 * 09/07/22 night
 * https://codeforces.com/problemset/problem/181/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B181 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/181/171309540
    void solve(int n, int[][] p) {
        Arrays.sort(p, (x, y) -> x[0] - y[0]);
        Set<String> se = new HashSet<>();
        for (int[] e : p) se.add(e[0] + " " + e[1]);
        // tr(se);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] m = findMiddlePoint(p[i], p[j]);
                // tr(p[i], p[j], m);
                if (isInteger(m[0]) && isInteger(m[1])) {
                    String ke = (int) m[0] + " " + (int) m[1];
                    if (se.contains(ke)) res++;
                }
            }
        }
        pr(res);
    }

    // TLE https://codeforces.com/problemset/submission/181/171308654
    void solve1(int n, int[][] p) {
        Arrays.sort(p, (x, y) -> x[0] - y[0]);
        // tr(p);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (threePointsInLine(p[i], p[j], p[k])) {
                        if (middle(p[i], p[j], p[k]) || middle(p[i], p[k], p[j])
                                || middle(p[j], p[i], p[k]) || middle(p[j], p[k], p[i])
                                || middle(p[k], p[i], p[j]) || middle(p[k], p[j], p[i])) {
                            // tr(i, j, k);
                            res++;
                        }
                    }
                }
            }
        }
        pr(res);
    }

    // reference: https://www.geeksforgeeks.org/program-find-mid-point-line/
    double[] findMiddlePoint(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
        double rx = (double) (x1 + x2) / 2, ry = (double) (y1 + y2) / 2;
        return new double[]{rx, ry};
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    boolean threePointsInLine(int[] p1, int[] p2, int[] p3) {
        long x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1], x3 = p3[0], y3 = p3[1];
        return (x2 - x1) * (y3 - y2) == (x3 - x2) * (y2 - y1);
    }

    // AB = BC
    boolean middle(int[] A, int[] B, int[] C) { // B in middle of AC
        int ax = A[0], ay = A[1], bx = B[0], by = B[1], cx = C[0], cy = C[1];
        int disAB_sq = Math.abs(ax - bx) * Math.abs(ax - bx) + Math.abs(ay - by) * Math.abs(ay - by);
        int disBC_sq = Math.abs(bx - cx) * Math.abs(bx - cx) + Math.abs(by - cy) * Math.abs(by - cy);
        return disAB_sq == disBC_sq;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) points[i] = fs.readArray(2);
        solve(n, points);
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
        new B181().run();
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