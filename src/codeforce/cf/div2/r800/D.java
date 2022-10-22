/**
 * 06/16/22 morning
 * https://codeforces.com/contest/1694/problem/D
 */
package codeforce.cf.div2.r800;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1694/submission/160889560
    // reference: Heltion tourist
    void solve(int n, int[] p, int[] L, int[] R) {
        // tr(n, p, L, R);
        long[] sum = new long[n + 1];
        int res = 0;
        for (int i = n; i >= 1; i--) { // child -> parent
            if (sum[i] < L[i]) {
                res++;
                sum[i] = R[i];
            }
            sum[p[i]] += Math.min(sum[i], R[i]);
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] p = new int[n + 1], L = new int[n + 1], R = new int[n + 1];
            for (int i = 2; i <= n; i++) p[i] = fs.nextInt();
            for (int i = 1; i <= n; i++) {
                L[i] = fs.nextInt();
                R[i] = fs.nextInt();
            }
            solve(n, p, L, R);
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
        new D().run();
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