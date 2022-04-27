/**
 * 04/23/22 morning
 * https://atcoder.jp/contests/abc249/tasks/abc249_a
 */
package atcoder.abc.r249.A;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt(), d = fs.nextInt(), e = fs.nextInt(), f = fs.nextInt(), x = fs.nextInt();
        int sec1 = op(a, c, x), sec2 = op(d, f, x);
        int dis1 = sec1 * b, dis2 = sec2 * e;
        // tr("sec1", sec1, dis1, "sec2", sec2, dis2);
        if (dis1 < dis2) {
            pr("Aoki");
        } else if (dis1 > dis2) {
            pr("Takahashi");
        } else {
            pr("Draw");
        }
    }

    /*
     WA:
     fuck, only 1 failed
     https://atcoder.jp/contests/abc249/submissions/31205608
     https://atcoder.jp/contests/abc249/submissions/31209269
     https://atcoder.jp/contests/abc249/submissions/31209927
     */
    int op(int walk, int rest, int x) {
        // tr(walk, rest, x);
        int round = x / (walk + rest);
        int rem = x % (walk + rest);
        if (round == 0) round = 1;
        // tr(round, rem);
        return round * walk + (rem < x ? rem : 0);
        // return walk + (x % (walk + rest) == x ? 0 : x % (walk + rest));
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