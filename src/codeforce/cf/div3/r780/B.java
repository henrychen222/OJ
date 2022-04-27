/**
 * 03/31/22 morning
 * https://codeforces.com/contest/1660/problem/B
 */
package codeforce.cf.div3.r780;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1660/submission/151590341
    void solve(int n, int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
        // tr(a);
        if (n == 1) {
            pr(a[0] > 1 ? "NO" : "YES");
            return;
        }
        // WA fuck stupid problem
//        for (int i = 1; i < n; i++) {
//            if (a[i] == 1 || a[i - 1] == 1) continue;
//            if (a[i] - a[i - 1] > 1) {
//                pr("NO");
//                return;
//            }
//        }
        if (a[n - 1] - a[n - 2] > 1) {
            pr("NO");
            return;
        }
        pr("YES");
    }

    void solve1(int n, int[] a) {
        tr(a);
        int one = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int type = 0; type < n; type++) {
            if (a[type] == 1) {
                one++;
            } else {
                pq.add(new int[]{type + 1, a[type]});
            }
        }
        while (pq.size() > 1) {
            // tr("pq", pq.toArray());
            int[] cur = pq.poll(), next = pq.poll();
            tr(cur, next);
            cur[1] -= next[1];
            tr("update cur", cur);
            if (cur[1] > 0) pq.add(cur);
        }
        tr("pq", pq.toArray());
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new B().run();
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