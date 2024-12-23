/**
 * 03/30/24 morning 12/23/24 afternoon complete (Germain)
 * https://www.acwing.com/problem/content/5565/
 */
package acwing.y2024.r149.B;

import java.util.*;
import java.io.*;

/*
10 926
5 6 8 1 2 5 1 8 4 4
351 739 998 725 953 970 906 691 707 1000

--- 137
 */
class Main {
    static PrintWriter pw;

    // Accepted --- https://www.acwing.com/problem/content/submission/code_detail/38549696/
    // reference: https://www.acwing.com/solution/content/237867/
    void maxMin(int n, int k, int[] a, int[] b) {
        int low = 0, high = Integer.MAX_VALUE;
        while (high - low > 1) {
            int m = low + (high - low) / 2;
            boolean ok = false;
            if (ok(m, k, a, b)) {
                low = m;
            } else {
                high = m;
            }
            // tr(low, high);
        }
        pr(low);
    }

    boolean ok(int m, int k, int[] a, int[] b) {
        long rest = k;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            long need = (long) a[i] * m;
            if (need > rest + b[i]) return false;
            if (need > b[i]) rest -= need - b[i];
        }
        return true;
    }

//    void solve(int n, int k, int[] a, int[] b) {
//        int[] cnt = new int[n];
//        int[] rest = new int[n];
//        int[][] d = new int[n][];
//        for (int i = 0; i < n; i++) {
//            cnt[i] = b[i] / a[i];
//            rest[i] = b[i] % a[i];
//            d[i] = new int[]{cnt[i], rest[i], a[i]};
//        }
//        tr("cnt", cnt);
//        tr("rest", rest);
//        tr("a", a);
//        Arrays.sort(d, (x, y) -> x[0] - y[0]);
//        tr(d);
//        long res = 0;
//        int idx = -1;
//        long[] diff = new long[n - 1];
//        for (int i = 0; i < n; i++) {
//            long missCnt = d[i + 1][0] - d[i][0];
//            long toChaseCnt = d[i][1] + (missCnt - 1) * a[i];
//            if (k - toChaseCnt >= 0) {
//                idx = i;
//                k -= toChaseCnt;
//            } else {
//                break;
//            }
//            diff[i] = toChaseCnt;
//        }
//        tr(idx, d[idx], diff);
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n);
        maxMin(n, k, a, b);
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