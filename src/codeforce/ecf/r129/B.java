/**
 * 05/23/22 morning
 * https://codeforces.com/contest/1681/problem/B
 */
package codeforce.ecf.r129;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int m, int[] a, int[] b) {
//        tr(a);
//        for (int x : b) {
//            a = rotate(a, x);
//            tr(a);
//        }
//        pr(a[0]);

        long sum = 0;
        for (int x : b) sum += x;
        int idx = (int) (sum % n);
        pr(a[idx]);
    }


    int[] rotate(int[] a, int cut) {
        int n = a.length;
        int[] l = Arrays.copyOfRange(a, 0, cut), r = Arrays.copyOfRange(a, cut, n);
        int[] res = concat(r, l);
        return res;
    }

    int[] concat(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int p = 0;
        for (int i = 0; i < n; i++) res[p++] = a[i];
        for (int i = 0; i < m; i++) res[p++] = b[i];
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int m = fs.nextInt();
            int[] b = fs.readArray(m);
            solve(n, m, a, b);
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