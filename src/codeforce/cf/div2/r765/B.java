/**
 * 01/12/22 morning
 * https://codeforces.com/contest/1625/problem/B
 */
package codeforce.cf.div2.r765;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1625/submission/142886028
    void solve(int n, int[] a) {
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i);
        }
        // tr(m);
        int res = -1;
        for (var l : m.values()) {
            int len = l.size();
            if (len == 1) continue;
//            int tmp = n - l.get(len - 1) + l.get(0); // don't know
//            tr("check", l, tmp);
//            res = Math.max(res, tmp);
            for (int i = 1; i < len; i++) { // reference: chinesedfan
                int tmp = l.get(i - 1) + 1 + (n - 1 - l.get(i));
                res = Math.max(res, tmp);
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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