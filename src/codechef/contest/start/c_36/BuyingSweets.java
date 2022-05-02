/**
 * 04/27/22 morning
 * https://www.codechef.com/START36C/problems/BUYSWEET
 */
package codechef.contest.start.c_36;

import java.util.*;
import java.io.*;

class BuyingSweets {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/63839629
    // Accepted --- https://www.codechef.com/viewsolution/63839564
    // Accepted --- https://www.codechef.com/viewsolution/63839496
    // WA https://www.codechef.com/viewsolution/63839599
    // WA https://www.codechef.com/viewsolution/63819717
    /*
     10 - 5 + 4 = 9   10 - 1
     9 - 5 + 4 = 8    9 - 1
     8 - 5 + 4 = 7    8 - 1
     7 - 5 + 4 = 6    7 - 1
     6 - 5 + 4 = 5    6 - 1
     5 - 5 + 4 = 4    5 - 1

     4 - 2 = 2
     */
    void solve(int n, int r, int[] a, int[] b) {
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{a[i], i, a[i] - b[i]};
//        tr(n, r, a, b);
        Arrays.sort(d, (x, y) -> {
//            if (x[0] != y[0]) return x[0] - y[0];
//            return x[2] - y[2];
            if (x[2] != y[2]) return x[2] - y[2];
            return x[0] - y[0];
        });
        // tr("sorted d", d);

//        TreeMap<Integer, List<Integer>> mc = counter_value_in_indexA_in(cost);  // {min cost: i}
//        TreeMap<Integer, Integer> mc = new TreeMap<>();
//        for (int x : ma.keySet()) {
//            List<Integer> l = ma.get(x);
//            for (int i : l) {
//                int min = Math.min(mc.getOrDefault(x, Integer.MAX_VALUE), cost[i]);
//                mc.put(x, min);
//            }
//        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            int need = d[i][0], actualCost = d[i][2];
//            int idx = lower_bound(d, r);
//            if (idx == n) break;
            // tr(i, "r", r, "need", need);
            if (r < need) continue;
            int dis = r - need;
            // int step = 1 + divideCeil(dis, actualCost); // if actualCost = 2, 5 / 2 = 3   10 - 3 * 2 = 4  wrong here
            int step = (dis + actualCost) / actualCost;
            r -= step * actualCost;
            res += step;
            // tr("step", step, "res", res, "update r", r);
        }
        // pr(res + 1);
        pr(res);
    }

    int divideCeil(int x, int d) {
        return (int) Math.ceil((double) x / d);
    }

    int lower_bound(int[][] d, int x) {
        int low = 0, high = d.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (d[mid][0] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), r = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
            solve(n, r, a, b);
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
        new BuyingSweets().run();
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
