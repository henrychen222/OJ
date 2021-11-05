/**
 * 11/05/21 morning
 * https://codeforces.com/contest/122/problem/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A122 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/122/submission/134400162
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        Set<Integer> se = new HashSet<>();
        for (int x = 1; x <= 1000; x++) {
            if (isLucky(x + "")) se.add(x);
        }
        // tr(se);
        String s = fs.next();
        if (isLucky(s)) {
            pr("YES");
        } else {
            int x = Integer.parseInt(s);
            for (int d : se) {
                if (x % d == 0) {
                    pr("YES");
                    return;
                }
            }
            pr("NO");
        }
    }

    boolean isLucky(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '4' && c != '7') return false;
        }
        return true;
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
        new A122().run();
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