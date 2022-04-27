/**
 * 03/24/22 morning
 * https://codeforces.com/contest/1656/problem/A
 */
package codeforce.codeton.r1;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, int[] a) {
//        tr(n, a);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (ok(i, j, a)) {
//                    tr(i + 1, j + 1);
//                }
//            }
//        }
        int[][] b = new int[n][];
        for (int i = 0; i < n; i++) b[i] = new int[]{a[i], i + 1};
        Arrays.sort(b, (x, y) -> x[0] - y[0]);
        // tr(b, ok(b[0][1] - 1, b[n - 1][1] - 1, a));
        pr(b[0][1] + " " + b[n - 1][1]);
    }

    boolean ok(int i, int j, int[] a) {
        int n = a.length;
        for (int k = 0; k < n; k++) {
            int ld = Math.abs(a[i] - a[k]) + Math.abs(a[k] - a[j]);
            int rd = Math.abs(a[i] - a[j]);
            if (ld != rd) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
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
        new A().run();
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

    /*
     a[i] - a[k] + a[k] - a[j] = a[i] - a[j]  nothing

     a[k] - a[i] + a[k] - a[j] = a[i] - a[j]
          2 * a[k] = 2 * a[i]
              a[k] = a[i]

     a[i] - a[k] + a[j] - a[k] = a[i] - a[j]
          2 * a[j] = 2 * a[k]
              a[j] = a[k]

     a[k] - a[i] + a[j] - a[k] = a[i] - a[j]
             2 * a[j] = 2 * a[i]
              a[j] = a[i]
     */