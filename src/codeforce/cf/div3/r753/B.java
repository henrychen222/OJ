/**
 * 11/02/21 morning
 * https://codeforces.com/contest/1607/problem/B
 */

package codeforce.cf.div3.r753;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    /*
      n is odd
         -1 + 1 - 1 + 1
      9  ( + 1 - 2 - 3 + 4 + 5 - 6 - 7 + 8) + 9 = 18  (9, 9)

         +1 -1 + 1 - 1
      10 (- 1 + 2 + 3 - 4 - 5 + 6 + 7 - 8) - 9  = 1    (10, 9)

      n is even
          -1+1-1+1-1
      9  (+ 1 - 2 - 3 + 4 + 5 - 6 - 7 + 8 + 9 - 10) = 8    (9, 10)

         + 1 - 1 + 1 - 1 + 1
      10 - 1 + 2 + 3 - 4 - 5 + 6 + 7 - 8 - 9 + 10 = 11     (10, 10)

      1 - 0


           -1 + 1 -1
      9 ( + 1 - 2 - 3 + 4 + 5 - 6) - 7 = 1 (9 7)
           + 1 -1 + 1
      10 (- 1 + 2 + 3 - 4 - 5 + 6) + 7 = 18  (10 7)

          -1 + 1 - 1
      9 ( +1 - 2 - 3 + 4 + 5 - 6) = 8  (9 6)

          + 1 - 1 + 1
      10 ( -1 + 2 + 3 - 4 - 5 + 6) = 11  (10 6)
     */

    // Accepted After contest
    void solve(long x, long n) {
        // tr(x, n);
        long last = n;
        long res = x;
        if (x % 2 != 0 && n % 2 == 1) {
            long pair = (n - 1) / 2;
            if (pair % 2 != 0) res--;
            // tr("pair", pair, "res", res);
            res += res % 2 == 0 ? -last : last;
        } else if (x % 2 == 0 && n % 2 == 1) {
            long pair = (n - 1) / 2;
            if (pair % 2 != 0) res++;
            // tr("pair", pair, "res", res);
            res += res % 2 == 0 ? -last : last;
        } else if (x % 2 != 0 && n % 2 == 0) {
            long pair = n / 2;
            if (pair % 2 != 0) res--;
        } else if (x % 2 == 0 && n % 2 == 0) {
            long pair = n / 2;
            if (pair % 2 != 0) res++;
        }
        pr(res);
    }

    void solve1(long x, long n) {
        long res = x;
        for (int i = 1; i <= n; i++) {
            long add = res % 2 == 0 ? -i : i;
            res += add;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long x = fs.nextLong(), n = fs.nextLong();
            solve(x, n);
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

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
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