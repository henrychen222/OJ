/**
 * 03/01/23 morning
 * https://www.codechef.com/START79C/problems/PRIMEFACT
 */
package codechef.contest.start.y2023.c_79;

import java.util.*;
import java.io.*;

class OneStoneTwoStones {
    static PrintWriter pw;
    final String FIRST = "CHEF";
    final String SECOND = "CHEFINA";

    // Accepted --- https://www.codechef.com/viewsolution/91219769  (03/01/23 night complete)
    // reference: https://discuss.codechef.com/t/oneortwo-editorial/105396
    void solve(int x, int y) {
        if (x > y + 1) {
            pr(FIRST);
        } else if (x == y + 1) {
            pr(x % 2 == 0 ? FIRST : SECOND);
        } else if (x + 1 < y) {
            pr(SECOND);
        } else {
            pr(x % 2 == 0 ? SECOND : FIRST);
        }
    }

    /////////////////////////////////////////////////////////
    // WA
    void solve2(int x, int y) {
        boolean flag = true;
        if (x != 1 && y != 1) {
            int min = Math.min(x, y) - 1;
            if (min % 2 != 0) flag = false;
            x -= min;
            y -= min;
        }
        // tr(x, y, flag);
        if (flag) {
            work(x, y, FIRST, SECOND);
        } else {
            work(x, y, SECOND, FIRST);
        }
    }

    void work(int x, int y, String first, String second) {
        if (x == 1) {
            if (y == 1) {
                pr(first);
            } else {
                pr(y >= 3 ? second : first);
            }
        } else {
            pr(x >= 3 ? first : second);
        }
    }

    // WA
    void solve1(int x, int y) {
        if (x < y) {
            pr(SECOND);
        } else if (x > y) {
            pr(FIRST);
        } else {
            pr(x % 2 != 0 ? FIRST : SECOND);
        }
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
        new OneStoneTwoStones().run();
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

