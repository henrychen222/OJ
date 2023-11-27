/**
 * 10/25/23 night
 * https://www.luogu.com.cn/problem/P1141
 */
package luogu.level3_yellow.P1141;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/131629949
    void solve(int n, char[][] g, int[][] points) {
        DJSet ds = new DJSet(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && (g[i][j] ^ 1) == g[i + 1][j]) ds.union(i * n + j, (i + 1) * n + j);
                if (i - 1 >= 0 && (g[i][j] ^ 1) == g[i - 1][j]) ds.union(i * n + j, (i - 1) * n + j);
                if (j + 1 < n && (g[i][j] ^ 1) == g[i][j + 1]) ds.union(i * n + j, i * n + j + 1);
                if (j - 1 >= 0 && (g[i][j] ^ 1) == g[i][j - 1]) ds.union(i * n + j, i * n + j - 1);
            }
        }
        // tr(ds.p);
        for (int[] p : points) {
            int x = p[0] - 1, y = p[1] - 1, node = x * n + y;
            int root = ds.find(node);
            pr(-ds.p[root]);
        }
    }

    class DJSet {
        int[] p;
        int n;

        DJSet(int n) {
            this.p = new int[n];
            this.n = n;
            Arrays.fill(p, -1);
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (p[x] < p[y]) {
                int d = x;
                x = y;
                y = d;
            }
            p[x] += p[y];
            p[y] = x;
            return true;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            for (int u : p) if (u < 0) cnt++;
            return cnt;
        }

        List<List<Integer>> grp() {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());
            for (int i = 0; i < n; i++) g.get(find(i)).add(i);
            return g;
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        char[][] g = new char[n][];
        int[][] p = new int[m][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        for (int i = 0; i < m; i++) p[i] = fs.readArray(2);
        solve(n, g, p);
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
