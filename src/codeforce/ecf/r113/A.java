/**
 * 09/08/21 morning
 * https://codeforces.com/contest/1569/problem/A
 */
package codeforce.ecf.r113;

import java.util.*;
import java.io.*;

public class A {

    static PrintWriter pw;

    // Accepted
    void solve(int n, String s) {
        // tr(n, s);
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (s.charAt(j) == 'a') {
                    a++;
                } else {
                    b++;
                }
                if (a == b) {
                    // tr(s.substring(i, j + 1), a, b);
                    pr((i + 1) + " " + (j + 1));
                    return;
                }
                // tr(s.substring(i, j + 1), a, b);
            }
        }
        pr((-1) + " " + (-1));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            solve(n, s);
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