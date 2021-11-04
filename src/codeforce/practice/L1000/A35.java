/**
 * 11/04/21 morning
 * https://codeforces.com/problemset/problem/35/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A35 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/35/134317014
    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        int[] a = {1, 2, 3};
        int idx = fs.nextInt() - 1;
        a[idx] = -1;
        for (int t = 0; t < 3; t++) {
            int i = fs.nextInt() - 1, j = fs.nextInt() - 1;
            // tr(a);
            swap(a, i, j);
        }
        for (int i = 0; i < 3; i++) {
            if (a[i] == -1) {
                pr(i + 1);
                return;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
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
            pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        new A35().run();
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
