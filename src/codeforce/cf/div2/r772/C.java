/**
 * 02/20/22 morning
 * https://codeforces.com/contest/1635/problem/C
 */
package codeforce.cf.div2.r772;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1635/submission/147116766
    // reference: https://codeforces.com/blog/entry/100153
    void solve(int n, int[] a) {
        if (a[n - 2] > a[n - 1]) { // we can't change the last two elements
            pr(-1);
            return;
        }
        if (a[n - 1] < 0) {
            pr(test(a) ? 0 : -1);
        } else {
            pr(n - 2);
            for (int i = 1; i <= n - 2; i++) pr(i + " " + (n - 1) + " " + n);
        }
    }

    //////////////////////////////////////////////////////////////////////////////
    // WA  x y z can be not consecutive
    void solve1(int n, int[] a) {
        int step = 0;
        List<String> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && i + 2 < n && a[i] > a[i + 1] && a[i + 1] > a[i + 2]) {
                pr(-1);
                return;
            }
            if (i + 1 < n && i + 2 < n && a[i] > a[i + 1]) { // a[i + 1] <= a[i + 2];
                int v = a[i + 1] - a[i + 2];
                tr(a[i], a[i + 1], a[i + 2]);
                if (v <= a[i + 1]) { // issue
                    a[i] = v;
                    l.add((i + 1) + " " + (i + 2) + " " + (i + 3));
                    step++;
                }
            }
            tr("a", a, test(a));
        }
        tr("a", a, test(a));
//        if (!test(a)) {
//            pr(-1);
//            return;
//        }
        pr(step);
        for (String e : l) pr(e + " ");
    }

    boolean test(int[] a) {
        int n = a.length;
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        return Arrays.equals(a, b);
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
        new C().run();
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


