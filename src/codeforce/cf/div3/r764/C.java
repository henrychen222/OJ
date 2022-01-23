/**
 * 01/10/22 morning
 * https://codeforces.com/contest/1624/problem/C
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (x > n) {
                int cur = x;
                while (cur > 0) {
                    if (cur <= n && !ts.contains(cur)) {
                        used[i] = true;
                        ts.add(cur);
                        break;
                    }
                    cur /= 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (x <= n) {
                int cur = x;
                while (cur > 0) {
                    if (cur <= n && !ts.contains(cur)) {
                        used[i] = true;
                        ts.add(cur);
                        break;
                    }
                    cur /= 2;
                }
            }
        }
        // tr(ts);
        pr(ok(n, ts) ? "YES" : "NO");
    }

    // WA
    void solve1(int n, int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) {
            // tr(x, ts);
            if (x <= n) {
                // tr("add1", x);
                ts.add(x);
            } else {
                int cur = x;
                while (cur > 0) {
                    if (cur <= n && !ts.contains(cur)) {
                        // tr("add2", cur);
                        ts.add(cur);
                        break;
                    }
                    cur /= 2;
                }
            }
        }
        // tr(ts);
        pr(ok(n, ts) ? "YES" : "NO");
    }

    boolean ok(int n, TreeSet<Integer> ts) {
        if (ts.size() != n) return false;
        int i = 1;
        for (int x : ts) {
            if (x != i) {
                return false;
            }
            i++;
        }
        return true;
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

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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