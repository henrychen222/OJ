/**
 * 11/05/21 morning
 * https://codeforces.com/problemset/problem/14/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B14 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/14/134390936
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), x0 = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] a = fs.readArray(2);
            Arrays.sort(a);
            g[i] = a;
        }
        List<int[]> d = mergeIntervals(g);
        if (d.size() > 1) { // no overlapping
            pr(-1);
            return;
        }
        int[] res = d.get(0);
        int l = res[0], r = res[1];
        if (x0 >= l && x0 <= r) {
            pr(0);
        } else {
            pr(Math.min(Math.abs(l - x0), Math.abs(r - x0)));
        }
    }

    // reference: https://leetcode.com/problems/merge-intervals/discuss/1239679/javascript-92ms-70.21
    List<int[]> mergeIntervals(int[][] a) { // return final intersection, 交集  LC是并集
        // tr("in", a);
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{a[0][0], a[0][1]});
        int preEnd = a[0][1];
        for (int[] b : a) {
            int start = b[0], end = b[1];
            if (start > preEnd) {
                res.add(new int[]{start, end});
                preEnd = end;
            } else {
                int[] pre = res.get(res.size() - 1);
                res.remove(res.size() - 1);
                int left = Math.max(pre[0], start); // 交集左边求大，右边求小, 并集相反
                int right = Math.min(pre[1], end);
                res.add(new int[]{left, right});
                preEnd = right;
            }
        }
//        int[][] debug = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) debug[i] = res.get(i);
//        tr("out", debug);
        return res;
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
        new B14().run();
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