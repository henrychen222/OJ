/**
 * 02/09/22 morning
 * https://www.codechef.com/START25B/problems/TOWERTOP
 */
package codechef.contest.start.b_25;

import java.util.*;
import java.io.*;

class BuildingTowers {
    static PrintWriter pw;

    // WA Pass 2/3 shit
    // Accepted --- https://www.codechef.com/viewsolution/58142704
    // Accepted --- https://www.codechef.com/viewsolution/58143035 (first version)

    // post:
    // fixed code: https://www.codechef.com/submit/TOWERTOP
    void solve(int x, long m) {
        // long inv = 1, tower = 0, res = 0;  fuck issue here  tower should be 1   (failed case 1 1)
        long inv = 1, tower = 1, res = 0;
        boolean mark = false;
        long step;
        for (step = 0; step < m; step++) {
            if (tower >= x) {
                inv = tower - x;
                tower = x;
                res++;
            } else {
                inv *= 2;
                tower = inv;
            }
            if (inv == 0) {
                mark = true;
                break;
            }
            // tr(inv, tower, res, step);
        }
        long restStep = m - step;
        pr(mark ? res + restStep - 1 : res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int x = fs.nextInt();
            long m = fs.nextLong();
            solve(x, m);
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
        new BuildingTowers().run();
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