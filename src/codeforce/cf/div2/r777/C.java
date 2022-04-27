/**
 * 03/11/22 afternoon
 * https://codeforces.com/contest/1647/problem/C
 */
package codeforce.cf.div2.r777;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1647/submission/149343811
    // reference: cuiaoxiang + https://codeforces.com/blog/entry/100780
    void solve(int n, int m, char[][] g) {
        if (g[0][0] == '1') { // if the upper left cell is painted black, then we cannot paint it that way
            pr(-1);
            return;
        }
        // paint from bottom right -> top left
        List<int[]> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (g[i][j] == '1') { // Let the cell (i, j) be colored black
                    if (j >= 1) { // j>= 1, paint the rectangle (i,j−1), (i,j)
                        res.add(new int[]{i, j - 1, i, j});
                    } else { // j = 0 color the rectangle (i-1,j)
                        res.add(new int[]{i - 1, j, i, j});
                    }
                }
            }
        }
        pr(res.size());
        for (int[] e : res) pr((e[0] + 1) + " " + (e[1] + 1) + " " + (e[2] + 1) + " " + (e[3] + 1));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            char[][] g = new char[n][];
            for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
            solve(n, m, g);
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