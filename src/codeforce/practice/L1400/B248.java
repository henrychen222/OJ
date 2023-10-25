/**
 * 01/12/23 night
 * https://codeforces.com/problemset/problem/248/B
 */
package codeforce.practice.L1400;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class B248 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/248/189064233
    // Accepted JS --- https://codeforces.com/problemset/submission/248/189063156 (solve first)
    void go(int n) {
        if (n <= 6) {
            pr(solve(n));
        } else {
            String[] d = new String[12];
            int pos = (n % 6) + 6 - 1;
            for (int i = 1; i <= 11; i++) d[i - 1] = solve(i);
            String s = d[pos];
            int cnt = n / 6 - 1, idx = middleZeroEnd(s);
            String l = s.substring(0, idx), r = s.substring(idx);
            String res = l + "0".repeat(6 * cnt) + r;
            pr(res);
        }
    }

    int middleZeroEnd(String s) {
        int i = 1;
        for (; i < s.length() && s.charAt(i) == '0'; i++) ;
        return i;
    }

    /*
     TLE
     https://codeforces.com/problemset/submission/248/189056189
     https://codeforces.com/problemset/submission/248/189056717
     */
    String solve(int n) {
        long v = 1;
        int[] a = {2, 3, 5, 7};
        for (int x : a) {
            v = lcm(v, x);
        }
        BigInteger lcm = new BigInteger(v + ""), min = new BigInteger("1" + "0".repeat(n - 1)), max = new BigInteger("9".repeat(n));
        BigInteger start = lcm.multiply(min.divide(lcm)), end = lcm.multiply(max.divide(lcm));
        // tr(min, max, start, end);
        if (lcm.compareTo(end) > 0) return "-1";
        return start.toString().length() == n ? start.toString() : start.add(lcm).toString();
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        go(n);
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
        new B248().run();
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