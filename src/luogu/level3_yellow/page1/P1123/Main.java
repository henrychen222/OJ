/**
 * 10/28/23 noon 02/10/25 morning 05/08/26 afternoon
 * https://www.luogu.com.cn/problem/P1123
 */
package luogu.level3_yellow.page1.P1123;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    long res;
    int N, M;
    int[][] vis;

    // Accepted --- https://www.luogu.com.cn/record/277154805
    void solve(int n, int m, int[][] g) {
        N = n;
        M = m;
        vis = new int[n][m];
        res = 0;
        dfs(g, 0, 0, 0);
        pr(res);
    }

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    void dfs(int[][] g, int x, int y, long sum) {
        // 当到达一行的末尾时，换到下一行
        if (y == M) {
            dfs(g, x + 1, 0, sum);
            return;
        }
        // 当处理完所有格子时，更新答案
        if (x == N) {
            res = Math.max(res, sum);
            return;
        }

        // 1. 不选当前格子，直接去下一个格子
        dfs(g, x, y + 1, sum);

        // 2. 尝试选择当前格子
        if (vis[x][y] == 0) {
            // 标记自己及周围的8个格子
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    vis[nx][ny]++;
                }
            }
            // 递归到下一个格子
            dfs(g, x, y + 1, sum + g[x][y]);
            // 回溯：撤销标记
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    vis[nx][ny]--;
                }
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] g = new int[n][];
            for (int i = 0; i < n; i++) g[i] = fs.readArray(m);
            solve(n, m, g);
        }
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

