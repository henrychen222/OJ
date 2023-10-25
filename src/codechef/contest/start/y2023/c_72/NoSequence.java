/**
 * 01/04/23 morning
 * https://www.codechef.com/START72C/problems/NOSEQ
 */
package codechef.contest.start.y2023.c_72;

import java.util.*;
import java.io.*;

class NoSequence {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/84433977
    // reference: https://discuss.codechef.com/t/noseq-editorial/104754
    void solve(int n, int k, long s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long rem = s % k;
            if (rem == 0) {
                res.add(0);
                s /= k;
            } else if (rem == 1) {
                res.add(1);
                s--;
                s /= k;
            } else if (rem == k - 1) {
                res.add(-1);
                s++;
                s /= k;
            }
        }
        if (s > 0) {
            pr(-2);
            return;
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    void solve1(int n, int k, long s) {
        int[] d = {-1, 0, 1};
        long[] p = buildPowerArray(n, k);
        tr(p);
        Deque<long[]> q = new ArrayDeque<>();
        q.add(new long[]{0, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            // tr("cur", cur);
            long v = cur[0];
            int idx = (int) cur[1];
            if (v == s) {
                tr(cur);
                return;
            }
            for (int i = 0; i < 3; i++) {
                long next = v + p[i] * d[i];
                q.add(new long[]{next, idx + 1});
            }
        }
    }

    long[] buildPowerArray(int n, int k) {
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) power[i] = power[i - 1] * k;
        return power;
    }

    long cal(int[] a, int k) {
        int n = a.length;
        long sum = 0;
        for (int i = 0; i < n; i++) sum += a[i] * Math.pow(k, i);
        return sum;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            long s = fs.nextLong();
            solve(n, k, s);
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
        new NoSequence().run();
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
