/**
 * 09/29/22 morning
 * https://codeforces.com/contest/1739/problem/B
 */
package codeforce.ecf.r136;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // d[i] = a[i] - a[i-1] => a[i] = d[i] + a[i-1]
    // d[i] = a[i-1] - a[i] => a[i] = a[i-1] - d[i];
    void solve(int n, int[] d) {
        int[] a = new int[n];
        a[0] = d[0];
        for (int i = 1; i < n; i++) {
            int v1 = d[i] + a[i - 1], v2 = a[i - 1] - d[i];
            if (v1 >= 0 && v2 >= 0 && v1 != v2) {
                pr(-1);
                return;
            }
            if (v1 >= 0) a[i] = v1;
            if (v2 >= 0) a[i] = v2;
        }
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] d = fs.readArray(n);
            solve(n, d);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
