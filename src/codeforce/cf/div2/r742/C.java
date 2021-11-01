/**
 * 09/05/21 evening
 * https://codeforces.com/contest/1567/problem/C
 */

package codeforce.cf.div2.r742;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1567/submission/128002423
    // reference: Tlatoani
    void solve(int n) {
        String s = n + "";
        // tr(s);
        String x = "0", y = "0";
        for (int i = 0; i < s.length(); i += 2) x += s.charAt(i);
        for (int i = 1; i < s.length(); i += 2) y += s.charAt(i);
        Long rx = Long.parseLong(x);
        Long ry = Long.parseLong(y);
        // tr(rx, ry);
        pr((rx + 1) * (ry + 1) - 2);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int tt = fs.nextInt();
        while (tt-- > 0) {
            int n = fs.nextInt();
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
        new C().run();
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