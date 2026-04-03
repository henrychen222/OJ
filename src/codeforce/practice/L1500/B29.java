/**
 * 06/14/25 morning
 * https://codeforces.com/problemset/problem/29/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B29 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/29/324360792
    void solve(int[] a) {
        double toLightTime = (double) a[1] / a[2];
        double lightToDesTime = (double) (a[0] - a[1]) / a[2];
        int GreenRedRound = a[3] + a[4];
        double rest = toLightTime % GreenRedRound;
        double wait = 0;
//        tr("GreenRedRound", GreenRedRound, "rest", rest);
        if (rest >= a[3] && rest <= GreenRedRound) wait += GreenRedRound - rest;
//        tr(toLightTime, lightToDesTime, wait);
        pr(toLightTime + lightToDesTime + wait);
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(5);
        solve(a);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B29().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
