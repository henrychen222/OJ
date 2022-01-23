/**
 * 01/15/22 morning
 * https://atcoder.jp/contests/abc235/tasks/abc235_d
 */
package atcoder.abc.r235.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc235/submissions/28570736
    // uwi fix https://atcoder.jp/contests/abc235/submissions/28570025
    void solve(int a, int n) {
        int x = a;
        int res = minStepNumberOperation(x, n, a);
        pr(res);
    }

    int minStepNumberOperation(int x, int target, int a) {
        int[] dis = new int[1000005];
        Arrays.fill(dis, Integer.MAX_VALUE);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(x);
        dis[x] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            // tr(cur, q);
            if (cur == target) return dis[cur];
            String s = cur + "";
            int n = s.length();
            if ((long) cur * a < 1000000) {
                int t1 = cur * a;
                if (dis[t1] > dis[cur] + 1) {
                    dis[t1] = dis[cur] + 1;
                    // q.push(t1); // fuck issue, push = addFirst()
                    q.add(t1);
                }
            }
            if (cur >= 10 && cur % 10 != 0 && cur < 1000000) {
                s = s.substring(n - 1) + s.substring(0, n - 1);
                int t2 = Integer.parseInt(s);
                if (dis[t2] > dis[cur] + 1) {
                    dis[t2] = dis[cur] + 1;
                    // q.push(t2); // fuck issue, push = addFirst()
                    q.add(t2);
                }
            }
        }
        return -1;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int a = fs.nextInt(), n = fs.nextInt();
        solve(a, n);
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