/**
 * 06/18/22 morning
 * https://codeforces.com/contest/1695/problem/C
 */
package codeforce.cf.div2.r801;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1695/submission/161126404
    // reference: https://codeforces.com/contest/1695/problem/C
    void solve(int n, int m, int[][] g) {
        // tr(n, m, g);
        int[][] min = new int[n + 1][m + 1];
        int[][] max = new int[n + 1][m + 1]; // maximum possible sum of a path starting at the top left and ending at [i, j]
        min[0][0] = max[0][0] = g[0][0];
        for (int i = 1; i < n; i++) {
            min[i][0] = max[i - 1][0] + g[i][0];
            max[i][0] = min[i][0];
        }
        // tr(min, max);
        for (int j = 1; j < m; j++) {
            min[0][j] = max[0][j - 1] + g[0][j];
            max[0][j] = min[0][j];
        }
        // tr(min, max);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) { // transition formula
                max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + g[i][j]; // from top/left
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + g[i][j];
            }
        }
        // tr(min, max);
        int minEnd = min[n - 1][m - 1], maxEnd = max[n - 1][m - 1];
        // tr(minEnd, maxEnd);
        pr(minEnd <= 0 && maxEnd >= 0 && maxEnd % 2 == 0 ? "YES" : "NO"); //  min[n-1][m-1] <= 0 <= max[n-1][m-1]  0 inside min max sum
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] g = new int[n][];
            for (int i = 0; i < n; i++) g[i] = fs.readArray(m);
            solve(n, m, g);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}