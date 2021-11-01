/**
 * 10/11/21 morning
 * http://acm.hdu.edu.cn/showproblem.php?pid=1003
 */
package hdu.p1021;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main1 {

    static PrintWriter pw;
    private final int mod = (int) 1e9 + 7;

    long[] dp;

    // WA
    // http://acm.hdu.edu.cn/viewcode.php?rid=36889403
    // http://acm.hdu.edu.cn/viewcode.php?rid=36891869
    void solve(int n) {
        dp = new long[n + 1];
        dp[0] = 7;
        dp[1] = 11;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        solve(1000000);
        FastScanner fs = new FastScanner();
        try {
            while (true) {
                int n = fs.nextInt();
                long x = dp[n];
                // tr(x);
                if (x % 3 != 0) {
                    pr("no");
                    continue;
                }
                pr((x / 3) % 2 == 0 ? "yes" : "no");
            }
        } catch (NullPointerException e) {
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
        new Main1().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}