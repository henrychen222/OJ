/**
 * 03/22/23 morning
 * https://www.codechef.com/START82C/problems/MAKE_AB_SAME
 */
package codechef.contest.start.y2023.c_82;

import java.util.*;
import java.io.*;

class MakeABSame {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a, int[] b) {
        TreeSet<Integer> zero = new TreeSet<>(), one = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero.add(i);
            } else {
                one.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                // tr(i, a[i], b[i]);
                if (i == 0 || i == n - 1) {
                    pr("NO");
                    return;
                }
                if (a[i] == 0) { // 0 -> 1
                    if (one.lower(i) == null && one.higher(i) == null) {
                        pr("NO");
                        return;
                    }
                } else { // 1 -> 0
                    pr("NO");
                    return;
                }
            }
        }
        pr("YES");
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
        new MakeABSame().run();
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
