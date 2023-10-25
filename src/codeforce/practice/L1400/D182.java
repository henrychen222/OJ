/**
 * 12/21/22 night
 * https://codeforces.com/problemset/problem/182/D
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class D182 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/182/186322055
    void solve(String s1, String s2) {
        int n;
        String less, more;
        if (s1.length() < s2.length()) {
            n = s1.length();
            less = s1;
            more = s2;
        } else {
            n = s2.length();
            less = s2;
            more = s1;
        }
        TreeSet<Integer> factors = findAllFactors(n);
        int res = 0;
        outer:
        for (int f : factors) {
            if (less.length() % f == 0 && more.length() % f == 0) {
                int l = 0, r = l + f - 1;
                // tr("factor", f, "match", less.substring(0, r + 1));
                while (r < more.length()) {
                    // tr(l, r, more.charAt(l), more.charAt(r));
                    for (int i = l; i <= r; i++) {
                        // longer string
                        char cm = more.charAt(i), cm_expect = more.charAt(i % f);
                        if (cm != cm_expect) continue outer;
                        if (i < n) { // common length  all should equal
                            char cl = less.charAt(i), cl_expect = less.charAt(i % f);
                            if (cl != cl_expect || cl != cm) continue outer;
                        }
                    }
                    l += f;
                    r += f;
                }
                // tr("ok", l, r, f);
                res++;
            }
        }
        pr(res);
    }

    TreeSet<Integer> findAllFactors(int n) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    res.add(i);
                } else {
                    res.add(i);
                    res.add(n / i);
                }
            }
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s1 = fs.next(), s2 = fs.next();
        solve(s1, s2);
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
        new D182().run();
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