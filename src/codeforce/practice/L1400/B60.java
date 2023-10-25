/**
 * 09/10/23 night
 * https://codeforces.com/problemset/problem/100/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B60 {
    static PrintWriter pw;

    void solve(char[][][] g, int x, int y) {
        pr(bfs_3D(g, x, y));
    }

    // reference: https://www.acwing.com/problem/content/4711/
    int bfs_3D(char[][][] g, int sy, int sz) {
        int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
        char allow = '.', forbid = '#', floodFillMakeConnected = 'x';
        int K = g.length, n = g[0].length, m = g[0][0].length;
        int area = 0;
        if (g[0][sy][sz] == allow) {
            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, sy, sz});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int k = 0; k < 6; k++) {
                    int nx = cur[0] + dx[k], ny = cur[1] + dy[k], nz = cur[2] + dz[k];
                    if (nx < 0 || nx >= K || ny < 0 || ny >= n || nz < 0 || nz >= m || g[nx][ny][nz] == forbid || g[nx][ny][nz] == floodFillMakeConnected) continue;
                    g[nx][ny][nz] = floodFillMakeConnected;
                    area++;
                    q.add(new int[]{nx, ny, nz});
                }
            }
        }
        return area == 0 ? 1 : area;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int K = fs.nextInt(), n = fs.nextInt(), m = fs.nextInt();
        char[][][] g = new char[K][][];
        for (int k = 0; k < K; k++) {
            char[][] rec = new char[n][];
            for (int i = 0; i < n; i++) rec[i] = fs.next().toCharArray();
            g[k] = rec;
        }
        int x = fs.nextInt() - 1, y = fs.nextInt() - 1;
        solve(g, x, y);
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
        new B60().run();
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