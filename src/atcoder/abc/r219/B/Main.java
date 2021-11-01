/**
 * 09/18/21 morning
 * https://atcoder.jp/contests/abc219/tasks/abc219_b
 */
package atcoder.abc.r219.B;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted
    void solve(String s1, String s2, String s3, String t) {
        char[] a = t.toCharArray();
        String res = "";
        for (char c : a) {
            if (c == '1') {
                res += s1;
            } else if (c == '2') {
                res += s2;
            } else {
                res += s3;
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s1 = fs.next();
        String s2 = fs.next();
        String s3 = fs.next();
        String t = fs.next();
        solve(s1, s2, s3, t);
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