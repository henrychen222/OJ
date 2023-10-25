/**
 * 11/30/22 morning
 * https://www.codechef.com/START67B/problems/EXPSTP
 */
package codechef.contest.start.b_67;

import java.util.*;
import java.io.*;

class ExpensiveSteps {
    static PrintWriter pw;

    /*

     [2, 2, 1, 3]
     * e *
     * * *
     s * *    R: 3 - 0 = 3
     [3, 1, 3, 1]

     * * * * * *
     * * * * e *   [2, 1, 5, 2]
     * * * * * *
     * * * * * *
     * * * * * *
     * s * * * *
     */
    // Accepted
    void solve(int n, int x1, int y1, int x2, int y2) {
        x1--;
        y1--;
        x2--;
        y2--;
        int res1 = Math.abs(x1 - x2) + Math.abs(y1 - y2);
        int moveOut = minMoveOut(n, n, x1, y1), moveIn = minMoveOut(n, n, x2, y2), res2 = moveOut + moveIn;
        // tr(res1, res2);
        pr(Math.min(res1, res2));
        // pr(minDisMap(n, n, x1 - 1, y1 - 1, x2 - 1, y2 - 1));
    }

    int minMoveOut(int n, int m, int x, int y) {
        int[] a = {m - y, y + 1, n - x, x + 1}; // R L U D
        // tr("out", a, n, m, "x", x, "y", y);
        return Arrays.stream(a).min().getAsInt();
    }

    // TLE
    int minDisMap(int n, int m, int startX, int startY, int endX, int endY) {
        // tr(n, m, startX, startY, endX, endY);
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        Map<String, Integer> dis = new HashMap<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        dis.put(startX + " " + startY, 0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // tr("cur", cur);
            int x = cur[0], y = cur[1];
            String ke = x + " " + y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                String nke = nx + " " + ny;
                if (nx < -5 || nx >= n + 5 || ny < -5 || ny >= m + 5) continue;
//                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (inGrid(x, y, n, m) || inGrid(nx, ny, n, m)) {
                    if (dis.getOrDefault(nke, Integer.MAX_VALUE) > dis.getOrDefault(ke, Integer.MAX_VALUE) + 1) {
                        dis.put(nke, dis.getOrDefault(ke, 0) + 1);
                        q.add(new int[]{nx, ny});
                    }
                } else {
                    if (dis.getOrDefault(nke, Integer.MAX_VALUE) > dis.getOrDefault(ke, Integer.MAX_VALUE)) {
                        dis.put(nke, dis.getOrDefault(ke, 0));
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        // tr(endX + " " + endY, dis);
        return dis.get(endX + " " + endY);
    }

    boolean inGrid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(5);
            solve(a[0], a[1], a[2], a[3], a[4]);
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
        new ExpensiveSteps().run();
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
