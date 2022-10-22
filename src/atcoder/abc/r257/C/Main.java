/**
 * 06/25/22 morning
 * https://atcoder.jp/contests/abc257/tasks/abc257_c
 *
 * similar problem:
 * https://leetcode.com/problems/number-of-flowers-in-full-bloom/
 *
 * sweep line
 */
package atcoder.abc.r257.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc257/submissions/32752658
    // reference: https://atcoder.jp/contests/abc257/submissions/32713325
    void solve(int n, char[] s, int[] w) {
        int[][] d = new int[n][];
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                d[i] = new int[]{w[i], 1};
            } else {
                d[i] = new int[]{w[i], -1};
                h++;
            }
        }
        Arrays.sort(d, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return x[1] - y[1];
        });
        // tr(d, h);
        int res = h;
        for (int[] e : d) {
            h += e[1];
            res = Math.max(res, h);
        }
        pr(res);
    }

    // WA
    void solve1(int n, char[] s, int[] w) {
        TreeSet<Integer> child = new TreeSet<>(), adult = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                child.add(w[i]);
            } else {
                adult.add(w[i]);
            }
        }
        if (child.size() == 0 || adult.size() == 0) {
            pr(n);
            return;
        }
        int maxChild = child.last(), minAdult = adult.first();
//        int res1 = correct(maxChild + 1, s, w), res2 = correct(minAdult, s, w);
//        // tr("maxChild", maxChild + 1, res1, "minAdult", minAdult, res2);
//        pr(Math.max(res1, res2));

        tr(child, adult);
        if (maxChild < minAdult) {
            pr(n);
        } else {
            int res = 0;
            for (int x = minAdult; x <= maxChild + 1; x++) {
                int cnt = correct(x, s, w);
                // tr(x, cnt);
                res = Math.max(res, cnt);
            }
            pr(res);
        }
    }

    int correct(int x, char[] s, int[] w) {
        int n = s.length;
        char child = '0', adult = '1';
        char[] judge = new char[n];
        for (int i = 0; i < n; i++) {
            if (w[i] < x) {
                judge[i] = child;
            } else {
                judge[i] = adult;
            }
        }
        // tr("judge", judge, "read", s);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (judge[i] == s[i]) res++;
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] s = fs.next().toCharArray();
        int[] w = fs.readArray(n);
        solve(n, s, w);
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