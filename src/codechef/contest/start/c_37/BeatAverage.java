/**
 * 05/04/22 morning
 * https://www.codechef.com/START37C/problems/ABOVEAVG
 */
package codechef.contest.start.c_37;

import java.util.*;
import java.io.*;

class BeatAverage {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/64244502
    void solve3(int n, int m, int x) {
        long tot = (long) x * n;
        if (x < m) {
            pr(tot / (x + 1));
        } else {
            pr(0);
        }
    }

    /*
     WA
     https://www.codechef.com/viewsolution/64198187
     https://www.codechef.com/viewsolution/64202253
     https://www.codechef.com/viewsolution/64226613
     https://www.codechef.com/viewsolution/64241972
     https://www.codechef.com/viewsolution/64242973
     https://www.codechef.com/viewsolution/64243153
     https://www.codechef.com/viewsolution/64245589  (change ans to double AC another one)
     https://www.codechef.com/viewsolution/64245788

     51 50 49  (1)
     52 50 48  (1)
     51 51 48  (2)

     (5 40 1)
     0 0 0 0 5 (wrong)
     0 0 0 2 3 (2)

     50 50 50 50 50 50 50 50 50 40

     n  average/x                                                 ans
     4    50        51 51 51 47     3 * 51 +  1 * 47 (50 - 3)      3
     51   50        51 ....... 0    50 * 51 + 1 * 0  (50 - 50)     50

     52   50                        50 * 51 + 2 * 25             50

     ans * (x + 1) + (n - ans) * v = tot   v : [0, m]   ans: [0, n]
     ans * x + ans + n * v - ans * v = tot
     ans * (x + 1 - v) = tot - n * v

     */
    void solve(int n, int m, int x) {
        long tot = (long) x * n, res = 0;
        // tr(n, "average", x, "range", 0, m);
//        if (x < m && x > 1) {
//            pr(n - 1);
//        } else {
//            pr(0);
//        }

//        for (int v = 0; v <= m; v++) {
//            for (int ans = 0; ans <= n; ans++) {
//                long ATot = (long) ans * (x + 1), failTot = (long) (n - ans) * v;
//                if (ATot + failTot == tot && x + 1 <= m) {
//                    // tr("A", ans, x + 1, "fail", n - ans, v);
//                    res = Math.max(res, ans);
//                }
//            }
//        }
        for (int v = 0; v <= m; v++) {
            long t1 = tot - (long) n * v;
            int t2 = x + 1 - v;
            if (t2 != 0) {
                // long ans = t1 / t2;
                double ans = (double) t1 / t2; // issue here
                double judge = ans * (x + 1) + (n - ans) * v;
                if (judge == tot && ok(ans, n, m, x)) {
                    // tr("judge", judge, "ans", ans, (long) ans, x + 1, "fail", n - ans, v);
                    res = Math.max(res, (long) ans);
                }
            }
        }
        pr(res);
    }

    boolean ok(double ans, int n, int m, int x) {
        return inRange(x + 1, m) && inRangeCnt(ans, n) && inRangeCnt(n - ans, n);
    }

    boolean inRange(int v, int m) {
        return v >= 0 && v <= m;
    }

    boolean inRangeCnt(double cnt, int n) {
        return cnt >= 0 && cnt <= n;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
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
        new BeatAverage().run();
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
