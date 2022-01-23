/**
 * 01/17/22 afternoon
 * https://codeforces.com/problemset/problem/622/B
 */
package codeforce.practice.L900;

import java.util.*;
import java.io.*;

public class B622 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/622/143156320
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String[] a = fs.next().split(":");
        int sh = Integer.parseInt(a[0]), sm = Integer.parseInt(a[1]);
        int t = fs.nextInt();
        t %= 24 * 60;
        int h = t / 60, m = t % 60;
        // tr(sh, h, sm, m);
        if (sm + m < 60) {
            sm += m;
        } else {
            sm = sm + m - 60;
            h++;
        }
        // tr(sh, h, sm, m);
        if (sh + h < 24) {
            sh += h;
        } else {
            sh = sh + h - 24;
        }
        String s1 = sh + "", s2 = sm + "";
        if (s1.length() < 2) s1 = '0' + s1;
        if (s2.length() < 2) s2 = '0' + s2;
        pr(s1 + ":" + s2);
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
        new B622().run();
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

