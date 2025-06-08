/**
 * 01/13/25 noon 06/07/25 night
 * https://codeforces.com/problemset/problem/115/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B115 {
    static PrintWriter pw;

    // (cost 2 hours to fix 2:36AM AC, judge is Moscow time)
    // WA https://codeforces.com/contest/115/submission/323313345
    // Accepted --- https://codeforces.com/problemset/submission/115/323346994
    // Greedy
    void solve(int n, int m, char[][] g) {
        int x = 0, y = 0, moveY = 0, moveX = 0;
        int lastline = -1;
        outer:
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'W') {
                    lastline = i;
                    break outer;
                }
            }
        }
        if (lastline == -1) {
            pr(0);
            return;
        }
        while (x <= lastline) {
            if (x % 2 == 0) { // face Right
                int[] next = getMostRightColCurrentAndBelow(g, x, y);
                if (next[1] != -1) {
                    int disY = next[1] - y;
                    y = next[1];
                    moveY += disY;
//                    tr(x, y, next, new int[]{x, y}, "disY", disY);
                }
            } else {
                int[] next = getMostLeftColCurrentAndBelow(g, x, y);
                if (next[1] != -1) {
                    int disY = y - next[1];
                    y = next[1];
                    moveY += disY;
//                    tr(x, y, next, new int[]{x, y}, "disY", disY);
                }
            }
            x++;
            moveX++;
        }
//        tr(moveX, moveY);
        pr(moveX + moveY - 1);
    }

    int[] getMostLeftColCurrentAndBelow(char[][] g, int x, int y) {
        int n = g.length, m = g[0].length, row = -1, col = Integer.MAX_VALUE;
        for (int j = 0; j <= y; j++) { // col [0...y]
            for (int i = x; i <= x + 1; i++) {
                if (i < n && g[i][j] == 'W') {
                    if (j < col) {
                        row = i;
                        col = j;
                    }
                }
            }
        }
        return col == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{row, col};
    }

    int[] getMostRightColCurrentAndBelow(char[][] g, int x, int y) {
        int n = g.length, m = g[0].length, row = -1, col = Integer.MIN_VALUE;
        for (int j = m - 1; j >= y; j--) { // col [y...m-1]
            for (int i = x; i <= x + 1; i++) {
                if (i < n && g[i][j] == 'W') {
                    if (j > col) {
                        row = i;
                        col = j;
                    }
                }
            }
        }
        return col == Integer.MIN_VALUE ? new int[]{-1, -1} : new int[]{row, col};
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        solve(n, m, g);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B115().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
