/**
 * 02/18/22 evening 08/26/22 night redo
 * https://www.hackerrank.com/challenges/equal/problem
 */
package hackerrank.medium.s30;

import java.util.*;
import java.io.*;

public class Equal {
    static PrintWriter pw;

    // Accepted https://www.hackerrank.com/challenges/equal/submissions/code/287016862
    // reference: https://github.com/BlakeBrown/HackerRank-Solutions/blob/master/Algorithms/Dynamic%20Programming/Equal%20-%20O(n)%20greedy.cpp
    void solve(int n, int[] a) {
        int min = Arrays.stream(a).min().getAsInt(), res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int move = 0;
            for (int x : a) move += ops(x - min + i);
            res = Math.min(res, move);
        }
        pr(res);
    }

    int ops(int n) {
        int res = 0;
        res += n / 5;
        n %= 5;
        res += n / 2;
        n %= 2;
        res += n;
        return res;
    }

    ///////////////////////////////////////////////////////////////
    // WA
    void solve1(int n, int[] a) {
        int[] u = removeDuplicatedSorted(a);
        long pre = u[0], res = 0, add = 0;
        // tr(u);
        for (int i = 1; i < u.length; i++) {
            long cur = u[i] + add;
            long diff = cur - pre;
            add += diff;
            long move = calMove(pre, cur);
            res += move;
            // tr("cur", cur, "pre", pre, "diff", diff, "move", move);
            pre = cur;
        }
        pr(res);
    }

    long calMove(long x, long y) {
        int[] move = {0, 1, 1, 2, 2};
        long diff = y - x, res = 0;
        if (diff >= 5) {
            res += diff / 5;
            diff %= 5;
        }
        res += move[(int) diff];
        return res;
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
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
        new Equal().run();
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
