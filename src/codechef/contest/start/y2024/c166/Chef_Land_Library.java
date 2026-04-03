/**
 * 12/25/24 morning
 * https://www.codechef.com/START166C/problems/BORROWBOOK
 */
package codechef.contest.start.y2024.c166;

import java.util.*;
import java.io.*;

class Chef_Land_Library {
    static PrintWriter pw;

    // Accepted
    void solve(int[] a) {
        Map<Integer, ArrayList<Integer>> m = counter_value_in_indexA_in(a);
//        tr(m);
        long res = 0;
        for (int x : m.keySet()) {
            int highest = m.get(x).getLast() + 1;
            res += highest;
        }
        pr(res);
    }

    Map<Integer, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new ArrayList<>()).add(i);
        return m;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(a);
        }
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
        new Chef_Land_Library().run();
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

