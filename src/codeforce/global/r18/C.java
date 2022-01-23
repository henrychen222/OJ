/**
 * 12/24/21 morning
 * https://codeforces.com/contest/1615/problem/C
 */
package codeforce.global.r18;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1615/submission/140513409
    // reference neal
    void solve(int n, char[] a, char[] b) {
        int same = 0, diff = 0;
        int[] sameCnt = {0, 0}, diffCnt = {0, 0};
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                same++;
                sameCnt[a[i] - '0']++;
            } else {
                diff++;
                diffCnt[a[i] - '0']++;
            }
        }
        // tr(same, sameCnt, diff, diffCnt);
        int res = Integer.MAX_VALUE;
        if (same % 2 != 0 && sameCnt[1] - sameCnt[0] == 1) res = Math.min(res, same);
        if (diff % 2 == 0 && diffCnt[1] == diffCnt[0]) res = Math.min(res, diff);
        pr(res == Integer.MAX_VALUE ? -1 : res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] a = fs.next().toCharArray(), b = fs.next().toCharArray();
            solve(n, a, b);
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
        new C().run();
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