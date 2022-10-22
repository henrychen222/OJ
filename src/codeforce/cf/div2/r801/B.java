/**
 * 06/18/22 morning
 * https://codeforces.com/contest/1695/problem/B
 */
package codeforce.cf.div2.r801;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1695/submission/161124314
    // reference: cuiaoxiang kmjp  https://codeforces.com/blog/entry/103996
    void solve(int n, int[] a) {
        if (n % 2 != 0) {
            pr("Mike");
            return;
        }
        int min = Arrays.stream(a).min().getAsInt();
        for (int i = 0; i < n; i++) {
            if (a[i] == min) {
                pr(i % 2 == 0 ? "Joe" : "Mike");
                return;
            }
        }
    }

    // WA
    void solve1(int n, int[] a) {
        if (n % 2 != 0) {
            pr("Mike");
            return;
        }
        long mike = 0, joe = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                mike += a[i];
            } else {
                joe += a[i];
            }
        }
//        long d = Math.abs(mike - joe);
//        // tr(mike, joe, d);
//        pr(d % 2 == 0 ? "Joe" : "Mike");

        if (mike > joe) {
            pr("Mike");
        } else {
            pr("Joe");
        }
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