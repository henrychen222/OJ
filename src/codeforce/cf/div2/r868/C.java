/**
 * 04/27/23 morning
 * https://codeforces.com/contest/1823/problem/C
 */
package codeforce.cf.div2.r868;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1823/submission/203721577
    // reference: kmjp
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> all = new TreeMap<>();
        for (int x : a) {
            TreeMap<Integer, Integer> m = factorization(x);
            // tr(all, m);
            mergeMap(all, m);
        }
        // tr(all);
        int res = 0, left = 0;
        for (int x : all.keySet()) {
            int occ = all.get(x);
            res += occ / 2;
            left += occ % 2;
        }
        pr(res + left / 3);
    }

    void mergeMap(TreeMap<Integer, Integer> res, TreeMap<Integer, Integer> source) {
        for (int k : source.keySet()) res.merge(k, source.get(k), Integer::sum);
    }

    // 因式分解
    TreeMap<Integer, Integer> factorization(int n) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                m.merge(i, 1, Integer::sum);
            }
        }
        if (n > 1) m.merge(n, 1, Integer::sum);
        return m;
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
        new C().run();
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