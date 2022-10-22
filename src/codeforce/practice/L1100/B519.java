/**
 * 05/24/22 noon
 * https://codeforces.com/problemset/problem/519/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B519 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/519/158320321
    void solve(int n, int[] a, int[] b, int[] c) {
        long sa = sumArray(a), sb = sumArray(b), sc = sumArray(c);
        pr(sa - sb);
        pr(sb - sc);
    }

    long sumArray(int[] a) {
        return Arrays.stream(a).mapToLong(Long::valueOf).sum();
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n - 1), c = fs.readArray(n - 2);
        solve(n, a, b, c);
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
        new B519().run();
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