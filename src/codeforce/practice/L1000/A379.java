/**
 * 10/11/21 afternoon   10/11/21 evening fix
 * https://codeforces.com/problemset/problem/379/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/problemset/submission/379/131593532
public class A379 {

    static PrintWriter pw;

    /*
     123 / 5 = 24   rest: 3
     24  / 5 = 4    rest: 4
     4 + 4 + 3 = 11

     1000 / 4 = 250  rest: 0
     250 / 4 = 62    rest: 2
     62 / 4 = 15     rest: 2
     15 / 4 = 3      rest: 3
     total rest 10
     */
    int res;

    void solve(int a, int b) {
        res = a;
        dfs(a, b, 0);
        pr(res);
    }

    void dfs(int a, int b, int rest) {
        // tr(res, a, b, rest);
        while (a / b != 0) {
            rest += a % b;
            a /= b;
            res += a;
            // tr(res, a);
        }
        if (a + rest >= b) {
            // tr("next", a, rest);
            dfs(a + rest, b, 0);
        } else {
            // tr("stop", a, rest);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int a = fs.nextInt();
        int b = fs.nextInt();
        solve(a, b);
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
        new A379().run();
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