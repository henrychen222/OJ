/**
 * 05/03/22 morning
 * https://codeforces.com/problemset/problem/405/B
 *
 * similar problem:
 * https://leetcode.com/problems/push-dominoes/
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B405 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/405/155779511
    // reference: nevergiveup
    void solve(int n, char[] s) {
        int[] leftR = new int[n], rightL = new int[n];
        Arrays.fill(leftR, -1);
        Arrays.fill(rightL, -1);
        int still = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '.') { // record each '.' closest leftR and rightL position
                int l, r;
                for (l = i - 1; l >= 0 && s[l] == '.'; l--) ;
                for (r = i + 1; r < n && s[r] == '.'; r++) ;
                if (l >= 0 && s[l] == 'R') leftR[i] = l;
                if (r < n && s[r] == 'L') rightL[i] = r;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] == '.') {
                if (leftR[i] == -1) {
                    if (rightL[i] == -1) { // no left R and right L, stills
                        still++;
                    }
                } else {
                    if (rightL[i] == -1) {
                    } else { // has both left R and right L
                        if (i - leftR[i] == rightL[i] - i) { // keep balance, still
                            still++;
                        }
                    }
                }
            }
        }
        pr(still);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] s = fs.next().toCharArray();
        solve(n, s);
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
        new B405().run();
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