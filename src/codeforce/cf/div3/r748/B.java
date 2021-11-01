/**
 * 10/13/21 morning
 * https://codeforces.com/contest/1593/problem/B
 */
package codeforce.cf.div3.r748;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1593/submission/131860713
    /*
       reference: LayCurse Priyansh31dec
                i  j
            ____2__5___
     ans:   ____25       (j - i - 1) + (n - 1 - j)
     */
    void solve (long N) {
        String s = N + "";
        char[] a = s.toCharArray();
        int n = s.length();
        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == '0' && a[j] == '0') {
                    res = Math.min(res, n - i - 2);
                } else if (a[i] == '2' && a[j] == '5') {
                    res = Math.min(res, n - i - 2);
                } else if (a[i] == '5' && a[j] == '0') {
                    res = Math.min(res, n - i - 2);
                } else if (a[i] == '7' && a[j] == '5') {
                    res = Math.min(res, n - i - 2);
                }
            }
        }
        pr(res);
    }

    // TLE
    void solve1(long N) {
        String s = N + "";
        char[] a = s.toCharArray();
        int n = s.length();
        int res = n;
        for (int i = 0; i < 1 << n; i++) {
            String sub = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sub += a[j];
                }
            }
            tr(sub);
            if (sub.length() != 0) {
                if (Long.parseLong(sub) % 25 == 0) res = Math.min(res, n - sub.length());
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}