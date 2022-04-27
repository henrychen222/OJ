/**
 * 04/13/22 morning
 * https://www.codechef.com/START34C/problems/POSPROD
 */
package codechef.contest.start.c_34;

import java.util.*;
import java.io.*;

class PositiveProducts {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                pos.add(i);
            } else if (a[i] < 0) {
                neg.add(i);
            }
        }
        // tr(pos, neg);
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) continue;
            if (a[i] > 0) {
                int j = upper_bound(pos, i);
                int cnt = pos.size() - j;
                // tr("pos", a[i], j, cnt);
                res += cnt;
            } else {
                int j = upper_bound(neg, i);
                int cnt = neg.size() - j;
                // tr("neg", a[i], j, cnt);
                res += cnt;
            }
        }
        pr(res);
    }

    int upper_bound(List<Integer> a, int x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
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
        new PositiveProducts().run();
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
