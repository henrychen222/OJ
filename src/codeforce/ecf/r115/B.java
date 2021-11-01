/**
 * 10/09/21 night
 * https://codeforces.com/contest/1598/problem/B
 */
package codeforce.ecf.r115;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted
    void solve(int n, int[][] g) {
        // tr(n, g);
        int h = n / 2;
        List<List<Integer>> a = initializeGraph(5);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (g[i][j] == 1) a.get(j).add(i + 1);
            }
        }
        // tr(a);
        for (int i = 0; i < 5; i++) {
            List<Integer> ai = a.get(i);
            if (ai.size() < h) continue;
            for (int j = 0; j < 5; j++) {
                List<Integer> aj = a.get(j);
                if (i == j || aj.size() < h) continue;
                Set<Integer> se = new HashSet<>(ai);
                for (int x: aj) se.add(x);
                // tr(i, j, se);
                int expect_sum = cal(n);
                int sum = 0;
                for (int x : se) sum += x;
                if (sum == expect_sum) {
                    pr("YES");
                    return;
                }
            }
        }
        pr("NO");
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    int cal(int n) {
        return n * (n + 1) / 2;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[][] g = new int[n][5];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    g[i][j] = fs.nextInt();
                }
            }
            solve(n, g);
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
        new B().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
