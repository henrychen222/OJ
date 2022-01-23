/**
 * 01/17/22 afternoon
 * https://codeforces.com/problemset/problem/746/B
 */
package codeforce.practice.L900;

import java.util.*;
import java.io.*;

public class B746 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/746/143158085
    void decode(int n, String s) {
        String t = "";
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int len = t.length();
            if (len < 2) {
                t = c + t;
            } else {
                int idx = len / 2 - 1;
                t = t.substring(0, idx + 1) + c + t.substring(idx + 1);
            }
            // tr(t, c);
        }
        pr(t);
    }

    String encode(String s) {
        String res = "";
        while (true) {
            int len = s.length();
            if (len == 0) break;
            int i = len % 2 == 0 ? len / 2 - 1 : len / 2;
            tr(s, s.charAt(i));
            res += s.charAt(i);
            s = s.substring(0, i) + s.substring(i + 1);
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next();
//        String es = encode(s);
//        tr(es);
//        decode(n, es);
        decode(n, s);
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
        new B746().run();
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

