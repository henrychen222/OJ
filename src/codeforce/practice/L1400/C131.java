/**
 * 12/26/22 night
 * https://codeforces.com/problemset/problem/131/C
 */
package codeforce.practice.L1400;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class C131 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/131/186857779
    void solve(int n, int m, int t) {
        BigInteger res = BigInteger.ZERO;
        for (int i = 4; t - i >= 1; i++) {
            BigInteger boys = combination(n, i), girls = combination(m, t - i);
//            tr(n, i, boys);
//            tr(m, t - i, girls);
            res = res.add(boys.multiply(girls));
        }
        pr(res);
    }

    BigInteger combination(int m, int n) {
        return factorial(m, n).divide(factorial(n, n));
    }

    BigInteger factorial(int m, int n) {
        BigInteger res = BigInteger.ONE;
        for (long i = m, cnt = 0; i > 0 && cnt < n; i--, cnt++) res = res.multiply(new BigInteger(i + ""));
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(3);
        solve(a[0], a[1], a[2]);
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
        new C131().run();
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