/**
 * 05/25/25 morning
 * https://codeforces.com/problemset/problem/48/D
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class D48 {
    static PrintWriter pw;

    void solve(int[] a) {
        constructPermutationGreedy(a);
    }

    // Accepted --- https://codeforces.com/problemset/submission/48/321246906
    void constructPermutationGreedy(int[] a) {
        TreeMap<Integer, Integer> tm = counter(a);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        while (!tm.isEmpty()) {
            int target = cur.isEmpty() ? tm.lastKey() : cur.getLast() - 1;
//            tr(tm, target, cur, res, tm.containsKey(target));
            if (tm.containsKey(target)) {
                removeOneOrManyMap(tm, target);
                cur.add(target);
                if (target == 1) {
                    res.add(cur);
//                    tr(tm, target, cur, res);
//                    tr("close");
//                    cur.clear(); // issue
                    cur = new ArrayList<>();
                }
            } else {
                pr(-1);
                return;
            }
        }
//        tr(res);

        // build group index answer
        TreeMap<Integer, TreeSet<Integer>> m = counter_value_in_indexA_in(a);
        List<Integer> ia = new ArrayList<>();
        List<Integer> groups = new ArrayList<>();
        int group = 1, total = 0;
        for (var l : res) {
            for (int x : l) {
                total++;
                int idx = m.get(x).pollFirst();
//                tr(m, x, idx);
                ia.add(idx);
                groups.add(group);
            }
            group++;
        }
        int n = a.length;
        if (total != n) {
            pr(-1);
            return;
        }
//        tr(ia);
//        tr(groups);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[ia.get(i)] = groups.get(i);
        pr(res.size());
        outputA(ans);
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    TreeMap<Integer, TreeSet<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Integer, TreeSet<Integer>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new TreeSet<>()).add(i);
        return m;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(a);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new D48().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
