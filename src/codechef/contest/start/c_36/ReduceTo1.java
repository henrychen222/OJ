/**
 * 04/27/22 morning
 * https://www.codechef.com/START36C/problems/RED1
 */
package codechef.contest.start.c_36;

import java.util.*;
import java.io.*;

class ReduceTo1 {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/63839113
    // reference: https://discuss.codechef.com/t/red1-editorial/100863
    void solve(long n) {
        if (n == 1) {
            pr(0);
            return;
        }
        long cur = n, cnt = 0;
        while (cur % 2 == 0) {
            cur /= 2;
            cnt++;
        }
        if (cnt == 0) { // n is odd
            pr(1);
            return;
        } else if (cnt % 2 == 1) {
            pr(-1);
            return;
        }
        double sq = Math.sqrt(n);
        pr(isLong(sq) ? 1 : 2); // check perfect square
    }

    boolean isLong(double x) {
        return x == (long) x;
    }

    /*
    256 / 16 = 16  2

     4    2 ^ 2    1
     16   2 ^ 4    1
     64   2 ^ 6    1

     odd  3 ^ 1
     odd  3 ^ 3

      16   4 ^ 2
      256  4 ^ 4

      36    6 ^ 2
      1296  6 ^ 4
     */
    // WA https://www.codechef.com/viewsolution/63830852
    void solve1(long n) {
        if (n % 2 != 0) {
            if (n == 1) {
                pr(0);
            } else {
                pr(1);
            }
            return;
        }
        for (int i = 0; i < 60; i++) {
            if (i % 2 == 0) {
                long x = 1L << i;
                // tr(x, x <= Math.pow(10, 18));
                if (x == n) {
                    pr(1);
                    return;
                }
            }
        }
        pr(-1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            solve(n);
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
        new ReduceTo1().run();
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
