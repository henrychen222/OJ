/**
 * 12/05/21 morning
 * https://atcoder.jp/contests/arc131/tasks/arc131_a
 */
package atcoder.arc.r131.A;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/arc131/submissions/27737198
    // reference https://atcoder.jp/contests/arc131/submissions/27711926
    void solve(int a, int b) {
        long t = b * 10L / 2;
        long res = 100000000 * t + a;
        pr(res);
    }

    // Accepted --- https://atcoder.jp/contests/arc131/submissions/27737076
    // reference https://atcoder.jp/contests/arc131/submissions/27712184
    void solve2(int a, int b) {
        String s = a + "";
        String hb = (b / 2) + "";
        if (b % 2 == 0) {
            s = hb + "0" + s;
        } else {
            s = hb + "5" + s;
        }
        if (s.charAt(0) == '0') s = s.substring(1);
        // tr(test(Long.parseLong(s), a, b));
        pr(s);
    }

    // TLE
    void solve1(int a, int b) {
        int x = 2 * Math.max(a, b);
        long H = (long) Math.pow(10, 18);
        for (long i = 1; 2 * i * x < H; i++) {
            String s = (i * x) + "";
            String s2 = (2 * i * x) + "";
            if (s.contains(a + "") && s2.contains(b + "")) {
                // tr(s, s2);
                pr(s);
                return;
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int a = fs.nextInt(), b = fs.nextInt();
        solve(a, b);
    }

    boolean test(long x, int a, int b) {
        String sx = x + "", sx2 = (2 * x) + "", sa = a + "", sb = b + "";
        return sx.contains(sa) && sx2.contains(sb);
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