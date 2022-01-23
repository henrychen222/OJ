/**
 * 11/21/21 afternoon
 * https://csacademy.com/contest/archive/task/anagrams/
 */
package fii.practice.medium.SortingSteps;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://csacademy.com/submission/3555712/
    // reference: https://csacademy.com/submission/390174/
    void solve(int n, int[] a) {
        int[][] b = new int[n][];
        for (int i = 0; i < n; i++) b[i] = new int[]{a[i], i};
        Arrays.sort(b, (x, y) -> x[0] - y[0]);
        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res, b[i][1] - i);
        pr(res + 1);
    }

    // TLE https://csacademy.com/submission/3555711/
    void solve2(int n, int[] a) {
        int steps = 0;
        while (true) {
            steps++;
            boolean isSorted = true;
            for (int i = 0; i + 1 < n; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        pr(steps);
    }

    // wrong
    void solve1(int n, int[] a) {
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        Map<Integer, ArrayList<Integer>> ma = counter_value_in_indexA_in(a);
        Map<Integer, ArrayList<Integer>> mb = counter_value_in_indexA_in(b);
        tr(a, ma);
        tr(b, mb);
        long res = 0;
        for (int x : ma.keySet()) {
            List<Integer> la = ma.get(x);
            List<Integer> lb = mb.get(x);
            int len = la.size();
            for (int i = 0; i < len; i++) {
                if (la.get(i) != lb.get(i)) res++;
                // res += Math.abs(la.get(i) - lb.get(i));
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    Map<Integer, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i);
        }
        return m;
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
        new Main().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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