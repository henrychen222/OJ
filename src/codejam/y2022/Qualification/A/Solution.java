/**
 * 04/01/22 evening
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a4621b
 */
package codejam.y2022.Qualification.A;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted
    void solve(int r, int c) {
        int n = 2 * c + 1;
        String s1 = build(n, '|', '.'), s2 = build(n, '+', '-');
        // tr(s1, s2);
        pr(".." + s2.substring(2));
        pr(".." + s1.substring(2));
        for (int i = 0; i < r; i++) {
            pr(s2);
            if (i != r - 1) pr(s1);
        }
    }

    String build(int n, char first, char second) {
        String s = "";
        for (int i = 0; i < n; i++) {
            if (s.length() == 0) {
                s += first;
            } else {
                if (s.charAt(s.length() - 1) == first) {
                    s += second;
                } else {
                    s += first;
                }
            }
        }
        return s;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pr("Case #" + cas + ": ");
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new Solution().run();
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