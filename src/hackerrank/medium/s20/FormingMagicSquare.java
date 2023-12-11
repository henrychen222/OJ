/**
 * 12/07/23 morning
 * https://www.hackerrank.com/challenges/magic-square-forming
 */
package hackerrank.medium.s20;

import java.util.*;
import java.io.*;

// Accepted --- https://www.hackerrank.com/challenges/magic-square-forming/submissions/code/359568523
public class FormingMagicSquare {
    static PrintWriter pw;

    /*
     2 2 7
     8 6 4
     1 2 9
     */
    void solve(int[][] g) {
        int[] a = new int[9];
        int p = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[p++] = g[i][j];
            }
        }
        int[] u = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = Integer.MAX_VALUE;
        do {
            int cost = cal(a, u);
            if (isMagic(u)) {
                res = Math.min(res, cost);
            }
        } while (next_permutation(u));
        pr(res);
    }

    boolean isMagic(int[] a) {
        int row0 = a[0] + a[1] + a[2],
                row1 = a[3] + a[4] + a[5],
                row2 = a[6] + a[7] + a[8],
                col0 = a[0] + a[3] + a[6],
                col1 = a[1] + a[4] + a[7],
                col2 = a[2] + a[5] + a[8],
                diag1 = a[0] + a[4] + a[8],
                diag2 = a[2] + a[4] + a[6];
        int[] d = {row0, row1, row2, col0, col1, col2, diag1, diag2};
        Set<Integer> se = new HashSet<>();
        for (int x : d) se.add(x);
        return se.size() == 1;
    }

    int cal(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < 9; i++) sum += Math.abs(a[i] - b[i]);
        return sum;
    }

    boolean next_permutation(int[] a) {
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[][] g = new int[3][];
        for (int i = 0; i < 3; i++) g[i] = fs.readArray(3);
        solve(g);
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
        new FormingMagicSquare().run();
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
