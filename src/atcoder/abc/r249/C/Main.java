/**
 * 04/23/22 morning
 * https://atcoder.jp/contests/abc249/tasks/abc249_c
 */
package atcoder.abc.r249.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    /*
     Accepted --- https://atcoder.jp/contests/abc249/submissions/31212765 bitmask
     reference:
     https://atcoder.jp/contests/abc249/submissions/31177935
     https://atcoder.jp/contests/abc249/submissions/31175871
     https://atcoder.jp/contests/abc249/submissions/31176960
     */
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        int res = 0;
        for (int i = 0; i < 1 << n; i++) {
            long[] sum = new long[26];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (char c : g[j]) {
                        sum[c - 'a']++;
                    }
                }
            }
            int ct = 0;
            for (int j = 0; j < 26; j++) {
                if (sum[j] == k) ct++;
            }
            res = Math.max(res, ct);
        }
        pr(res);
    }

    // WA https://atcoder.jp/contests/abc249/submissions/31201221
    private void run1() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        long[] sum = new long[26];
        for (int i = 0; i < n; i++) {
            char[] a = fs.next().toCharArray();
            int[] f = new int[26];
            for (char c : a) f[c - 'a']++;
            for (int j = 0; j < 26; j++) {
                sum[j] += f[j];
            }
        }
        // tr(sum);
        long res = 0;
        for (int i = 0; i < 26; i++) {
            if (sum[i] >= k) {
                res++;
            }
        }
        pr(res);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}