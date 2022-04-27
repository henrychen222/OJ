/**
 * 03/10/22 morning
 * https://codeforces.com/contest/1651/problem/D
 */
package codeforce.ecf.r124;

import java.util.*;
import java.io.*;

// TLE now
public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1651/submission/149184050
    // reference: cuiaoxiang https://codeforces.com/contest/1651/submission/149125410
    void solve(int n, int[][] points) {
        // tr(n, points);
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = points[i][0] + " " + points[i][1];
            m.put(s, i);
        }
        // tr(m);
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Deque<int[]> q = new ArrayDeque<>();
        Map<String, int[]> source = new HashMap<>();
        int[][] res = new int[n][];
        for (int[] p : points) {
            int x = p[0], y = p[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                String nextKe = nx + " " + ny;
                int[] nextP = {nx, ny};
                if (!m.containsKey(nextKe)) {
                    source.put(nextKe, nextP);
                    q.addLast(nextP);
                    // tr("q", q.toArray());
                    break;
                }
            }
        }
        // tr("q", q.toArray());
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];
            String curKe = x + " " + y;
//            tr("cur", curKe, source);
//            tr(source.values().toArray());
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                String nextKe = nx + " " + ny;
                int[] nextP = new int[]{nx, ny};
                if (source.containsKey(nextKe)) continue; // used
                source.put(nextKe, source.get(curKe)); // set nearest point
                if (m.containsKey(nextKe)) {
                    res[m.get(nextKe)] = source.get(nextKe);
                    cnt++;
                }
                if (cnt == n) {
                    for (int[] e : res) pr(e[0] + " " + e[1]);
                    return;
                }
                q.addLast(nextP);
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) points[i] = fs.readArray(2);
        solve(n, points);
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
        new D().run();
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

