/**
 * 10/21/22 night
 * https://codeforces.com/problemset/problem/39/H
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class H39 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/39/177414092
    void solve(int k) {
        k--;
        String[][] g = new String[k][k];
        for (int j = 0; j < k; j++) g[0][j] = (j + 1) + "";
        for (int i = 0; i < k; i++) g[i][0] = (i + 1) + "";
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                int v = (i + 1) * (j + 1);
                g[i][j] = Integer.toString(v, k + 1);
            }
        }
        outputGrid(g);
    }

    void outputGrid(String[][] g) {
        for (String[] a : g) {
            for (String e : a) {
                pw.print(e + " ");
            }
            pr("");
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int k = fs.nextInt();
        solve(k);
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
        new H39().run();
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