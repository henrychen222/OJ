/**
 * 10/11/21 morning
 * http://acm.hdu.edu.cn/showproblem.php?pid=1003
 */
package hdu.p1021;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main2 {

    static PrintWriter pw;

    boolean[] dp;

    // issue
    void solve(int n) {
        dp = new boolean[n + 1];
        BigInteger first = new BigInteger("7");
        BigInteger second = new BigInteger("11");
        dp[0] = ok(first);
        dp[1] = ok(second);
        for (int i = 2; i <= n; i++) {
            BigInteger cur = first.add(second);
            dp[i] = ok(cur);
            // tr(dp[i]);
            first = second;
            second = cur;
        }
    }

    boolean ok (BigInteger x) {
        BigInteger three = new BigInteger("3");
        if (!x.mod(three).equals(0)) {
            return false;
        }
        BigInteger two = new BigInteger("2");
        return (x.divide(three)).mod(two).equals(0);
    }

    private void run() {
        read_write_file(); // comment this before submission
        solve(1000000);
        FastScanner fs = new FastScanner();
        try {
            while (true) {
                int n = fs.nextInt();
                pr(dp[n] ? "yes" : "no");
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
        new Main2().run();
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