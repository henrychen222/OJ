/**
 * 01/30/23 night
 * https://codeforces.com/problemset/problem/205/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B205 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/205/191327059
    // reference: https://www.geeksforgeeks.org/minimum-range-increment-operations-to-sort-an-array/
    void MinimumRangeIncrementSortArray(int n, int[] a) {
        long res = 0;
        int min = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > min) res += a[i] - min;
            min = a[i];
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        MinimumRangeIncrementSortArray(n, a);
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
        new B205().run();
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