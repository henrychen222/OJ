/**
 * 08/07/23 noon/night
 * https://codeforces.com/contest/1857/problem/D
 */
package codeforce.cf.div3.y2023.r891;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1857/submission/217799238
    // RE (Comparison method violates its general contract!) ---- https://codeforces.com/contest/1857/submission/217799007
    void solve(int n, int[] a, int[] b) {
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{a[i] - b[i], i};
        // Arrays.sort(d, (x, y) -> y[0] - x[0]);
        Arrays.sort(d, (x, y) -> Integer.compare(y[0], x[0]));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n && d[i][0] == d[0][0]; i++) res.add(d[i][1] + 1);
        pr(res.size());
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
            solve(n, a, b);
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
        new D().run();
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
