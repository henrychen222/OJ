/**
 * 06/08/22 morning
 * https://www.codechef.com/START42C/problems/MODULO3
 */
package codechef.contest.start.c_42;

import java.util.*;
import java.io.*;

class DivisibleBy3 {
    static PrintWriter pw;
    long res;
    Set<String> memo;

    // Accepted
    void solve(long a, long b) {
        if (a % 3 == 0 || b % 3 == 0) {
            pr(0);
            return;
        }
        long diff = Math.abs(a - b);
        if (diff % 3 == 0) {
            pr(1);
            return;
        }
        pr(2);
    }

    // WA
    void solve1(long a, long b) {
        res = Long.MAX_VALUE;
        memo = new HashSet<>();
        dfs(a, b, 0);
        pr(res);
    }

    void dfs(long a, long b, long step) {
        // tr(a, b, step);
        String ke = Math.min(a, b) + " " + Math.max(a, b);
        if (memo.contains(ke)) return;
        memo.add(ke);
        if (a % 3 == 0 || b % 3 == 0) {
            res = Math.min(res, step);
            return;
        }
        long diff = Math.abs(a - b);
        dfs(diff, b, step + 1);
        dfs(a, diff, step + 1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long a = fs.nextLong(), b = fs.nextLong();
            solve(a, b);
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
        new DivisibleBy3().run();
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
