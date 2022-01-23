// 12/24/21 noon
package codeforce.global.r18;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1615/submission/140511003
// reference: wifi neal tourist
public class B2 {
    static PrintWriter pw;
    private final int N = (int) 2e5 + 1;
    private final int MAX_BIT = 20;

    void solve(int l, int r, int[][] pre) {
        int tot = r - l + 1, maxOne = 0;
        for (int i = 0; i < MAX_BIT; i++) {
            maxOne = Math.max(maxOne, pre[i][r] - pre[i][l - 1]);
        }
        int res = tot - maxOne;
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        int[][] pre = new int[MAX_BIT][N];
        for (int i = 0; i < MAX_BIT; i++) {
            for (int x = 1; x < N; x++) {
                // int bitOfOneJudge = x >> i & 1;
                int bitOfOneJudge = ((x & (1 << i)) > 0) ? 1 : 0; // Accepted --- https://codeforces.com/contest/1615/submission/140516982
                pre[i][x] = pre[i][x - 1] + bitOfOneJudge;
            }
        }
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1], pre);
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
        new B2().run();
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