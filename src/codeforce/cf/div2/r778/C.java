/**
 * 03/20/22 morning
 * https://codeforces.com/contest/1654/problem/C
 */
package codeforce.cf.div2.r778;

import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class C {
    static PrintWriter pw;

    // 03/26/22 afternoon
    // Accepted --- https://codeforces.com/contest/1654/submission/151041037
    // reference: https://codeforces.com/blog/entry/100127 + uwi
    void solve(int n, long[] a) {
        long sum = 0;
        for (long x : a) sum += x;
        TreeMap<Long, Integer> rem = new TreeMap<>();
        rem.put(sum, 1);
        ConcurrentSkipListMap<Long, Integer> m = counter(a);
        while (rem.size() > 0) {
            long cur = rem.lastKey();
            if (cur < m.lastKey()) break;
            removeOneOrManyMap(rem, cur);
            if (m.containsKey(cur)) {
                // current rem max ==  m max, remove it from both
                removeOneOrManyMap(m, cur);
            } else {
                // current rem max > m max, split the cake and add to rem
                addOneOrManyMap(rem, cur / 2);
                addOneOrManyMap(rem, cur - cur / 2);
            }
        }
        // tr(m, rem);
        pr(m.size() == 0 ? "YES" : "NO");
    }

    ///////////////////////////////////////////////////////
    // don't know
    void solve1(int n, long[] a) {
        long sum = 0;
        for (long x : a) sum += x;
        // tr(n, a, sum);
        ConcurrentSkipListMap<Long, Integer> m = counter(a); // treemap can be removed at the same time
        // for (int i = 0; i < 5; i++) {
        while (true) {
            boolean allOne = true;
            for (int v : m.values()) {
                if (v != 1) {
                    allOne = false;
                    break;
                }
            }
            if (allOne) break;
            for (long x : m.keySet()) {
                int occ = m.get(x);
                if (occ / 2 == 0) continue;
                addOneOrManyMap(m, x * 2, occ / 2);
                if (occ % 2 == 0) {
                    m.remove(x);
                } else {
                    m.put(x, 1);
                }
            }
        }
        // tr(m);
        long pre = -1;
        for (long x : m.keySet()) {
            if (pre != -1) {
                if (x - pre > 1) {
                    pr("NO");
                    return;
                }
            }
            pre = x;
        }
        pr("YES");
    }

    <T> void addOneOrManyMap(ConcurrentSkipListMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(ConcurrentSkipListMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    ConcurrentSkipListMap<Long, Integer> counter(long[] a) {
        ConcurrentSkipListMap<Long, Integer> m = new ConcurrentSkipListMap<>();
        for (long x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = fs.readArray(n);
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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