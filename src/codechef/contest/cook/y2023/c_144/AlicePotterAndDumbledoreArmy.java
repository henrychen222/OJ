/**
 * 02/08/23 morning
 * https://www.codechef.com/COOK144C/problems/DUMBLEDORE
 */
package codechef.contest.cook.y2023.c_144;

import java.util.*;
import java.io.*;

class AlicePotterAndDumbledoreArmy {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/88731146
    // reference: https://www.codechef.com/viewsolution/88543446
    void solve(int n, int m, int[][] g) {
        long[] sum = new long[n];
        long res = 0;
        for (int i = 0; i < m; i++) {
            sum[g[i][0] - 1] += g[i][1];
            res += sum[g[i][0] - 1];
            pr(res);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] g = new int[m][];
        for (int i = 0; i < m; i++) g[i] = fs.readArray(2);
        solve(n, m, g);
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
        new AlicePotterAndDumbledoreArmy().run();
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
