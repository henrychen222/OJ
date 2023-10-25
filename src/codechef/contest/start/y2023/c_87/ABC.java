/**
 * 04/26/23 morning
 * https://www.codechef.com/START87C/problems/ABPLUSC
 */
package codechef.contest.start.y2023.c_87;

import java.util.*;
import java.io.*;

class ABC {
    static PrintWriter pw;

    // Accepted
    void solve(long x) {
        double sq = Math.sqrt(x);
        long a = (long) Math.floor(sq);
        long down = a - 1, up = a + 1;
        long c = x - a * a, c2 = x - a * down, c3 = x - down * down, c4 = x - a * up;
//        tr(a, a, c);
//        tr(a, down, c2);
//        tr(down, down, c3);
        if (inRange(a) && inRange(c)) {
            pr(a + " " + a + " " + c);
            return;
        }
        if (inRange(a) && inRange(down) && inRange(c2)) {
            pr(a + " " + down + " " + c2);
            return;
        }
        if (inRange(down) && inRange(c3)) {
            pr(down + " " + down + " " + c3);
            return;
        }
        if (inRange(a) && inRange(up) && inRange(c4)) {
            pr(a + " " + up + " " + c4);
            return;
        }
        pr(-1);
    }

    boolean inRange(long x) {
        return x >= 1 && x <= 1000000;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long x = fs.nextLong();
            solve(x);
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
        new ABC().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
