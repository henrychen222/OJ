/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/C
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1669/submission/154447504
    void solve(int n, int[] a) {
        Set<Integer> odd = new HashSet<>(), even = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.add(a[i]);
            } else {
                odd.add(a[i]);
            }
        }
//        pr(even.size() == 1 && odd.size() == 1 ? "YES" : "NO");
        if (even.size() != 0) {
            if (odd.size() != 0) {
                pr((allEven(even) && allOdd(odd)) ||
                        (allEven(odd) && allOdd(even)) ||
                        (allEven(even) && allEven(odd)) ||
                        (allOdd(even) && allOdd(odd)) ? "YES" : "NO");
            } else {
                pr("YES");
            }
        } else {
            pr("YES");
        }
    }

    boolean allEven(Set<Integer> se) {
        for (int x : se) {
            if (x % 2 != 0) return false;
        }
        return true;
    }

    boolean allOdd(Set<Integer> se) {
        for (int x : se) {
            if (x % 2 == 0) return false;
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