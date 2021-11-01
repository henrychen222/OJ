/**
 * 09/19/21 morning
 * https://atcoder.jp/contests/arc126/tasks/arc126_a
 */
package atcoder.arc.r126.A;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    long n2, n3, n4, res;

    void solve(long N2, long N3, long N4) {
        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        long ans = 0;
        parse334();
        parse442();
        parse3322();
        parse22222();
        // tr(res);
        ans = Math.max(ans, res);

        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        parse334();
        parse3322();
        parse442();
        parse22222();
        // tr(res);
        ans = Math.max(ans, res);

        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        parse3322();
        parse334();
        parse442();
        parse22222();
        // tr(res);
        ans = Math.max(ans, res);

        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        parse3322();
        parse442();
        parse334();
        parse22222();
        tr(res);
        ans = Math.max(ans, res);

        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        parse442();
        parse3322();
        parse334();
        parse22222();
        // tr(res);
        ans = Math.max(ans, res);

        res = 0;
        n2 = N2; n3 = N3; n4 = N4;
        parse442();
        parse334();
        parse3322();
        parse22222();
        // tr(res);
        ans = Math.max(ans, res);
        pr(ans);
    }

    void parse334() {
        if (n3 >= 2 && n4 >= 1) {
            long cnt = Math.min(n3 / 2, n4);
            // tr("three", n2, n3, n4, "cnt", cnt);
            if (n4 >= cnt) { // 3 3 4
                n4 -= cnt;
                n3 -= 2 * cnt;
                res += cnt;
            }
        }
    }

    void parse3322() {
        if (n3 >= 2 && n2 >= 2) { // 3 3 2 2
            long cnt = Math.min(n3 / 2, n2 / 2);
            if (n2 >= 2 * cnt) {
                n2 -= 2 * cnt;
                n3 -= 2 * cnt;
                res += cnt;
            }
        }
    }

    void parse442() {
        if (n4 >= 2 && n2 >= 1) { // 4 4 2
            long cnt = Math.min(n4 / 2, n2);
            // tr("four", n2, n3, n4, "cnt", cnt);
            if (n2 >= 2 * cnt) {
                n2 -= cnt;
                n4 -= 2 * cnt;
                res += cnt;
            }
        }
    }

    void parse22222() {
        if (n2 >= 5) {
            long cnt = n2 / 5;
            res += cnt;
            n2 -= 5 * cnt;
        }

    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long N2 = fs.nextLong();
            long N3 = fs.nextLong();
            long N4 = fs.nextLong();
            solve(N2, N3, N4);
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
        new Main().run();
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