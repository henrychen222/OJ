/**
 * 08/26/22 evening
 * https://codeforces.com/problemset/problem/48/B
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class B48 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/48/169748569
    void solve(int n, int m, int[][] g, int a, int b) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + a - 1 < n && j + b - 1 < m) {
                    // tr(i, j, i + a, j + b);
                    int tree = countTreeInSquare(g, i, j, i + a - 1, j + b - 1);
                    res = Math.min(res, tree);
                }
                if (i + b - 1 < n && j + a - 1 < m) {
                    int tree = countTreeInSquare(g, i, j, i + b - 1, j + a - 1);
                    res = Math.min(res, tree);
                }
            }
        }
        pr(res);
    }

    int countTreeInSquare(int[][] g, int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        int tree = 1, cnt = 0;
        for (int i = topLeftX; i <= bottomRightX; i++) {
            for (int j = topLeftY; j <= bottomRightY; j++) {
                if (g[i][j] == tree) cnt++;
            }
        }
        return cnt;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(m);
        int a = fs.nextInt(), b = fs.nextInt();
        solve(n, m, g, a, b);
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
        new B48().run();
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