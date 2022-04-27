/**
 * 04/23/22 morning
 * https://www.acwing.com/problem/content/4414/
 */
package acwing.r48.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    // reference: https://www.acwing.com/solution/content/112746/
    void solve(int n, int x) {
        int[][] res = {{0, 1, 2}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}, {0, 2, 1}};
        pr(res[n % 6][x]);
    }

    //////////////////////////////////////////////////////
    /*
     4  4  4
     2  0  1

     1  2  0
     */
    void solve1(int n, int x) {
        // test();
        int back = n % 3;
        // tr("rem", back, x);
        if (back == 0) {
            // pr(moveBackwardTwo(x));
            // pr(moveBackwardOne(x));
            pr(keep(x));
        } else if (back == 1) {
            pr(moveBackwardOne(x));
        } else if (back == 2) {
            pr(moveBackwardTwo(x));
        }
    }

    int keep(int cur) {
        if (cur == 0) {
            return 2;
        } else if (cur == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    int moveBackwardOne(int cur) {
        if (cur == 0) {
            return 2;
        } else if (cur == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    int moveBackwardTwo(int cur) {
        if (cur == 0) {
            return 1;
        } else if (cur == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    void test() {
//        int[] a = {1, 0, 0};
//        int[] a = {0, 1, 0};
        int[] a = {0, 0, 1};
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) { // mid right
                swap(a, 1, 2);
            } else { // mid left
                swap(a, 1, 0);
            }
            tr(i, a);
        }
        tr("a", a);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), x = fs.nextInt();
        solve(n, x);
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