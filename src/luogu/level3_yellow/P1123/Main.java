/**
 * 10/28/23 noon
 * https://www.luogu.com.cn/problem/P1123
 */
package luogu.level3_yellow.P1123;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    void solve(int n, int m, int[][] g) {
        Map<Integer, int[]> cors = new HashMap<>();
        TreeSet[] groups = new TreeSet[n * m];
        int p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cors.put(i * m + j, new int[]{i, j});
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(i * m + j);
                groups[p++] = ts;
            }
        }
//        tr(groups, groups[0]);
        for (int idx = 0; idx < groups.length; idx++) {
            TreeSet<Integer> ts = groups[idx];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    // tr(g[i][j], g[x][y], Math.abs(i - x), Math.abs(j - y), valid(i, j, x, y));
                    boolean ok = true;
                    for (int curNode : ts) {
                        int[] cor = cors.get(curNode);
                        if (!valid(x, y, cor[0], cor[1])) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) groups[idx].add(x * m + y);
                }
            }
        }
        // tr(groups);
        List<List<Integer>> groupVals = new ArrayList<>();
        long res = 0;
        for (int i = 0; i < groups.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            TreeSet<Integer> ts = groups[i];
            long sum = 0;
            for (int node : ts) {
                int[] cor = cors.get(node);
                tmp.add(g[cor[0]][cor[1]]);
                sum += g[cor[0]][cor[1]];
            }
            res = Math.max(res, sum);
            groupVals.add(tmp);
            // tr(sum);
        }
        tr("groups", groups);
        tr("groupVals", groupVals);
        pr(res);
    }

    boolean valid(int i, int j, int x, int y) {
        return Math.abs(i - x) > 1 || Math.abs(j - y) > 1;
    }

//    void union8NeighboursMatrix(int n, int m, int i, int j, DJSet ds) {
//        int cur = i * m + j;
//        if (i + 1 < n) ds.union(cur, (i + 1) * m + j);
//        if (i - 1 >= 0) ds.union(cur, (i - 1) * m + j);
//        if (j + 1 < m) ds.union(cur, i * m + j + 1);
//        if (j - 1 >= 0) ds.union(cur, i * m + j - 1);
//
//        if (i + 1 < n && j + 1 < m) ds.union(cur, i * m + j + 1);
//        if (i + 1 < n && j - 1 >= 0) ds.union(cur, i * m + j - 1);
//        if (i - 1 >= 0 && j + 1 < m) ds.union(cur, (i - 1) * m + j + 1);
//        if (i - 1 >= 0 && j - 1 >= 0) ds.union(cur, (i - 1) * m + j - 1);
//    }

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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

