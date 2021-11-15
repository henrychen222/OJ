/**
 * 11/13/21 morning
 * https://atcoder.jp/contests/abc227/tasks/abc227_c
 */
package atcoder.abc.r227.C;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    /**
     * reference:
     * https://atcoder.jp/contests/abc227/submissions/27211499 kmjp  use
     * https://atcoder.jp/contests/abc227/submissions/27213391 cuiaoxiang
     */
    // Accepted --- https://atcoder.jp/contests/abc227/submissions/27239912
    void solve(long n) {
        long res = 0;
        for (long a = 1; a * a * a <= n; a++) {
            for (long b = a; a * b * b <= n; b++) {
                long c = n / (a * b); // maxC
                res += c - b + 1; // (a, b) 固定 每次加上c的种类  maxC - minC + 1
            }
        }
        pr(res);
    }

    // WA TLE
    void solve1(long n) {
        Set<String> se = new HashSet<>();
        for (long a = 1; a <= n / 3; a++) {
            for (long b = a; a * b <= n / 3 * 2; b++) {
                for (long c = b; a * b * c <= n; c++) {
                    String k = a + " " + b + " " + c;
                    se.add(k);
                }
            }
        }
        pr(se.size());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        solve(n);
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