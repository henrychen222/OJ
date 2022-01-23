/**
 * 01/10/22 morning
 * https://codeforces.com/contest/1624/problem/B
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    /*
       10 5 30 ->   -20 5 30 (no)  10 20 30 (yes)  10 5 0 (no)
       1 6 3  ->
     */
    void solve(int[] a) {
        int[] b = Arrays.copyOf(a, 3), d = Arrays.copyOf(a, 3);
        double[] c = new double[3];
        for (int i = 0; i < 3; i++) c[i] = a[i];
        // change a
        if (b[1] <= b[2]) {
            int diff = b[2] - b[1];
            b[0] = b[1] - diff;
        } else {
            int diff = b[1] - b[2];
            b[0] = b[1] + diff;
        }
        // change b
        if (c[0] <= c[2]) {
            double diff = (c[2] - c[0]) / 2;
            c[1] = c[0] + diff;
        } else {
            double diff = (c[0] - c[2]) / 2;
            c[1] = c[0] - diff;
        }
        // change c
        if (d[0] <= d[1]) {
            int diff = d[1] - d[0];
            d[2] = d[1] + diff;
        } else {
            int diff = d[0] - d[1];
            d[2] = d[1] - diff;
        }
//        tr(a);
//        tr(b, c, d);
        if (b[0] >= a[0] && b[0] % a[0] == 0) {
            // tr("a");
            pr("YES");
            return;
        }
        if (c[1] >= a[1] && c[1] % a[1] == 0) {
            // tr("b");
            pr("YES");
            return;
        }
        if (d[2] >= a[2] && d[2] % a[2] == 0) {
            // tr("c");
            pr("YES");
            return;
        }
        pr("NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a);
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