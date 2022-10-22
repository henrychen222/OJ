/**
 * 06/08/22 morning
 * https://www.codechef.com/START42C/problems/MINORMAX
 */
package codechef.contest.start.c_42;

import java.util.*;
import java.io.*;

class MinimumMaximum {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/66435387
    // reference: https://discuss.codechef.com/t/minormax-editorial/101447
    void solve(int n, int[] b) {
        int min = b[0], max = b[0];
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (b[i] <= min) {
                min = b[i];
            } else if (b[i] >= max) {
                max = b[i];
            } else {
                ok = false;
                break;
            }
        }
        pr(ok ? "YES" : "NO");
    }

    /////////////////////////////////////////////////////////
    void solve1(int n, int[] b) {
        int[] preMax = preMax(b), preMin = preMin(b);
        // tr(preMax, preMin);
        if (preMaxCheck(b, preMax) || preMinCheck(b, preMin)) {
            pr("YES");
        } else {
            pr("NO");
        }
    }

    boolean preMaxCheck(int[] t, int[] pre) {
        int n = pre.length;
        for (int i = 0; i < n; i++) {
            if (t[i] < pre[i]) return false;
        }
        return true;
    }

    boolean preMinCheck(int[] t, int[] pre) {
        int n = pre.length;
        for (int i = 0; i < n; i++) {
            if (t[i] > pre[i]) return false;
        }
        return true;
    }

    int[] preMax(int[] a) {
        int n = a.length, max = Integer.MIN_VALUE;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            pre[i] = max;
        }
        return pre;
    }

    int[] preMin(int[] a) {
        int n = a.length, min = Integer.MAX_VALUE;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            pre[i] = min;
        }
        return pre;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] b = fs.readArray(n);
            solve(n, b);
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
        new MinimumMaximum().run();
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
