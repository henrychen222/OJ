/**
 * 11/05/21 evening
 * https://codeforces.com/problemset/problem/157/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B157 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/157/134444296
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Integer[] a = fs.readArray(n);
        Arrays.sort(a);
        // tr(a);
        int cnt = 0;
        for (int i = n - 1; i - 1 >= 0; i -= 2) {
            // tr(a[i], a[i - 1]);
            cnt += Math.pow(a[i], 2) - Math.pow(a[i - 1], 2);
        }
        if (n % 2 != 0) cnt += Math.pow(a[0], 2);
        pr(cnt * Math.PI);
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
        new B157().run();
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

        Integer[] readArray(int n) {
            Integer[] a = new Integer[n];
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