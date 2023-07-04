/**
 * 07/03/23 night
 * https://codeforces.com/problemset/problem/699/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B699 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/699/212050840
    // hint: https://codeforces.com/blog/entry/46148
    void solve(int n, int m, char[][] g) {
        int tot = 0;
        int[] row = new int[n], col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
                    row[i]++;
                    col[j]++;
                    tot++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                if (g[i][j] == '*') cnt--;
                cnt += row[i] + col[j]; // 十字count
                if (cnt == tot) {
                    pr("YES");
                    pr((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        pr("NO");
    }

    // TLE https://codeforces.com/problemset/submission/699/212046987
    void solve2(int n, int m, char[][] g) {
        int tot = 0;
        Set<Integer> row = new HashSet<>(), col = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
                    row.add(i);
                    col.add(j);
                    tot++;
                }
            }
        }
        if (tot == 0) {
            pr("YES");
            pr(1 + " " + 1);
            return;
        }
        int max = n + m - 1;
        if (tot > max) {
            pr("NO");
            return;
        }
        // tr(row, col);
        for (int i : row) {
            for (int j : col) {
                int cnt = g[i][j] == '*' ? 1 : 0; // 十字搜索
                for (int k = 0; k < m; k++) {
                    if (k != j && g[i][k] == '*') cnt++;
                }
                for (int k = 0; k < n; k++) {
                    if (k != i && g[k][j] == '*') cnt++;
                }
                if (cnt == tot) {
                    pr("YES");
                    pr((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        pr("NO");
    }

    // TLE https://codeforces.com/problemset/submission/699/212046167
    void solve1(int n, int m, char[][] g) {
        int tot = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') tot++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = g[i][j] == '*' ? 1 : 0; // 十字搜索
                for (int k = 0; k < m; k++) {
                    if (k != j && g[i][k] == '*') cnt++;
                }
                for (int k = 0; k < n; k++) {
                    if (k != i && g[k][j] == '*') cnt++;
                }
                if (cnt == tot) {
                    pr("YES");
                    pr((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
        pr("NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        solve(n, m, g);
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
        new B699().run();
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