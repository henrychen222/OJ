/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/120/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B120 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/120/133890016
    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt() - 1;
        int[] a = fs.readArray(n);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) ts.add(i);
        }
        // tr(ts, k);
        int first = ts.first();
        if (k <= first) {
            pr(first + 1);
        } else {
            Integer res = ts.ceiling(k);
            // tr(res);
            if (res == null) res = first;
            pr(res + 1);
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
            pw = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT)));
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws IOException {
        new B120().run();
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
