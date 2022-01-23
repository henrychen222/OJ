/**
 * 01/15/22 morning
 * https://codeforces.com/contest/1627/problem/B
 */
package codeforce.cf.div2.r766;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1627/submission/142886622
    // reference: cuiaoxiang secondThread
    void solve(int n, int m) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dis = i + j;
                dis = Math.max(dis, n - 1 - i + j);
                dis = Math.max(dis, i + m - 1 - j);
                dis = Math.max(dis, n - 1 - i + m - 1 - j);
                l.add(dis);
            }
        }
        Collections.sort(l);
        outputL(l);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    /*
     2 * 1  2 * 3
     */
    // Wrong
    void solve1(int n, int m) {
        long tot = (long) n * m;
        int end = n - 1 + m - 1;
        int start = n / 2 + m / 2;
        int x = Math.max(n, m);
        int f = x / 2;
        // tr(start, end);
        for (long k = 1; k < tot; k++) {
            double t = Math.log10(k + 1) / Math.log10(f);
            if (isInteger(t) && k != 1) {
                start++;
            }
            // tr(k, start, t);
            pw.print(start + " ");
        }
        pr("");
    }

    boolean isInteger(double x) {
        return x == (int) x;
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
        new B().run();
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