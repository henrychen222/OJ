/**
 * 11/05/21 evening
 * https://codeforces.com/problemset/problem/118/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B118 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/118/134443231
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int fn = 2 * n + 1 + 2 * n;
        String[] res = new String[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = "";
            for (int x = 0; x <= i; x++) {
                s += x;
                s += " ";
            }
            for (int x = i - 1; x >= 0; x--) {
                s += x;
                if (x != 0) s += " ";
            }
            if (i == 0) s = s.substring(0, 1);
            int rest = fn - s.length();
            int h = rest / 2;
            s = " ".repeat(h) + s;
            res[i] = s;
        }
        // tr(res);
        for (String s : res) pr(s);
        for (int i = res.length - 2; i >= 0; i--) pr(res[i]);
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
        new B118().run();
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