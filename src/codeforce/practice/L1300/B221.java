/**
 * 10/17/22 night
 * https://codeforces.com/problemset/problem/221/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B221 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/221/176821574
    void solve(int n) {
        pr(countFactors(n));
    }

    // reference: https://www.w3resource.com/java-exercises/basic/java-basic-exercise-57.php
    int countFactors(int n) {
        int res = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0 && i * i != n) {
                int d = n / i;
                // tr("111", i, d, n);
                if (hasAtLeastOneSameDigit(i, n)) res++;
                if (hasAtLeastOneSameDigit(d, n)) res++;
            } else if (i * i == n) {
                // tr("222", i, n);
                if (hasAtLeastOneSameDigit(i, n)) res++;
            }
        }
        return res;
    }

    boolean hasAtLeastOneSameDigit(int x, int y) {
        String sx = x + "", sy = y + "";
        for (int i = 0; i < sx.length(); i++) {
            if (sy.indexOf(sx.charAt(i)) != -1) return true;
        }
        return false;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
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
        new B221().run();
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