/**
 * 10/22/22 morning
 * https://www.acwing.com/problem/content/4710/
 */
package acwing.r74.A;

import java.util.*;
import java.io.*;

// Accepted
class Main {
    static PrintWriter pw;

    /*
     6
     744 359 230 586 944 442
     */
    void solve(int n, int[] a) {
        int res = Math.abs(a[0] - a[n - 1]);
        for (int i = 1; i < n; i++) res = Math.min(res, Math.abs(a[i] - a[i - 1]));
        pr(res);
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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