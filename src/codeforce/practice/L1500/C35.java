/**
 * 04/07/26 night
 * https://codeforces.com/problemset/problem/35/C
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class C35 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/35/370236850
    // TLE --- https://codeforces.com/problemset/submission/35/370235108 (issue push())
    void solve(int n, int m, int[] coordinates) {
        // tr(n, m, coordinates);
        int[][] g = new int[n][m];
        for (int i = 0; i < coordinates.length - 1; i += 2) {
            g[coordinates[i] - 1][coordinates[i + 1] - 1] = 1;
        }
//         tr(g);
        int[][] dis = minDisGlobal(g);
//         tr(dis);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dis[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dis[i][j] == max) {
                    pr((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }


    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    int[][] minDisGlobal(int[][] g) {
        int flood = 1;
        int n = g.length, m = g[0].length;
        int[][] dis = new int[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) { // initialization / prepare
            for (int j = 0; j < m; j++) {
                if (g[i][j] == flood) {
                    dis[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
//            tr(x, y);
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dis[nx][ny] > dis[x][y] + 1) {
                    dis[nx][ny] = dis[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return dis;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
        int[] coordinates = fs.readArray(k * 2);
        solve(n, m, coordinates);
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
            pw = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
//        pw = new PrintWriter(System.out);
        new C35().run();
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
