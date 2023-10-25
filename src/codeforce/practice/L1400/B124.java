/**
 * 12/21/22 night
 * https://codeforces.com/problemset/problem/124/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B124 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/124/186324860
    void solve(int n, int m, char[][] g) {
        int[] p = new int[m];
        for (int i = 0; i < m; i++) p[i] = i;
        int res = Integer.MAX_VALUE;
        do {
            // tr(p);
            int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < m; j++) {
                    char c = g[i][p[j]];
                    // tr(i, j, p[j], c);
                    s += c;
                }
                int v = Integer.parseInt(s);
                smallest = Math.min(smallest, v);
                largest = Math.max(largest, v);
            }
            // tr(smallest, largest);
            res = Math.min(res, largest - smallest);
        } while (next_permutation(p));
        pr(res);
    }

    boolean next_permutation(int[] a) { // array inside can be char ('0' ~ '9', 'a' ~ 'z') and int[]
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        solve(n, m, g);
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
        new B124().run();
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