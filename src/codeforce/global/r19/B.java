/**
 * 02/11/22 moring
 * https://codeforces.com/problemset/problem/427/B
 */
package codeforce.global.r19;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, int[] a) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sub = Arrays.copyOfRange(a, i, j + 1);
                long v = cal(sub);
                // tr(sub, v);
                res += v;
            }
        }
        pr(res);
    }

    long cal(int[] a) {
        int n = a.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += a[i] == 0 ? 1 : 0;
//        tr(n, sum);
        return n + sum;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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

