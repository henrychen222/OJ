/**
 * 06/16/22 morning
 * https://codeforces.com/contest/1694/problem/C
 */
package codeforce.cf.div2.r800;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1694/submission/160892421
    // reference
    void solve(int n, int[] a) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum < 0) {
                pr("No");
                return;
            } else if (sum == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] != 0) {
                        pr("No");
                        return;
                    }
                }
                break;
            }
        }
        pr(sum == 0 ? "Yes" : "No");
    }

    /////////////////////////////////////////////////////////////////
    // WA
    void solve1(int n, int[] a) {
        if (n == 1) {
            pr(a[0] == 0 ? "Yes" : "No");
            return;
        }
        int max = Integer.MIN_VALUE;
        long left = 0, right = 0;
        for (int x : a) {
            if (x < 0) {
                left -= x;
            } else if (x > 0) {
                right += x;
            }
            max = Math.max(max, Math.abs(x));
        }
        // tr(a, left, right);
        if (left != right) {
            pr("No");
            return;
        }
        int end = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != 0) {
                end = i;
                break;
            }
        }
        int m = end + 1, h = m / 2;
        List<Long> d = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            long e = (long) Math.abs(a[i]) + Math.abs(a[m - i - 1]);
            d.add(e);
        }
        if (m % 2 != 0) d.add((long) Math.abs(a[h]));
        // tr(a, end, "max", max, d);
        pr(isDescending(d) ? "Yes" : "No");
    }

    boolean isDescending(List<Long> a) {
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1) <= a.get(i)) return false;
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}