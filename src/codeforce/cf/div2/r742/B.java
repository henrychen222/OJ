/**
 * 09/05/21 evening
 * https://codeforces.com/contest/1567/problem/B
 */

package codeforce.cf.div2.r742;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted https://codeforces.com/contest/1567/submission/128001415
    // reference: cuiaoxiang
    void solve(int a, int b) {
        int r = a % 4;
        int res = 0;
        for (int x = 0; x < r; x++) res ^= a - 1 - x;
        if (res == b) {
            pr(a);
        } else {
            if ((res ^ b) == a) {
                pr(a + 2);
            } else {
                pr(a + 1);
            }
        }
    }

    // WA
    void solve1(int a, int b) {
        if (a % 2 == 0) {
            if (b % 2 == 0) {
                pr(a + 1);
            } else {
                pr(a);
            }
        } else {
            if (b % 2 == 0) {
                pr(a + 1);
            } else {
                pr(a + 2);
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            solve(a, b);
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
        new B().run();
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