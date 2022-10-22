/**
 * 06/15/22 morning
 * https://www.codechef.com/START43C/problems/JOINING
 */
package codechef.contest.start.c_43;

import java.util.*;
import java.io.*;

class JoiningDate {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int k) {
        int[] a = new int[n];
        for (int i = 0, x = 0; i < n; i++) {
            if (i % 5 == 0) x++;
            a[i] = x;
        }
        int[] old = Arrays.copyOf(a, n);
        // tr("old", old);
        int idx = k - 1;
        int pre = a[idx];
        for (int i = idx + 1; i < n; i++) {
            a[i] = pre;
            pre = old[i];
        }
        a[idx] = -1;
        // tr("new", a);
        int res = 0;
        for (int i = idx + 1; i < n; i++) {
            if (a[i] != old[i]) res++;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new JoiningDate().run();
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
