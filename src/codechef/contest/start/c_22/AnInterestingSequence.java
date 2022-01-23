/**
 * 01/19/22 morning
 * https://www.codechef.com/START22C/problems/INTSEQ
 */
package codechef.contest.start.c_22;

import java.util.*;
import java.io.*;

class AnInterestingSequence {
    static PrintWriter pw;

    /*
      k = 6
      [3, 1]  [3, 4] no
      [3, 2]  [3, 5] no

      k = 10
      [5, 1]  [5, 6]  no
      [5, 2]  [5, 7]  no
      [5, 3]  [5, 8]  no

      k = 16
      [8, 4, 2, 1]   [8, 12, 14, 15]
     */
    // Accepted
    void solve(int k) {
       long res = 0;
       while (k % 2 == 0) {
           k /= 2;
           res++;
       }
       pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int k = fs.nextInt();
            solve(k);
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
        new AnInterestingSequence().run();
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