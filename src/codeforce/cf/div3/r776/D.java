/**
 * 03/08/22 morning
 * https://codeforces.com/contest/1650/problem/D
 */
package codeforce.cf.div3.r776;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1650/submission/148918873 (Heltion)
    // Accepted --- https://codeforces.com/contest/1650/submission/148919052 (wifi)
    void solve(int n, int[] a) {
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // tr(a);
            int idx = indexOf(a, i);
            // if (idx != i) res[i] = idx + 1;
            res[i] = (idx + 1) % (i + 1);
            a = rotate(a, idx + 1);
            // tr("rotated", a);
            a = Arrays.copyOfRange(a, 0, a.length - 1);
        }
        // tr(a);
        outputA(res);
    }

    int indexOf(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
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
        new D().run();
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
            for (int i = 0; i < n; i++) a[i] = nextInt() - 1;
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