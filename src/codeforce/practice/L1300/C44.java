/**
 * 10/19/22 evening
 * https://codeforces.com/problemset/problem/44/C
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class C44 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/44/177070353
    void solve(int n, int m, int[][] a) {
        int[] f = new int[101];
        for (int[] e : a) {
            for (int x = e[0]; x <= e[1]; x++) f[x]++;
        }
        for (int i = 1; i <= n; i++) {
            if (f[i] != 1) {
                pr(i + " " + f[i]);
                return;
            }
        }
        pr("OK");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] a = new int[m][];
        for (int i = 0; i < m; i++) a[i] = fs.readArray(2);
        solve(n, m, a);
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
        new C44().run();
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