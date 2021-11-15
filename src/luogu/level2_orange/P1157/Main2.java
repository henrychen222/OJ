/**
 * 11/12/21 evening   11/13/21 afternoon fixed setw issue
 * https://www.luogu.com.cn/problem/P1157
 *
 * reference: https://www.luogu.com.cn/problem/solution/P1157
 */
package luogu.level2_orange.P1157;

import java.util.*;
import java.io.*;

class Main2 {
    static PrintWriter pw;

    int[] a;
    int r, n;

    // Accepted --- https://www.luogu.com.cn/record/62523986
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        r = fs.nextInt();
        a = new int[r + 1];
        dfs(1);
    }

    void dfs(int x) {
        // tr(x, a);
        int i;
        if (x > r) {
            for (i = 1; i <= r; i++) {
                pw.printf("%3d", a[i]); // stupid issue here  use https://bbs.csdn.net/topics/270013113
                // pw.print("   " + a[i]);
            }
            pr("");
            return;
        }
        for (i = a[x - 1] + 1; i <= n; i++) {
            a[x] = i;
            dfs(x + 1);
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
        new Main2().run();
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