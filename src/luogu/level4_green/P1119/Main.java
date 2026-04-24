/**
 * 04/10/26 afternoon
 * https://www.luogu.com.cn/problem/P1119
 */
package luogu.level4_green.P1119;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/273286770
    // reference: https://www.luogu.com.cn/problem/solution/P1119 Time_Rune
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[] a = fs.readArray(n);
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(3);
        int[][] d = floyd_warshall_prepare(n, 0, edges);
        int q = fs.nextInt();
        int idx = 0;
        // tr(n, m, a, edges);
        for (int i = 0; i < q; i++) {
            int x = fs.nextInt(), y = fs.nextInt(), t = fs.nextInt();
            // tr(x, y, t);
            while (idx < n && a[idx] <= t) {
                floyd_warshall_k(n, 0, d, idx);
                idx++;
            }
//            tr(d, d[x][y]);
            if (a[x] > t || a[y] > t) {
                pr(-1);
            } else {
                if (d[x][y] == (int) 1e9) {
                    pr(-1);
                } else {
                    pr(d[x][y]);
                }
            }
        }
    }

    void floyd_warshall_k(int n, int start, int[][] d, int k) {
        for (int i = start; i < n; i++) {
            for (int j = start; j < n; j++) {
                if (d[i][j] > d[i][k] + d[k][j]) {
                    d[i][j] = d[j][i] = d[i][k] + d[k][j];
                }
            }
        }
    }

    int[][] floyd_warshall_prepare(int n, int start, int[][] edges) {
        int[][] d = new int[n][n];
        for (int i = start; i < n; i++) {
            for (int j = start; j < n; j++) {
                d[i][j] = (int) 1e9;
            }
        }
        for (int[] e : edges) { // UG
            int u = e[0], v = e[1], cost = e[2];
            d[u][v] = d[v][u] = cost; // initial each edge cost
        }
        for (int i = start; i < n; i++) d[i][i] = 0;
        return d;
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
