/**
 * 10/22/22 morning
 * https://atcoder.jp/contests/abc274/tasks/abc274_b
 */
package atcoder.abc.r274.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    void solve(int n, int m, char[][] g) {
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (g[j][i] == '#') cnt++;
            }
            pw.print(cnt + " ");
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(2);
        char[][] g = new char[a[0]][];
        for (int i = 0; i < a[0]; i++) g[i] = fs.nextLine().toCharArray();
        solve(a[0], a[1], g);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new Main().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}