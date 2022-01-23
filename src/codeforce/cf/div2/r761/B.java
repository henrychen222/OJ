/**
 * 12/16/21 morning
 * https://codeforces.com/contest/1617/problem/B
 */
package codeforce.cf.div2.r761;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted ---  https://codeforces.com/contest/1617/submission/139550869 (fuck only 10 minutes extra needs)
    void solve(int n) {
        // tr("n", n);
        if (n % 2 != 0) { // odd + even + even
            int f = n / 2;
            if (f % 2 == 0) {
                int a = f - 1, b = f + 1, c = 1;
                // tr("f", f, a, b, c, test(a, b, c, n));
                pr(a + " " + b + " " + c);
            } else {
                int a = f - 2, b = f + 2, c = 1;
                // tr("f", f, a, b, c, test(a, b, c, n));
                pr(a + " " + b + " " + c);
            }
        } else {
            int sum = n - 1;
            int f = sum / 2;
            // tr(test(f, f + 1, 1, n));
            pr(f + " " + (f + 1) + " " + 1);
        }
    }

    boolean test(int a, int b, int c, int n) {
        // tr("sum", a + b + c, "expect", n, "gcd", gcd(a, b), "expect", c);
        if (a + b + c != n) return false;
        if (gcd(a, b) != c) return false;
        return true;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new B().run();
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