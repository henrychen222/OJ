/**
 * 12/12/21 morning
 * https://codeforces.com/contest/1591/problem/B
 */
package codeforce.cf.div2.r759;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, int[] a) {
//        int[] b = Arrays.copyOf(a, n);
//        Arrays.sort(b);
//        tr(b);
        int max = Integer.MIN_VALUE;
        for (int x : a) max = Math.max(max, x);
        int pre = a[n - 1];
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > pre) {
                pre = a[i];
                res++;
            }
        }
        pr(res);
        // pr((test(a)));
    }

    long test(int[] a) {
        int n = a.length;
        long res = 0;
        while (true) {
            int x = a[n - 1];
            List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
            for (int e : a) {
                if (e <= x) {
                    l.add(e);
                } else {
                    r.add(e);
                }
            }
            l.addAll(r);
            int[] t = new int[n];
            for (int i = 0; i < n; i++) t[i] = l.get(i);
            if (Arrays.equals(a, t)) break;
            a = t;
            tr(a);
            res++;
        }
        return res;
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