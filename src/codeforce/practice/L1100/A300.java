/**
 * 01/15/22 afternoon
 * https://codeforces.com/problemset/problem/300/A
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class A300 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/300/submission/142900667
    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        TreeSet<Integer> pos = new TreeSet<>(), neg = new TreeSet<>(), zero = new TreeSet<>();
        for (int x : a) {
            if (x < 0) {
                neg.add(x);
            } else if (x > 0) {
                pos.add(x);
            } else {
                zero.add(x);
            }
        }
        // tr(neg, pos, zero);
        if (pos.size() == 0) {
            pos.add(neg.pollFirst());
            pos.add(neg.pollFirst());
        }
        // tr(neg, pos, zero);
        if (neg.size() % 2 == 0) {
            int first = neg.pollFirst();
            zero.add(first);
        }
        // tr(neg, pos, zero);
        pw.print(neg.size() + " ");
        outputS(neg);
        pw.print(pos.size() + " ");
        outputS(pos);
        pw.print(zero.size() + " ");
        outputS(zero);
    }

    void outputS(TreeSet<Integer> se) {
        for (int x : se) pw.print(x + " ");
        pr("");
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
        new A300().run();
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
