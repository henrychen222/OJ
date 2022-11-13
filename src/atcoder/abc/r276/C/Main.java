/**
 * 11/05/22 morning
 * https://atcoder.jp/contests/abc276/tasks/abc276_c
 */
package atcoder.abc.r276.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] p) {
        prev_permutation(p);
        outputA(p);
    }

    boolean prev_permutation(int[] a) {
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] <= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] > a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] p = fs.readArray(n);
        solve(n, p);
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