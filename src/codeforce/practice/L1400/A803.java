/**
 * 09/10/23 night
 * https://codeforces.com/problemset/problem/803/A
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class A803 {
    static PrintWriter pw;

    // 4 14
    // Accepted --- https://codeforces.com/problemset/submission/803/222868953
    // reference: um_nik
    void solve(int n, int k) {
        if (k > n * n) {
            pr(-1);
            return;
        }
        int[][] g = new int[n][n];
        for (int i = 0; k > 0 && i < n; i++) {
            g[i][i] = 1;
            k--;
            for (int j = i + 1; k > 1 && j < n; j++) {
                g[i][j] = g[j][i] = 1;
                k -= 2;
            }
        }
        outputGrid(g);
    }

    List<List<int[]>> diagonal_traverse_with_middle_bottomLeft_to_topRight_coordinates(int[][] g) {
        int n = g.length, m = g[0].length;
        List<List<int[]>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<int[]> cur = new ArrayList<>();
            for (int y = 0; i - y >= 0 && y < m; y++) cur.add(new int[]{i - y, y});
            res.add(cur);
        }
        for (int j = 1; j < m; j++) {
            List<int[]> cur = new ArrayList<>();
            for (int x = n - 1, y = 0; x >= 0 && j + y < m; x--, y++) cur.add(new int[]{x, j + y});
            res.add(cur);
        }
        return res;
    }

    void outputGrid(int[][] g) {
        for (int[] a : g) {
            for (int x : a) pw.print(x + " ");
            pr("");
        }
    }

    void debugArrayInListOfList(List<List<int[]>> l) {
        List<List<List<Integer>>> res = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            List<List<Integer>> g = new ArrayList<>();
            for (int j = 0; j < l.get(i).size(); j++) {
                int[] cur = l.get(i).get(j);
                List<Integer> list = new ArrayList<>() {{
                    add(cur[0]);
                    add(cur[1]);
                }};
                g.add(list);
            }
            res.add(g);
        }
        tr("out", res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(2);
        solve(a[0], a[1]);
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
        new A803().run();
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