/**
 * 05/01/22 morning
 * https://www.codechef.com/COOK141C/problems/POOK
 */
package codechef.contest.cook.c_141;

import java.util.*;
import java.io.*;

class GamePooks {
    static PrintWriter pw;

    /*
      n = 3      n = 4        n = 5           n = 6            n = 7             n = 8
        2          4            5               6                7                 8

      p * *      * p * *     p * * * *      * p * * * *      p * * * * * *      * p * * * * * *
      * * p      * * * p    * * p * *       * * * p * *      * * p * * * *      * * * p * * * *
      * * *      p * * *     * * * * p      * * * * * p      * * * * p * *      * * * * * p * *
                 * * p *     * p * * *      p * * * * *      * * * * * * p      * * * * * * * p
                             * * * p *      * * p * * *      * p * * * * *      p * * * * * * *
                                            * * * * p *      * * * p * * *      * * p * * * * *
                                                             * * * * * p *      * * * * p * * *
                                                                                * * * * * * p *
     */
    // Accepted
    void solve(int n) {
        if (n == 1 || n == 2) {
            pr(1);
            return;
        }
        if (n == 3) {
            pr(n - 1);
            return;
        }
        // pr(n % 2 == 0 ? n - 1 : n);
        pr(n);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
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
        new GamePooks().run();
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