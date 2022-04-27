/**
 * 03/22/22 morning
 * https://codeforces.com/contest/1657/problem/0
 */
package codeforce.ecf.r125;

import java.util.*;
import java.io.*;

// Accepted
public class A {
    static PrintWriter pw;

    /*
     9 15 -> 9 0 -> 9 15
     */
    void solve(int x, int y) {
        if (x == 0 && y == 0) {
            pr(0);
            return;
        }
        int d = x * x + y * y;
        // tr(d, Math.sqrt(d), sqrtIsInteger(d));
        pr(sqrtIsInteger(d) ? 1 : 2);
    }

    boolean sqrtIsInteger(int x) {
        double sq = Math.sqrt(x);
        return isInteger(sq);
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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