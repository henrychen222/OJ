// 09/05/21 night

package codeforce.cf.div2.r742;

import java.util.*;
import java.io.*;

public class F2 {

    static PrintWriter pw;

    int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    // Accepted --- 389ms https://codeforces.com/contest/1567/submission/128019618
    void solve(int n, int m, char[][] g) {
        List<List<Integer>> adj = initializeGraph(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'X') {
                    List<Integer> q = new ArrayList<>();
                    for (int[] e : dir) {
                        int x = i + e[0];
                        int y = j + e[1];
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        if (g[x][y] == '.') {
                            q.add(x * m + y);
                        }
                    }
                    if (q.size() % 2 == 1) {
                        pr("NO");
                        return;
                    }
                    for (int k = 0; k < q.size(); k += 2) {
                        int x = q.get(k), y = q.get(k + 1);
                        addEdgeToG(adj, x, y);
                    }
                }
            }
        }
        // tr(adj);
        ArrayDeque<Integer> que = new ArrayDeque<>(); // use ArrayDeque for bfs queue
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] > 0 || g[i][j] == 'X') continue;
                res[i][j] = 1;
                que.add(i * m + j);
                while (que.size() > 0) {
                    int cur = que.pollFirst();
                    for (Object o : adj.get(cur)) {
                        int v = (int) o;
                        if (res[v / m][v % m] == 0) {
                            res[v / m][v % m] = res[cur / m][cur % m] ^ 5;
                            que.add(v);
                        }
                    }
                }
            }
        }
        pr("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'X') {
                    for (int[] e : dir) {
                        int x = i + e[0];
                        int y = j + e[1];
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        if (g[x][y] == '.') {
                            res[i][j] += res[x][y];
                        }
                    }
                }
                if (j == m - 1) {
                    pr(res[i][j]);
                } else {
                    pw.print(res[i][j] + " ");
                }
            }
        }
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    List<List<Integer>> addEdgeToG(List<List<Integer>> G, int from, int to) {
        G.get(from).add(to);
        G.get(to).add(from);
        return G;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = 1;
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            char[][] g = new char[n][m];
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
        new F2().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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