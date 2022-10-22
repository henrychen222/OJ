/**
 * 06/05/22 night
 * https://www.luogu.com.cn/problem/P1142
 *
 * similar problem
 * https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
 */
package luogu.level3_yellow.P1142;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/77010970
    void solve(long[][] g) {
        int n = g.length;
        Arrays.sort(g, (x, y) -> Long.compare(x[0], y[0]));
        long res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // find two points
                long cnt = 0;
                for (int k = 0; k < n; k++) { // the third point
                    if (threePointsInLine(g[i], g[j], g[k])) cnt++;
                }
                // tr(g[i], g[j], cnt);
                res = Math.max(res, cnt);
            }
        }
        pr(res);
    }

    // WA
    void solve1(long[][] g) {
        Map<Double, Integer> m = new HashMap<>();
        for (long[] a : g) {
            Double k = (double) a[1] / a[0];
            if (k == -0.0) k = 0.0;
            m.put(k, m.getOrDefault(k, 0) + 1);
        }
        m = sortMapByValue(m);
        pr(m.values().iterator().next());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[][] g = new long[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(2);
        solve(g);
    }

    boolean threePointsInLine(long[] p1, long[] p2, long[] p3) {
        long x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1], x3 = p3[0], y3 = p3[1];
        return (x2 - x1) * (y3 - y2) == (x3 - x2) * (y2 - y1);
    }

    Map<Double, Integer> sortMapByValue(Map<Double, Integer> map) {
        List<Map.Entry<Double, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, (a, b) -> b.getValue().compareTo(a.getValue()));
        Map<Double, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Double, Integer> entry : data) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}