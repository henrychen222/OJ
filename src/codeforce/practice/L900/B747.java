/**
 * 01/20/22 evening
 * https://codeforces.com/problemset/problem/747/B
 */
package codeforce.practice.L900;

import java.util.*;
import java.io.*;

public class B747 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/747/143465684
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] a = fs.next().toCharArray();
        int[] f = new int[26];
        for (char c : a) {
            if (c != '?') {
                f[c - 'A']++;
            }
        }
        int max = 0;
        for (int occ : f) max = Math.max(max, occ);
        if (max * 4 > n || n % 4 != 0) {
            pr("===");
        } else {
            int len = Math.max(max, n / 4);
            String need = "";
            for (int i = 0; i < 26; i++) {
                char c = (char) ('A' + i);
                if (c == 'A' || c == 'C' || c == 'G' || c == 'T') {
                    need += (c + "").repeat(len - f[i]);
                }
            }
            // tr("len", len, "need", need);
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == '?') {
                    a[i] = need.charAt(p++);
                }
            }
            pr(new String(a));
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
        new B747().run();
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

