/**
 * 02/16/22 morning
 * https://www.codechef.com/START26C/problems/DIVIDEARR
 */
package codechef.contest.start.c_26;

import java.util.*;
import java.io.*;

class ArrayDivision {
    static PrintWriter pw;

    // reference: https://discuss.codechef.com/t/dividearr-editorial/99264
    // Accepted -- https://www.codechef.com/viewsolution/58557484
    void solve(int n, int[] a) {
        int res = 0;
        int[][] f = new int[n + 1][n + 1];// f[i][j] represents maximum ans if the two sequences end at i and j
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n; j++) {
                f[i][j + 1] = Math.max(f[i][j + 1], f[i][j] + Math.abs(a[j] - a[j - 1]));
                res = Math.max(res, f[i][j + 1]);
                f[j][j + 1] = Math.max(f[j][j + 1], f[i][j] + (i == 0 ? 0 : Math.abs(a[j] - a[i - 1])));
                res = Math.max(res, f[j][j + 1]);
            }
        }
        pr(res);
    }

    ///////////////////////////////////////////////////////////////////
    // TLE https://www.codechef.com/viewsolution/58541861
    // WA https://www.codechef.com/viewsolution/58554614
    void solve1(int n, int[] a) {
        // test(a);
        int[][] d = new int[n - 1][];
        for (int i = 1; i < n; i++) {
            d[i - 1] = new int[]{i - 1, Math.abs(a[i] - a[i - 1])};
        }
        // tr(d);
        Arrays.sort(d, (x, y) -> x[1] - y[1]);
        // tr(d);
        int[] l = new int[n / 2];
        int[] r = new int[(n + 1) / 2];
        // tr(l.length, r.length);
        boolean[] used = new boolean[n];
        int[] pos = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            int pickidx = d[i][0];
            pos[i] = pickidx;
            used[pickidx] = true;
        }
        Arrays.sort(pos);
        for (int i = 0; i < l.length; i++) {
            l[i] = a[pos[i]];
        }
        for (int i = 0, p = 0; i < n; i++) {
            if (!used[i]) r[p++] = a[i];
        }
        // tr("pick", l, r);
        pr(cal(l) + cal(r));
    }

    void test(int[] a) {
        int n = a.length;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < 1 << n; i++) {
            boolean[] used = new boolean[n];
            List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    l.add(a[j]);
                    used[j] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!used[j]) r.add(a[j]);
            }
            long sumL = cal(l), sumR = cal(r);
            res = Math.max(res, sumL + sumR);
            tr("left", l, "right", r, sumL, sumR, sumL + sumR);
        }
        pr(res);
    }

    long cal(int[] a) {
        int n = a.length;
        long sum = 0;
        for (int i = 1; i < n; i++) sum += Math.abs(a[i] - a[i - 1]);
        return sum;
    }

    long cal(List<Integer> a) {
        int n = a.size();
        long sum = 0;
        for (int i = 1; i < n; i++) sum += Math.abs(a.get(i) - a.get(i - 1));
        return sum;
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
        new ArrayDivision().run();
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
