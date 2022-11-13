// 11/04/22 night
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class C159_1 {
    static PrintWriter pw;

    /*
     Accepted --- https://codeforces.com/contest/159/submission/179352233 (reference: uwi)

     TLE: https://codeforces.com/contest/159/submission/179351079 (String issue, needs use StringBuilder)
     */
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int k = fs.nextInt();
        char[] s = fs.next().toCharArray();
        int[] f = new int[26];
        Fenwick[] g = new Fenwick[26];
        boolean[][] keep = new boolean[26][];
        for (char c : s) f[c - 'a']++;
        // tr(s, f);
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                int len = f[i] * k;
                g[i] = new Fenwick(len + 1);
                for (int j = 0; j < len; j++) {
                    g[i].update(j, 1);
                }
                keep[i] = new boolean[len];
                Arrays.fill(keep[i], true);
            }
        }
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int p = fs.nextInt();
            char c = fs.nextChar();
            int idx = g[c - 'a'].getKth(p - 1) + 1;
            g[c - 'a'].update(idx, -1);
            keep[c - 'a'][idx] = false;
        }
        // String res = "";
        StringBuilder res = new StringBuilder();
        int[] p = new int[26];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < s.length; j++) {
                if (keep[s[j] - 'a'][p[s[j] - 'a']]) {
                    // res += s[j]; // TLE
                    res.append(s[j]);
                }
                p[s[j] - 'a']++;
            }
        }
        pr(res);
    }

    class Fenwick {
        int n;
        int[] a;

        Fenwick(int n) {
            this.n = n;
            a = new int[n];
        }

        long query(int i) {
            long sum = 0;
            for (i++; i > 0; i = parent(i)) sum += a[i];
            return sum;
        }

        void update(int i, int v) {
            for (i++; i < n; i = next(i)) a[i] += v;
        }

        int parent(int x) {
            return x - lowestOneBit(x);
        }

        int next(int x) {
            return x + lowestOneBit(x);
        }

        int lowestOneBit(int x) {
            return x & -x;
        }

        int getKth(int v) {
            int i = 0;
            for (int b = Integer.highestOneBit(n); b != 0 && i < n; b >>= 1) {
                if (i + b < n) {
                    int t = i + b;
                    if (v >= a[t]) {
                        i = t;
                        v -= a[t];
                    }
                }
            }
            return v != 0 ? -(i + 1) : i - 1;
        }

        void reset() {
            Arrays.fill(a, 0);
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
        new C159_1().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}