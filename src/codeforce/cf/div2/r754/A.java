/**
 * 11/12/21 morning
 * https://codeforces.com/contest/1605/problem/A
 */
package codeforce.cf.div2.r754;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1605/submission/135172894
    // reference: kmjp wifi
    void solve(long[] a) {
        long diff = diff(a);
        pr(diff % 3 == 0 ? 0 : 1);
    }

    // WA
    void solve1(long[] a) {
        Arrays.sort(a);
        long ld = a[1] - a[0], rd = a[2] - a[1];
        long diff = Math.abs(ld - rd);
        if (diff == 0) {
            pr(0);
            return;
        } else if (diff == 1) {
            pr(1);
            return;
        }
        // long judge = a[2] - a[0];
        long judge = ld + rd;
        tr(a, diff(a), judge);
        pr(judge % 3 == 0 ? 0 : 1);
//        if (ld > rd) {
//            for (int i = 0; i < 35; i++) {
//                a[1]--;
//                a[0]++;
//                tr(a, diff(a));
//            }
//        } else {
//            for (int i = 0; i < 35; i++) {
//                a[1]++;
//                a[0]--;
//                tr(a, diff(a));
//            }
//        }
    }

    long diff(long[] a) {
        return Math.abs(a[0] + a[2] - 2 * a[1]);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long[] a = fs.readArray(3);
            solve(a);
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