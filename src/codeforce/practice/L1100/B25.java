/**
 * 01/15/22 afternoon
 * https://codeforces.com/problemset/problem/25/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B25 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/25/142902831
    void solve(int n, String s) {
        String res = "";
        if (n <= 3) {
            pr(s);
            return;
        }
        if (n % 2 == 0 || n % 3 == 0 || n % 3 == 2) {
            int step = n % 2 == 0 ? 2 : 3;
            int i;
            for (i = 0; i < n; i += step) {
                if (i + step > n) break;
                String t = s.substring(i, i + step);
                res += t;
                res += "-";
            }
            String last = s.substring(i);
            if (last.length() == 0) {
                res = res.substring(0, res.length() - 1);
                pr(res);
            } else {
                pr(res + last);
            }
        } else { // 7 13 19 (n % 3 == 1 && n % 2 == 1)
            String first = s.substring(0, 2);
            String second = s.substring(2, 5);
            pw.print(first + '-');
            pw.print(second + '-');
            s = s.substring(5);
            solve(s.length(), s);
        }
//        int each = -1, rest = -1;
//        if (n / 3 >= 2) {
//            each = n / 3;
//            rest = n % 3;
//        } else {
//            each = n / 2;
//            rest = n % 2;
//        }
//        tr(each, rest);
//        String l = s.substring(0, each);
//        String m = s.substring(each, each * 2 + rest);
//        String r = s.substring(each * 2 + rest);
//        String res = l + "-" + m + "-" + r;
//        if (res.charAt(res.length() - 1) == '-') res = res.substring(0, res.length() - 1);
//        pr(res);
    }

    private void run() {
        read_write_file(); // keep this for input output problem
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next();
        solve(n, s);
    }

    boolean ok(String s) {
        return s.length() == 2 || s.length() == 3;
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
        new B25().run();
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
