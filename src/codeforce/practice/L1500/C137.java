/**
 * 01/13/25 morning
 * https://codeforces.com/problemset/problem/137/C
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class C137 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/137/300876621
    void solve(int n, int[][] events) {
        Arrays.sort(events, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });
//        tr(events);
        int res = 0;
        TreeSet<Integer> traceMax = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int end = events[i][1];
            if (!traceMax.isEmpty() && end <= traceMax.last()) res++;
            traceMax.add(end);
        }
        pr(res);
    }


    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] events = new int[n][];
        for (int i = 0; i < n; i++) events[i] = fs.readArray(2);
        solve(n, events);
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
        new C137().run();
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
