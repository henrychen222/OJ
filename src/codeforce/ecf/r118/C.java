/**
 * 12/1/21 morning
 * https://codeforces.com/contest/1613/problem/C
 */
package codeforce.ecf.r118;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1613/submission/137714255
    // reference: kmjp https://codeforces.com/contest/1613/submission/137634607
    void solve(int n, long h, int[] a) {
        // tr(n, h, a);
        long res = h;
        for (int i = 62; i >= 0; i--) {
            // tr(1L << i);
            long tmp = res - (1L << i);
            if (tmp < 0) continue;
            long sum = tmp;
            for (int j = 0; j + 1 < n; j++) {
                sum += Math.min(tmp, a[j + 1] - a[j]);
                if (sum >= h) break;
            }
            if (sum >= h) res = tmp;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long h = fs.nextLong();
            int[] a = fs.readArray(n);
            solve(n, h, a);
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

