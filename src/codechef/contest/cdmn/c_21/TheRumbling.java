/**
 * 09/02/21 morning
 * https://www.codechef.com/CDMN21C/problems/RUMBLING
 */
package codechef.contest.cdmn.c_21;

import java.util.*;
import java.io.*;

class TheRumbling {

    static PrintWriter pw;

    // Accepted
    void solve(int n, String s, long x, long y) {
        // tr(n, s, x, y);
        char[] a = s.toCharArray();
//        char[] b = new char[n];
//        Arrays.fill(b, 'W');
        // tr(b);
        long cost = 0;
        for (int i = 0; i < n; i++) {
            char face = a[i];
            if (face == 'W') continue;
            if (face == 'S') {
                cost += Math.min(x, 3 * y);
                // tr("111", cost, Math.min(x, 3 * y), x, 3 * y);
            } else if (face == 'N') {
                cost += Math.min(3 * x, y);
            } else if (face == 'E') {
                cost += Math.min(2 * x, 2 * y);
            }
        }
        // tr(cost);
        long cur = cost;
        long res = cost;
        for (int i = 0; i < n; i++) {
            char face = a[i];
            // b[i] = 'E';
            long costToW = 0, costToE = 0;
            if (face == 'S') {
                costToW = Math.min(x, 3 * y);
                costToE = Math.min(3 * x, y);
            } else if (face == 'N') {
                costToW = Math.min(3 * x, y);
                costToE = Math.min(x, 3 * y);
            } else if (face == 'E') {
                // tr("EEEEEEEE");
                costToW = Math.min(2 * x, 2 * y);
                costToE = 0;
            } else if (face == 'W') {
                // tr("WWWWWWW");
                costToW = 0;
                costToE = Math.min(2 * x, 2 * y);
            }
            cur = cur - costToW + costToE;
            // cost = cost - costToW + costToE;
            res = Math.min(res, cur);
            // tr(cur, res);
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            long x = fs.nextLong();
            long y = fs.nextLong();
            solve(n, s, x, y);
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
        new TheRumbling().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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