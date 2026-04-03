/**
 * 07/07/23 morning
 * https://codeforces.com/contest/1846/problem/E1
 */
package codeforce.cf.div3.y2023.r883;

import java.util.*;
import java.io.*;

public class E1 {
    static PrintWriter pw;
    TreeSet<Integer> res;

    // Accepted --- https://codeforces.com/contest/1846/submission/212707945
    void prepare() {
        res = new TreeSet<>();
        for (int k = 2; k * k <= 1e6; k++) {
            int tot = 1 + k, out = k;
            // tr("k", k, tot, out);
            for (int t = 1; ; t++) {
                int add = out * k;
                tot += add;
                out = add;
                res.add(tot);
                if (tot > 1e6) break;
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        prepare();
        while (t-- > 0) {
            int n = fs.nextInt();
            // tr(res.size(), res);
            pr(res.contains(n) ? "YES" : "NO");
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
        new E1().run();
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