/**
 * 10/22/22 morning
 * https://www.acwing.com/problem/content/4711/
 */
package acwing.r74.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int k, int n, int m, char[][][] g, int sy, int sz) {
        int areas = bfs(g, sy, sz);
        pr(areas);
    }

    int bfs(char[][][] g, int sy, int sz) {
        int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
        char allow = '.', forbid = '#', floodFillMakeConnected = 'x';
        int K = g.length, n = g[0].length, m = g[0][0].length;
        int area = 0;
        if (g[0][sy][sz] == allow) {
            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0, sy, sz});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                // tr("cur", cur);
                for (int k = 0; k < 6; k++) {
                    int nx = cur[0] + dx[k], ny = cur[1] + dy[k], nz = cur[2] + dz[k];
                    if (nx < 0 || nx >= K || ny < 0 || ny >= n || nz < 0 || nz >= m || g[nx][ny][nz] == forbid || g[nx][ny][nz] == floodFillMakeConnected) continue;
                    g[nx][ny][nz] = floodFillMakeConnected;
                    area++;
                    q.push(new int[]{nx, ny, nz});
                }
            }
        }
        return area == 0 ? 1 : area;
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int k = fs.nextInt(), n = fs.nextInt(), m = fs.nextInt();
        char[][][] g = new char[k][][];
        for (int i = 0; i < k; i++) {
            fs.nextLine();
            char[][] t = new char[n][];
            for (int j = 0; j < n; j++) t[j] = fs.nextLine().toCharArray();
            g[i] = t;
        }
        int[] a = fs.readArray(2);
        solve(k, n, m, g, a[0] - 1, a[1] - 1);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new Main().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}