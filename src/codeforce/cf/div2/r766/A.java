/**
 * 01/15/22 morning
 * https://codeforces.com/contest/1627/problem/0
 */
package codeforce.cf.div2.r766;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Pretests passed
    void solve(int[] a, char[][] g) {
        int n = a[0], m = a[1], r = a[2], c = a[3];
        r--;
        c--;
        // tr(n, m, r, c, g);
        if (g[r][c] == 'B') {
            pr(0);
            return;
        }
        boolean hasBlack = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'B') {
                    hasBlack = true;
                    break;
                }
            }
        }
        if (!hasBlack) {
            pr(-1);
            return;
        }
        for (int j = c; j < m; j++) { // right
            if (g[r][j] == 'B') {
                pr(1);
                return;
            }
        }
        for (int j = c; j >= 0; j--) { // left
            if (g[r][j] == 'B') {
                pr(1);
                return;
            }
        }
        for (int i = r; i < n; i++) { // down
            if (g[i][c] == 'B') {
                pr(1);
                return;
            }
        }
        for (int i = r; i >= 0; i--) { // top
            if (g[i][c] == 'B') {
                pr(1);
                return;
            }
        }
        pr(2);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(4);
            char[][] g = new char[a[0]][];
            for (int i = 0; i < a[0]; i++) g[i] = fs.next().toCharArray();
            solve(a, g);
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
        new A().run();
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