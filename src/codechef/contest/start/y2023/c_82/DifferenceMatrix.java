/**
 * 03/22/23 morning
 * https://www.codechef.com/START82C/problems/MATDIF
 */
package codechef.contest.start.y2023.c_82;

import java.util.*;
import java.io.*;

class DifferenceMatrix {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
//        int[][] example = {{12, 10, 6, 14}, {3, 8, 4, 1}, {5, 15, 11, 9}, {2, 7, 13, 16}};
//        tr(test(example));
        int[][] g = new int[n][n];
        int v = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    g[i][j] = v++;
                } else {
                    g[i][n - j - 1] = v++;
                }
            }
        }
        // tr(g);
        if (n % 2 == 0) {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 != 0) {
                        swap(g, i, j, i + 1, j);
                    }
                }
                swap(g, i, 0, i, n - 1);
            }
            // tr(test(g), g);
            for (int i = 0; i < n / 2; i += 2) { // reverse the even row
                for (int j = 0; j < n; j++) {
                    swap(g, i, j, n - 1 - i, j);
                }
            }
            for (int j = 0; j < n; j++) { // make middle row valid
                swap(g, 0, j, n / 2 + 1, j);
                swap(g, n - 1, j, n / 2, j);
                swap(g, 0, j, n / 2 + 1, j);
            }
        } else {
            for (int i = 1; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 != 0) {
                        swap(g, i, j, i - 1, j);
                    }
                }
                swap(g, i, 0, i, n - 1);
            }
            for (int j = 0; j < n; j++) { // last row
                if (j % 2 != 0) {
                    swap(g, 0, j, n - 1, j);
                }
            }
            // tr(test(g), g);
            for (int i = 1; i < n / 2; i += 2) { // reverse the even row
                for (int j = 0; j < n; j++) {
                    swap(g, i, j, n - 1 - i, j);
                }
            }
            // tr(test(g), g);
            for (int j = 0; j < n; j++) { // make middle row valid
                swap(g, 0, j, n / 2, j);
                swap(g, n - 2, j, n / 2 - 1, j);
                swap(g, 0, j, n / 2 - 1, j);
            }
        }
        // tr(test(g), g);
        outputGrid(g);
    }

    void swap(int[][] g, int i, int j, int x, int y) {
        int tmp = g[i][j];
        g[i][j] = g[x][y];
        g[x][y] = tmp;
    }

    void outputGrid(int[][] g) {
        for (int[] a : g) {
            for (int x : a) pw.print(x + " ");
            pr("");
        }
    }

    boolean test(int[][] g) {
        int n = g.length;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ts.add(g[i][j]);
                List<Integer> vs = new ArrayList<>();
                if (i + 1 < n) vs.add(g[i + 1][j]);
                if (i - 1 >= 0) vs.add(g[i - 1][j]);
                if (j + 1 < n) vs.add(g[i][j + 1]);
                if (j - 1 >= 0) vs.add(g[i][j - 1]);
                if (i + 1 < n && j + 1 < n) vs.add(g[i + 1][j + 1]);
                if (i - 1 >= 0 && j + 1 < n) vs.add(g[i - 1][j + 1]);
                if (i + 1 < n && j - 1 >= 0) vs.add(g[i + 1][j - 1]);
                if (i - 1 >= 0 && j - 1 >= 0) vs.add(g[i - 1][j - 1]);
                for (int v : vs) {
                    if (Math.abs(v - g[i][j]) <= 1) {
                        tr(n + " invalid ", v, g[i][j]);
                        return false;
                    }
                }
            }
        }
        int v = 1;
        for (int x : ts) {
            if (x != v++) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new DifferenceMatrix().run();
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
