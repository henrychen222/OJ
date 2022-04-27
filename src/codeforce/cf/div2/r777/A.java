/**
 * 03/11/22 morning
 * https://codeforces.com/contest/1647/problem/A
 */
package codeforce.cf.div2.r777;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    /*
     1 * x + 2 * y = n
     */
    // Pretests passed
    void solve(int n) {
        String res = "";
        for (int x = 0; x <= n; x++) {
            for (int y = 0; x + 2 * y <= n; y++) {
                if (x + 2 * y == n) {
                    String s = "";
                    if (x - y == 1) {
                        s = "12".repeat(y) + "1";
                    } else if (y - x == 1) {
                        s = "21".repeat(x) + "2";
                    } else if (x - y == 0) {
                        s = "21".repeat(x);
                    }
                    // tr(x, y, s);
                    if (s.compareTo(res) > 0) res = s;
                }
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new A().run();
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