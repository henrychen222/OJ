/**
 * 05/12/23 morning
 * https://codeforces.com/contest/1832/problem/C
 */
package codeforce.ecf.r148;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    // reference: tourist
    void solve(int n, int[] a) {
        List<int[]> d = cutMaxConsecutive(a);
        int[] b = new int[d.size()];
        int p = 0;
        for (int[] e : d) b[p++] = e[0];
        int res = 0;
        for (int i = 0; i < b.length; i++) {
            // if (i == 0 || i == b.length - 1 || b[i] > b[i - 1] == b[i] > b[i + 1]) res++;
            if (i == 0 || i == b.length - 1 || !canRemove(b[i - 1], b[i], b[i + 1])) res++; // canRemove think is correct
        }
        pr(res);
    }

    // WA
    void solve1(int n, int[] a) {
        // getAllSubsequence(a);
        Deque<Integer> st = new ArrayDeque<>();
        for (int x : a) {
            // tr(st);
            while (st.size() > 3) {
                int third = st.pollLast(), second = st.pollLast(), first = st.pollLast();
                // tr("seq", first, second, third);
                if (!canRemove(first, second, third)) {
                    st.add(first);
                    st.add(second);
                    st.add(third);
                }
            }
            st.add(x);
        }
        // tr(st);
        int[] b = new int[st.size()];
        int p = 0;
        for (int x : st) b[p++] = x;
        List<int[]> d = cutMaxConsecutive(b);
        pr(d.size());
    }

    List<int[]> cutMaxConsecutive(int[] a) {
        List<int[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    boolean canRemove(int pre, int cur, int next) {
        return Math.abs(cur - pre) + Math.abs(cur - next) == Math.abs(pre - next);
    }

    void getAllSubsequence(int[] a) {
        int n = a.length;
        long abv = cal(a), res = Long.MAX_VALUE;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> sub = new ArrayList<>();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(a[j]);
                }
            }
            // tr("sub", sub, cal(sub), abv);
            if (cal(sub) == abv) {
                tr("ok", sub, cal(sub), sub.size());
                res = Math.min(res, sub.size());
            }
        }
        tr(res);
    }

    long cal(int[] a) {
        int n = a.length, res = 0;
        for (int i = 1; i < n; i++) res += Math.abs(a[i] - a[i - 1]);
        return res;
    }

    long cal(List<Integer> a) {
        int n = a.size(), res = 0;
        for (int i = 1; i < n; i++) res += Math.abs(a.get(i) - a.get(i - 1));
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
        new C().run();
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
