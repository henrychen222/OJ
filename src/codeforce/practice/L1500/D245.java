/**
 * 05/04/26 morning
 * https://codeforces.com/problemset/problem/245/D
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class D245 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/245/373536067
    void solve(int[][] g) {
        int n = g.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != -1) { // AND will be smaller, recover needs to be OR (larger)
                    a[i] |= g[i][j];
                    a[j] |= g[i][j];
                }
            }
        }
//        tr(test(g, a));
        outputA(a);
    }

    boolean test(int[][] g, int[] a) {
        int n = g.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != -1 && (a[i] & a[j]) != g[i][j]) {
                    tr(a[i], a[j], a[i] & a[j], g[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(n);
        solve(g);
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
        new D245().run();
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