/**
 * 04/23/26 night
 * https://codeforces.com/problemset/problem/53/D
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class D53 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/53/372330843
    // reference: uwi
    void solve(int n, int[] a, int[] b) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && b[j] != a[i]) {
                j++;
            }
            // swap b[j] to b[i]
            for (int k = j; k > i; k--) {
                res.add(new int[]{k - 1, k});
                swap(b, k, k - 1);
            }
        }
//        tr(b, Arrays.equals(a, b));
        if (res.isEmpty()) {
            pr(0);
        } else {
            pr(res.size());
            for (int[] e : res) pr((e[0] + 1) + " " + (e[1] + 1));
        }
    }

    // Accepted --- https://codeforces.com/problemset/submission/53/372329497
    // reference: https://codeforces.com/blog/entry/1065
    void solve1(int n, int[] a, int[] b) {
        List<int[]> res = new ArrayList<>();
        Map<Integer, TreeSet<Integer>> m = counter_value_in_indexA_in(b);
        for (int i = 0; i < n; i++) {
            if (m.containsKey(a[i])) {
                // swap b[j] to b[i]  j > i
                Integer j = m.get(a[i]).higher(i);
                if (j != null) {
                    m.get(a[i]).remove(j);
                    for (int k = j; k > i; k--) {
                        res.add(new int[]{k - 1, k});
                        swapWithMap(b, k, k - 1, m);
                    }
                }
            }
        }
//        tr(b, Arrays.equals(a, b));
        if (res.isEmpty()) {
            pr(0);
        } else {
            pr(res.size());
            for (int[] e : res) pr((e[0] + 1) + " " + (e[1] + 1));
        }
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    Map<Integer, TreeSet<Integer>> counter_value_in_indexA_in(int[] a) {
        Map<Integer, TreeSet<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new TreeSet<>()).add(i);
        return m;
    }

    void swapWithMap(int[] a, int i, int j, Map<Integer, TreeSet<Integer>> m) {
        // do swap, original index in b changed, need update map
        m.get(a[i]).remove(i);
        m.get(a[j]).remove(j);
        m.get(a[i]).add(j);
        m.get(a[j]).add(i);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n);
        solve(n, a, b);
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
        new D53().run();
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