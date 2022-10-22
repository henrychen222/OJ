/**
 * 05/23/22 morning
 * https://codeforces.com/contest/1681/problem/D
 */
package codeforce.ecf.r129;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- 405ms https://codeforces.com/contest/1681/submission/158231668 (TreeMap)
    // Accepted --- 311ms https://codeforces.com/contest/1681/submission/158232074 (HashMap)
    // 数字变换 bfs  参考二维数组 minDis的写法 这里用map做dis
    void solve(int n, long x) {
        Map<Long, Long> dis = new HashMap<>();
        dis.put(x, 0L);
        Deque<Long> q = new ArrayDeque<>();
        q.add(x);
        while (!q.isEmpty()) {
            long cur = q.poll();
            String s = cur + "";
            long[][] next = next(cur, s);
            // tr(cur, dis);
            if (s.length() == n) {
                pr(dis.get(cur));
                return;
            }
            for (long[] e : next) {
                long ne = e[0];
                if (!dis.containsKey(ne) || dis.get(ne) > dis.get(cur) + 1) {
                    dis.put(ne, dis.get(cur) + 1);
                    q.add(ne);
                }
            }
        }
        pr(-1);
    }

    ////////////////////////////////////////////////////////////////
    // WA
    void solve1(int n, long x) {
        long begin = x;
        long res = 0;
        // for (int i = 0; i < 1; i++) {
        while (true) {
            String s = x + "";
            if (s.length() < n) {
//                long[][] next = next(x, s);
//                long pick = pickByMaxDigit(next);
//                tr("cur", x, "next", next, "pick", pick, res);
//                x = pick;
                int y = maxDigit(s); // 贪心不对 不是每次算最大的digit, 应该是选择路径里的总和尽可能大(dp/dfs)
                if (y == 1) break;
                x = x * y;
                res++;
            } else {
                break;
            }
        }
        // tr(x, res);
        pr(x == begin ? -1 : res);
    }

    long pickByMaxDigit(long[][] a) {
        Arrays.sort(a, (x, y) -> Long.compare(y[1], x[1]));
        return a[0][0];
    }

    long[][] next(long x, String s) {
        int n = s.length();
        long[][] res = new long[n][2];
        for (int i = 0; i < n; i++) res[i][0] = x * (s.charAt(i) - '0');
        for (int i = 0; i < n; i++) res[i][1] = maxDigit(res[i][0] + "");
        return res;
    }

    int maxDigit(String s) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) max = Math.max(max, s.charAt(i) - '0');
        return max;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long x = fs.nextLong();
        solve(n, x);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}