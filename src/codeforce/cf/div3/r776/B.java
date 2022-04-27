/**
 * 03/08/22 morning
 * https://codeforces.com/contest/1650/problem/B
 */
package codeforce.cf.div3.r776;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(long l, long r, long a) {
//        tr("each case", l, r, a);
//        long max = 0;
//        for (long x = l; x <= r; x++) { // test
//            long v = cal(x, a);
//            max = Math.max(max, v);
//            tr('x', x, "value", v);
//        }
//        tr("max", max);
        long last = cal(r, a);
//        long pre = -1;
//        for (long x = r; x >= l; x--) {
//            long v = cal(x, a);
//            // tr('x', x, "value", v);
//            if (v > pre && pre != -1) {
//                pr(Math.max(v, last));
//                return;
//            }
//            pre = v;
//        }
//        pr(last);

        long preMaxX = r / a * a - 1;
        long v = cal(preMaxX, a);
        if (preMaxX >= l && preMaxX <= r) {
            pr(Math.max(last, v));
        } else {
            pr(last);
        }

//        tr(100 / 8 * 8);
    }

    long cal(long x, long a) {
        return x / a + (x % a);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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

