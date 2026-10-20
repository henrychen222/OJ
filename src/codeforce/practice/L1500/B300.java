/**
 * 10/20/26 noon
 * https://codeforces.com/problemset/problem/300/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B300 {
    static PrintWriter pw;

    // Accepted
    // reference: https://codeforces.com/blog/entry/7497 + deepseek
    void solve(int n, int m, int[][] like) {
        DJSet ds = new DJSet(n);
        for (int[] e : like) ds.union(e[0] - 1, e[1] - 1);
        int ct = ds.count();
        List<List<Integer>> groups = ds.grp();
        // tr("cnt", ct, groups);
        List<List<Integer>> threes = new ArrayList<>();   // size 3
        List<List<Integer>> twos = new ArrayList<>();   // size 2
        List<Integer> ones = new ArrayList<>();   // size 1 (single vertex)

        for (List<Integer> g : groups) {
            if (g.isEmpty()) continue;
            if (g.size() > 3) { // component too big
                pr(-1);
                return;
            }
            if (g.size() == 3) {
                threes.add(g);
            } else if (g.size() == 2) {
                twos.add(g);
            } else {
                ones.add(g.getFirst());
            }
        }

        // Each size-2 component must pair with a size-1 student
        if (twos.size() > ones.size()) {
            pr(-1);
            return;
        }

        List<int[]> teams = new ArrayList<>();

        // Size-3 components are complete teams
        for (List<Integer> g : threes) {
            teams.add(new int[]{g.get(0) + 1, g.get(1) + 1, g.get(2) + 1});
        }

        // Pair each size-2 with one size-1
        int idx = 0;
        for (List<Integer> g : twos) {
            int single = ones.get(idx++) + 1;
            teams.add(new int[]{g.get(0) + 1, g.get(1) + 1, single});
        }

        // Remaining size-1 students: group in triples
        int remaining = ones.size() - idx;
        if (remaining % 3 != 0) {
            pr(-1);
            return;
        }
        for (int i = idx; i < ones.size(); i += 3) {
            teams.add(new int[]{ones.get(i) + 1, ones.get(i + 1) + 1, ones.get(i + 2) + 1});
        }

        // Output
        for (int[] t : teams) pw.println(t[0] + " " + t[1] + " " + t[2]);
    }

    class DJSet {
        int[] p;
        int n;

        DJSet(int n) {
            this.p = new int[n];
            this.n = n;
            Arrays.fill(p, -1);
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (p[x] < p[y]) {
                int d = x;
                x = y;
                y = d;
            }
            p[x] += p[y];
            p[y] = x;
            return true;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            for (int u : p) if (u < 0) cnt++;
            return cnt;
        }

        List<List<Integer>> grp() {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());
            for (int i = 0; i < n; i++) g.get(find(i)).add(i);
            return g;
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] like = new int[m][];
        for (int i = 0; i < m; i++) like[i] = fs.readArray(2);
        solve(n, m, like);
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
        new B300().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
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