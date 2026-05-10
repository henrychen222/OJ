/**
 * 05/05/26 noon
 * https://www.luogu.com.cn/problem/P1332
 */
package luogu.level3_yellow.page2.P1332;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/276839278
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
        int[][] g = new int[n][m];
        for (int i = 0; i < a; i++) {
            int x = fs.nextInt() - 1, y = fs.nextInt() - 1;
            g[x][y] = 1;
        }
        int[][] dis = minDisGlobal(g);
        for (int i = 0; i < b; i++) {
            int x = fs.nextInt() - 1, y = fs.nextInt() - 1;
            pr(dis[x][y]);
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

    <T> void pr(T t) {
        pw.println(t);
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
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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