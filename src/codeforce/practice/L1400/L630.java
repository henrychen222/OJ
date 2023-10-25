/**
 * 04/19/23 night
 * https://codeforces.com/problemset/problem/630/L
 */
package codeforce.practice.L1400;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class L630 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/630/202787058
    void solve(int n) {
        String s = n + "", t = "";
        for (int i = 0; i < s.length(); i += 2) t += s.charAt(i);
        for (int i = s.length() - 2; i >= 0; i -= 2) t += s.charAt(i);
        BigInteger v = new BigInteger(t), p = v;
        for (int i = 0; i < 4; i++) p = p.multiply(v);
        String res = p.toString();
        pr(res.substring(res.length() - 5));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
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
        new L630().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}