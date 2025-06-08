/**
 * 10/28/23 noon 02/10/25 morning
 * https://www.luogu.com.cn/problem/P1123
 */
package luogu.level3_yellow.P1123;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    int tot;
    long res;
    Map<Integer, int[]> cors;

    void solve(int n, int m, int[][] g) {
        cors = new HashMap<>();
        tot = n * m;
        res = 0;
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Deque<Integer> cur = new ArrayDeque<>();
                Set<Integer> used = new HashSet<>();
                cur.add(i * m + j);
                used.add(i * m + j);
                dfs(cur, used, g);
            }
        }
        pr(res);
    }

    void dfs(Deque<Integer> cur, Set<Integer> used, int[][] g) {
        for (int i = 0; i < tot; i++) {
            if (used.contains(i)) continue;
            cur.push(i);
            used.add(i);
            tr("cur", cur, ok(cur));
            if (ok(cur)) {
                long sum = 0;
                for(int node: cur) {
                    int[] cor = cors.get(node);
                    sum += g[cor[0]][cor[1]];
                }
                res = Math.max(res, sum);
                dfs(cur, used, g);
            }
            int last = cur.pop();
            used.remove(last);
        }
    }

    boolean unique (Deque<Integer> cur) {
        Set<Integer> se  = new HashSet<>();
        for(int x: cur) se.add(x);
        return cur.size() == se.size();
    }

    boolean ok(Deque<Integer> cur) {
//        if (!unique(cur)) return false;
        if (cur.size()>tot) return false;
        if (cur.size() >= 2) {
            int last = cur.getLast();
            int[] lastCor = cors.get(last);
            for (var node : cur) {
                if (node != last) {
                    int[] cor = cors.get(node);
                    if (!valid(cor[0], cor[1], lastCor[0], lastCor[1])) return false;
                }
            }
        }
        return true;
    }

    // not next
    boolean valid(int i, int j, int x, int y) {
        return Math.abs(i - x) > 1 || Math.abs(j - y) > 1;
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

