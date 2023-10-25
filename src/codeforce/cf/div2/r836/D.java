/**
 * 12/01/22 morning
 * https://codeforces.com/contest/1758/problem/D
 */
package codeforce.cf.div2.r836;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1758/submission/183509321
    // reference: https://codeforces.com/blog/entry/109438
    void solve(int n) {
        List<Integer> res = new ArrayList<>();
        if (n % 2 == 0) {
            for (int i = n / 2; i <= n / 2 + n; i++) {
                if (i != n) res.add(i);
            }
        } else {
            for (int i = n / 2 + 3; i < n / 2 + 3 + n; i++) res.add(i);
            res.set(0, res.get(0) - 1);
            res.set(res.size() - 1, res.get(res.size() - 1) + 1);
            res.set(res.size() - 2, res.get(res.size() - 2) + 1);
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}