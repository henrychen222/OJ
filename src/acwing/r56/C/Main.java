/**
 * 06/18/22 morning
 * https://www.acwing.com/problem/content/4487/
 */
package acwing.r56.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.acwing.com/problem/content/submission/code_detail/14830640/
    /*
      reference:
      https://www.acwing.com/solution/content/121376/
      https://www.acwing.com/solution/content/121342/
     */
    void solve(long p, long q, long b) {
        long g = gcd(p, q);
        // 约分
        p /= g;
        q /= g;
        pr(isFiniteDecimal(q, b) ? "YES" : "NO");
    }

    boolean isFiniteDecimal(long x, long base) { // 是否为有限小数
        while (true) {
            long g = gcd(x, base);
            if (g == 1) break;
            while (x % g == 0) x /= g;
        }
        return x == 1;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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
        new Main().run();
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}