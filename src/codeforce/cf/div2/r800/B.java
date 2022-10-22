/**
 * 06/16/22 morning
 * https://codeforces.com/contest/1694/problem/B
 */
package codeforce.cf.div2.r800;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, char[] s) {
        long not = 0, tot = totSub(n);
        for (int i = 1; i < n; i++) { // ....00
            if ((s[i - 1] == '0' && s[i] == '0') || (s[i - 1] == '1' && s[i] == '1')) {
                not += i;
            }
        }
        // tr(tot, not, tot - not);
        pr(tot - not);
    }

    long totSub(int n) {
        return (long) n * (n + 1) / 2;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
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
        new B().run();
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