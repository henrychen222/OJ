/**
 * 09/05/22 night
 * https://codeforces.com/problemset/problem/92/B
 */
package codeforce.practice.L1300;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class B92 {
    static PrintWriter pw;

    // Accepted
    // reference uwi
    void solve(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length, p = n - 1;
        for (int t = 0; ; t++) {
            if (p == 0) {
                if (s[p] == '0') {
                    pr(t + 1);
                } else {
                    pr(t);
                }
                return;
            }
            if (s[p] == '1') {
                for (int i = p; i >= 0; i--) {
                    if (s[i] == '0') {
                        s[i] = '1';
                        break;
                    } else {
                        s[i] = '0';
                    }
                }
            } else {
                p--;
            }
            // tr(s);
        }
    }

    // TLE
    void solve1(String s) {
        BigInteger cur = new BigInteger(s, 2);
        int res = 0;
        try {
            while (cur.compareTo(BigInteger.ONE) != 0) {
                if (isEven(cur)) {
                    cur = cur.divide(BigInteger.TWO);
                } else {
                    cur = cur.add(BigInteger.ONE);
                }
                res++;
                // tr(cur, res);
            }
            pr(res);
        } catch (NumberFormatException e) {
        }
    }

    boolean isEven(BigInteger x) {
        return x.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        solve(s);
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
        new B92().run();
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