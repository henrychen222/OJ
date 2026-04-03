/**
 * 06/14/25 morning
 * https://codeforces.com/problemset/problem/22/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/22/submission/324376099
public class B22 {
    static PrintWriter pw;

    /*
    find the maximal perimeter of a rectangle that contains no '1'

    first case 2 * (1 + 3) = 8
    000

    second case  2 * (4 + 4) = 16
    0000
    0000
    0000
    0000
     */
    void solve(int n, int m, char[][] g) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int xl = 1; i + xl - 1 < n; xl++) {
                    for (int yl = 1; j + yl - 1 < m; yl++) {
//                        boolean valid = traverseBorder(g, i, j);
                        boolean valid = traverseArea(g, i, j, xl, yl);
                        int perimeter = 2 * (xl + yl);
//                        tr(new int[]{i, j}, xl, yl, "perimeter", perimeter);
                        if (valid) {
                            res = Math.max(res, perimeter);
                        }
//                        pr("");
                    }
                }
            }
        }
        pr(res);
    }

//    boolean traverseBorder(char[][] g, int x, int y) { // (x, y) is top left corner
//        int n = g.length, m = g[0].length;
//        while (y < m - 1) {
//            tr("R", x, y);
//            if (g[x][y] == '1') return false;
//            y++;
//        }
//        while (x < n - 1) {
//            tr("D", x, y);
//            if (g[x][y] == '1') return false;
//            x++;
//        }
//        while (y > 0) {
//            tr("L", x, y);
//            if (g[x][y] == '1') return false;
//            y--;
//        }
//        while (x > 0) {
//            tr("U", x, y);
//            if (g[x][y] == '1') return false;
//            x--;
//        }
//        return true;
//    }

    boolean traverseArea(char[][] g, int x, int y, int xl, int yl) { // (x, y) is top left corner
//        tr(new int[]{x, y}, x + xl - 1, y + yl - 1);
        for (int i = x; i <= x + xl - 1; i++) {
            for (int j = y; j <= y + yl - 1; j++) {
                if (g[i][j] == '1') return false;
            }
        }
        return true;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        solve(n, m, g);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B22().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
