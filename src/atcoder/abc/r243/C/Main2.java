// 03/12/22 morning
package atcoder.abc.r243.C;

import java.util.*;
import java.io.*;

class Main2 {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc243/submissions/30083470
    // reference: https://atcoder.jp/contests/abc243/submissions/30031111
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) points[i] = fs.readArray(2);
        char[] s = fs.next().toCharArray();
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{points[i][1], points[i][0], s[i]}; // save 'L' 'R' in ascii
        Arrays.sort(d, (x, y) -> { // sort by Y first
            if (x[0] != y[0]) return x[0] - y[0];
            return x[1] - y[1];
        });
        for (int i = 0; i < n - 1; i++) {
            if (d[i][0] == d[i + 1][0] && d[i][2] == 'R' && d[i + 1][2] == 'L') {
                pr("Yes");
                return;
            }
        }
        pr("No");
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
        new Main2().run();
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