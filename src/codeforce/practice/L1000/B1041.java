/**
 * 11/08/21 morning
 * https://codeforces.com/problemset/problem/1041/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B1041 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/1041/134669845
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        long a = fs.nextLong(), b = fs.nextLong(), x = fs.nextLong(), y = fs.nextLong();
        long g = gcd(x, y);
        x /= g;
        y /= g;
        // tr(x, a / x, y, b / y);
        pr(Math.min(a / x, b / y));
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B1041().run();
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
