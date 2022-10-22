/**
 * 05/24/22 afternoon
 * https://codeforces.com/problemset/problem/1140/B
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class B1140 {
    static PrintWriter pw;

    // Accepted
    // reference: https://codeforces.com/blog/entry/66147
    void solve(int n, char[] s) {
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) { // must be removed so that the first symbol becomes >
            if (s[i] == '>') {
                break;
            } else {
                left++;
            }
        }
        for (int i = n - 1; i >= 0; i--) { // must be removed so that the last symbol becomes <
            if (s[i] == '<') {
                break;
            } else {
                right++;
            }
        }
        pr(Math.min(left, right));
    }

    // WA
    void solve1(int n, char[] s) {
        if (n == 1 || s[0] == '>' || s[n - 1] == '<') {
            pr(0);
            return;
        }
        pr(1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            solve(n, s);
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
        new B1140().run();
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