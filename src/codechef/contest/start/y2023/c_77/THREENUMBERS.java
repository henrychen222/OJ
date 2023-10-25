/**
 * 02/15/23 morning 02/15/23 afternoon complete
 * https://www.codechef.com/START77C/problems/THREENUMBERS
 */
package codechef.contest.start.y2023.c_77;

import java.util.*;
import java.io.*;

class THREENUMBERS {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/89639918
    // reference: https://discuss.codechef.com/t/threenumbers-editorial/105254
    void solve(long[] a) {
        Arrays.sort(a);
        pr(a[0] % 2 == a[1] % 2 && a[0] % 2 == a[2] % 2 ? a[1] - a[0] + (a[2] - a[1]) / 2 : -1);
    }

    // WA
    void solve1(long[] a) {
        Arrays.sort(a);
        if (a[0] == a[1]) {
            long diff12 = a[2] - a[1];
            if (diff12 % 2 == 0) {
                pr(diff12 / 2);
            } else {
                pr(-1);
            }
        } else {
            long diff01 = a[1] - a[0];
            if (diff01 % 2 == 0) {
                long move = diff01 / 2;
                a[0] += move;
                a[2] += move;
                a[1] -= move;
            } else {
                pr(-1);
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long[] a = fs.readArray(3);
            solve(a);
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
        new THREENUMBERS().run();
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
