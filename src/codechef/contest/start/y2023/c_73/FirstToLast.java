/**
 * 01/11/23 morning  01/11/22 noon finish
 * https://www.codechef.com/START73C/problems/FTOL
 */
package codechef.contest.start.y2023.c_73;

import java.util.*;
import java.io.*;

class FirstToLast {
    static PrintWriter pw;

    /*
     Accepted --- https://www.codechef.com/viewsolution/85258223
     reference:
     https://discuss.codechef.com/t/ftol-editorial/104806
     https://www.codechef.com/viewsolution/85116435 (use)
     https://www.codechef.com/viewsolution/85129639
     */
    void solve(int n, int m, int k, int[][] special) {
        int[][] lis = new int[k + 1][2];
        int cur = 0;
        Arrays.sort(special, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return y[1] - x[1];
        });
        for (int[] e : special) {
            if (e[0] == n || e[1] == m) continue;
            int low = 1, high = cur, idx = 0;
            while (low <= high) {
                int mid = low + high >> 1;
                if (e[0] > lis[mid][0] && e[1] > lis[mid][1]) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            cur = Math.max(cur, idx + 1);
            lis[idx + 1] = e;
        }
        pr(n + m - 2 - cur);
    }

    int lower_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (a[mid] < x) {
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
            int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
            int[][] special = new int[k][];
            for (int i = 0; i < k; i++) special[i] = fs.readArray(2);
            solve(n, m, k, special);
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
        new FirstToLast().run();
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
