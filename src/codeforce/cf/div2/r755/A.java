/**
 * 11/13/21 night
 * https://codeforces.com/contest/1589/problem/0
 */
package codeforce.cf.div2.r755;

import java.util.*;
import java.io.*;

// Pretests passed
public class A {
    static PrintWriter pw;

    /*
        (vx + uy) / uv = (x + y) / (u + v)
         uv * (x + y) = (vx + uy) * (u + v)
         uvx + uvy = uvx + uvy + v * v * x + u * u * y
         0 = v * v * x + u * u * y
         x * (v ^ 2) = - y * (u ^ 2)
         x / y = - (u ^ 2) / (v ^ 2)
     */
    void solve(long u, long v) {
        long x = u * u;
        long y = v * v;
        long g = gcd(x, y);
        x /= g;
        y /= g;
//        tr("after", x, y);
//        tr(test(u, v, -x, y));
        pr((-x) + " " + (y));
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    boolean test(long u, long v, long x, long y) {
        return v * v * x + u * u * y == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long u = fs.nextLong(), v = fs.nextLong();
            solve(u, v);
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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