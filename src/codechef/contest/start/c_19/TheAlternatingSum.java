/**
 * 12/11/21 morning 06/26/22 afternoon complete
 * https://www.codechef.com/START19C/problems/ALTERSUM
 */
package codechef.contest.start.c_19;

import java.util.*;
import java.io.*;

class TheAlternatingSum {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67692420
    // reference: https://discuss.codechef.com/t/altersum-editorial/96903
    void solve(int n, int[] a) {
        pr(maximumAlternatingSum(a));
    }

    long maximumAlternatingSum(int[] a) {
        int n = a.length;
        long suf = 0, pref = 0, maxPref = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                suf += a[i];
            } else {
                suf -= a[i];
            }
        }
        long res = suf;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                suf -= a[i];
                pref += a[i];
            } else {
                suf += a[i];
                pref -= a[i];
            }
            if (i % 2 != n % 2) {
                res = Math.max(res, pref - suf);
                maxPref = Math.max(maxPref, pref);
            } else {
                res = Math.max(res, 2 * maxPref - pref - suf);
            }
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
        new TheAlternatingSum().run();
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