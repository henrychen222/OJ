/**
 * 02/14/22 noon
 * https://codeforces.com/contest/1638/problem/A
 */
package codeforce.practice.L800;

import java.util.*;
import java.io.*;

public class A1638 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1638/submission/146455302
    void solve(int n, Integer[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) m.put(a[i], i);
        for (int i = 0; i < n; i++) {
            if (a[i] != i + 1) {
                int j = m.get(i + 1);
                for (int p = i, q = j; p < q; p++, q--) { // reverse [l, r] subarray
                    // tr(p, q);
                    swap(a, p, q);
                }
                break;
            }
        }
        outputA(a);
    }

    // WA
    void solve1(int n, Integer[] a) {
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    break;
                }
            }
        }
        outputA(a);
    }

    <T> void outputA(T[] a) {
        for (T e : a) pw.print(e + " ");
        pr("");
    }

    <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            Integer[] a = fs.readArray(n);
            solve(n, a);
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
        new A1638().run();
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

        Integer[] readArray(int n) {
            Integer[] a = new Integer[n];
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
