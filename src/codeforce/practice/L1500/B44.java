/**
 * 04/23/26 night
 * https://codeforces.com/problemset/problem/44/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B44 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/44/372324998
    // reference: https://codeforces.com/blog/entry/833
    void solve(int n, int a, int b, int c) {
        int res = 0;
        for (int x = 0; x <= a; x++) {
            for (int y = 0; y <= b; y++) {
                double z = (n - 0.5 * x - y) / 2;
//                tr(x, y, z);
                if (z >= 0 && z <= c && isInteger(z)) res++;
            }
        }
        pr(res);
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(4);
        solve(a[0], a[1], a[2], a[3]);
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
        new B44().run();
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