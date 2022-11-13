/**
 * 11/02/22 morning
 * https://www.codechef.com/START63C/problems/MINABS
 */
package codechef.contest.start.c_63;

import java.util.*;
import java.io.*;

class MinimumAbsoluteScore {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/78986310
    // reference: https://discuss.codechef.com/t/minabs-editorial/103806
    void solve(int n, char[] a, char[] b) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += circularCharMoveForward(a[i], b[i]);
            res += 26;
        }
//        tr(res);
        res %= 26;
        pr(Math.min(res, Math.abs(26 - res)));
    }

    void solve1(int n, char[] a, char[] b) {
        long res = 0;
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int move1 = circularCharMoveForward(a[i], b[i]), move2 = circularCharMoveForward(b[i], a[i]);
            if (move1 < move2) {
                res += move1;
            } else if (move2 < move1) {
                res -= move2;
            } else {
                d.add(move1);
            }
            // tr(a[i], b[i], "move1", move1, "move2", -move2);
        }
        // tr(res, d);
        // ans = Long.MAX_VALUE;
        if (d.size() == 0) {
            pr(Math.abs(res));
        } else {
            // pr(Math.abs(bfs_map(res, d)));
//            dfs(res, d, 0);
//            pr(ans);

//            long cur1 = res, cur2 = res;
//            for (int t = 0; t < d.size(); t++) {
//                if (cur1 >= 0) {
//                    cur1 -= 13;
//                    cur2 += 13;
//                } else {
//                    cur1 += 13;
//                    cur2 -= 13;
//                }
//            }
//            pr(Math.min(Math.abs(cur1), Math.abs(cur2)));

            long[] dp = new long[d.size() + 1];
            dp[0] = res;
            for (int i = 1; i < dp.length; i++) {
                long v1 = dp[i - 1] + d.get(i - 1), v2 = dp[i - 1] - d.get(i - 1);
                if (Math.abs(v1) < Math.abs(v2)) {
                    dp[i] = v1;
                } else {
                    dp[i] = v2;
                }
            }
            pr(dp[dp.length - 1]);
        }
    }

    long ans;

    void dfs(long cur, List<Integer> d, int step) {
        if (step > d.size()) return;
        if (step == d.size() && Math.abs(cur) < Math.abs(ans)) {
            ans = cur;
        }
        for (int x : d) {
            dfs(cur + x, d, step + 1);
            dfs(cur - x, d, step + 1);
        }
    }

    long bfs_map(long start, List<Integer> d) {
        long res = Long.MAX_VALUE;
        Deque<long[]> q = new ArrayDeque<>();
        Set<Long> vis = new HashSet<>();
        q.add(new long[]{start, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            for (int x : d) {
                long[][] next = {{cur[0] + x, cur[1] + 1}, {cur[0] - x, cur[1] + 1}};
                for (long[] e : next) {
                    long v = e[0], step = e[1];
                    // tr("v", v, "step", step);
                    if (!vis.contains(v)) {
                        if (step == d.size() && Math.abs(v) < Math.abs(res)) {
                            res = v;
                            q.add(new long[]{v, step});
                            vis.add(v);
                        }
                    }
                }
            }
        }
        return res;
    }

    int circularCharMoveForward(char x, char y) {
        if (x < y) {
            return y - x;
        } else {
            return 26 - x + y;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] a = fs.next().toCharArray(), b = fs.next().toCharArray();
            solve(n, a, b);
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
        new MinimumAbsoluteScore().run();
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
