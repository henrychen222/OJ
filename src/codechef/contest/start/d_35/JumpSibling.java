/**
 * 04/20/22 noon
 * https://www.codechef.com/START35D/problems/JS
 * <p>
 * read:
 * https://www.geeksforgeeks.org/program-to-find-parity/
 * https://stackoverflow.com/questions/47444058/which-is-the-correct-way-to-determine-if-two-numbers-have-the-same-parity
 * https://www.geeksforgeeks.org/finding-the-parity-of-a-number-efficiently/
 */
package codechef.contest.start.d_35;

import java.util.*;
import java.io.*;

class JumpSibling {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/63349347
    // reference: https://discuss.codechef.com/t/js-editorial/100744
    void solve(int n, int[] a) {
        a = Arrays.stream(a).map(x -> x % 2).toArray();
        int first = a[0], last = a[n - 1];
        int[] pre = new int[n + 1], suf = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (a[i] == first) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = pre[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == last) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = suf[i + 1];
            }
        }
//        if (first == last) {
//            pr(pre[n - 1]);
//            return;
//        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] == first) {
                res = Math.min(res, pre[i] + suf[i + 1]);
            }
        }
        pr(res);
    }

    /////////////////////////////////////////////////////////////////
    // WA
    void solve2(int n, int[] a) {
        // tr(n, a);
        if (a[0] == 1) {
            pr(a[n - 1] % 2 == 0 ? 2 : 1);
            return;
        }
        if (isSameParity(a[0], a[n - 1])) {
            pr(1);
        } else {
            pr(2);
        }
    }

    // WA
    void solve1(int n, int[] a) {
        if (a[n - 1] % 2 == 0) { // last is even
            if (a[0] % 2 == 0) { // first is even
                pr(1);
            } else { // first is odd
                pr(2);
            }
        } else { // last is odd
            if (a[0] % 2 == 0) { // first is even
                pr(2);
            } else { // first is odd
                pr(1);
            }
        }
    }

    boolean isSameParity(int x, int y) {
        // tr("x", Integer.bitCount(x), "y", Integer.bitCount(y));
        return Integer.bitCount(x) % 2 == Integer.bitCount(y) % 2;
        // return Integer.bitCount(x) == Integer.bitCount(y);
    }

//    boolean isSameParity(int x, int y) {
//        return ((x ^ y) & 1) == 0;
//    }

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
        new JumpSibling().run();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
