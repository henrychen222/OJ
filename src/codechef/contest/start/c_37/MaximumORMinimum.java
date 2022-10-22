/**
 * 05/04/22 morning
 * https://www.codechef.com/START37C/problems/MAXORMIN
 */
package codechef.contest.start.c_37;

import java.util.*;
import java.io.*;

class MaximumORMinimum {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/64246122
    // reference: https://discuss.codechef.com/t/maxormin-editorial/100969
    void solve(int n, int[] a) {
        int zero = 0, one = 0;
        for (int x : a) {
            if (x == 0) {
                zero++;
            } else {
                one++;
            }
        }
        pr(zero > one ? 0 : 1);
    }

    /*
     WA
     https://www.codechef.com/viewsolution/64235317
     https://www.codechef.com/viewsolution/64234895
     */
    void solve1(int n, int[] a) {
        tr(1 | 0, 1 | 1, 0 | 0);
        tr(1 & 0, 1 & 1, 0 & 0);
        int zero = 0, one = 0;
        for (int x : a) {
            if (x == 0) {
                zero++;
            } else {
                one++;
            }
        }
        // tr("zero", zero, "one", one);
        if (zero % 2 == 0) {
            if (one % 2 == 0) {
                // tr("111");
                pr(0);
            } else {
                // tr("222");
                pr(0);
            }
        } else {
            if (one % 2 == 0) {
                // tr("333");
                pr(1);
            } else {
                // tr("444");
                pr(0);
            }
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
        new MaximumORMinimum().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
