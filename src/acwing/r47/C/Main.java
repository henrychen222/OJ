/**
 * 04/16/22 morning
 * https://www.acwing.com/problem/content/4404/
 */
package acwing.r47.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    int[] a;

    // Accepted
    // reference: https://www.acwing.com/solution/content/111576/
    void solve(int n) {
        List<Integer> res = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            boolean ok = true;
            for (int i = k + 1; i <= n; i++) {
                if (a[i] - a[i - 1] != a[i - k] - a[i - k - 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) res.add(k);
        }
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
        a = new int[1005];
        int n = fs.nextInt();
        fs.readArray(n);
        solve(n);
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

        void readArray(int n) {
            for (int i = 1; i <= n; i++) a[i] = nextInt();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}