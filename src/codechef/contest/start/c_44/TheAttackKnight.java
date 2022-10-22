/**
 * 06/22/22 morning
 * https://www.codechef.com/START44C/problems/KNIGHTATTACK
 */
package codechef.contest.start.c_44;

import java.util.*;
import java.io.*;

class TheAttackKnight {
    static PrintWriter pw;

    // Accepted
    void solve(int x1, int y1, int x2, int y2) {
        // tr(x1, y1, x2, y2);
        int[][] A = canAttack(x1, y1), B = canAttack(x2, y2);
        // tr(A, B);
        for (int[] a : A) {
            for (int[] b : B) {
                if (a[0] == b[0] && a[1] == b[1]) {
                    if (inRange(a[0]) && inRange(a[1])) {
                        pr("YES");
                        return;
                    }
                }
            }
        }
        pr("NO");
    }

    boolean inRange(int x) {
        return x >= 1 && x <= 8;
    }

    int[][] canAttack(int x, int y) {
        int[] dx = new int[]{-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = new int[]{-2, 2, -2, 2, -1, 1, -1, 1};
        int[][] res = new int[8][];
        int p = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            res[p++] = new int[]{nx, ny};
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            int[] b = fs.readArray(2);
            solve(a[0], a[1], b[0], b[1]);
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
        new TheAttackKnight().run();
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
