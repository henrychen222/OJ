/**
 * 03/31/22 morning
 * https://codeforces.com/contest/1660/problem/A
 */
package codeforce.cf.div3.r780;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted
    void solve(int a, int b) {
        // test(a, b);
        if (a == 0) {
            pr(1);
        } else {
            long res = a + 2L * b;
            pr(res + 1);
        }
    }

    void test(int a, int b) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x = 0; x <= a; x++) {
            for (int y = b; y <= b; y++) {
                int v = x + 2 * y;
                tr(x, y, v);
                // ts.add(v);
            }
        }
        // tr(ts);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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