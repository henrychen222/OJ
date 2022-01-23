/**
 * 01/12/22 morning
 * https://codeforces.com/contest/1625/problem/A
 */
package codeforce.cf.div2.r765;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // don't know
    void solve(int n, int l, int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        tr(m);
        test(n, l, a);
    }

    void test(int n, int l, int[] a) {
        Arrays.sort(a);
        int min = a[0], max = a[n - 1];
        long res = Long.MAX_VALUE;
        for (int y = min; y <= max; y++) {
            String s = Integer.toBinaryString(y);
            long sum = 0;
            for (int x : a) {
                String t = Integer.toBinaryString(x);
                int diff = difference(s, l, t);
                // tr(y, x, diff, s, t);
                sum += diff;
            }
            tr("y", y, "sum", sum);
            res = Math.min(res, sum);
        }
        tr(res);
    }

    int difference(String s, int l, String t) {
        if (s.length() <= l) {
            s = s + "0".repeat(l - s.length());
        } else {
            s = s.substring(0, l);
        }
        if (t.length() <= l) {
            t = t + "0".repeat(l - t.length());
        } else {
            t = t.substring(0, l);
        }
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) res++;
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), l = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, l, a);
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
        new A().run();
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