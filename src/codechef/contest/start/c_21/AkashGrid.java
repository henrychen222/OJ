/**
 * 01/05/22 morning
 * https://www.codechef.com/START21C/problems/CHEFGRD
 */
package codechef.contest.start.c_21;

import java.util.*;
import java.io.*;

class AkashGrid {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int xs, int ys) {
        int xc = n / 2 + 1, yc = n / 2 + 1;
        // tr(xc, yc, xs, ys);
        if ((xs % 2 == 1 && ys % 2 == 1) || (xs % 2 == 0 && ys % 2 == 0)) {
            pr(0);
            return;
        }
        pr(1);
    }

    // WA TLE
    void solve1(int n, int xs, int ys) {
        int[] start = new int[]{n / 2, n / 2};
        boolean[][] vis = new boolean[n][n];
        // tr(start, vis);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(start);
        int[] dx = {-1, 1, -1, 1}, dy = {-1, -1, 1, 1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (vis[nx][ny]) continue;
                // tr(nx, ny);
                if (nx == xs && ny == ys) {
                    pr(0);
                    return;
                }
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        pr(1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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
        new AkashGrid().run();
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
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