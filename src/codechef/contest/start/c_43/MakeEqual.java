/**
 * 06/15/22 noon
 * https://www.codechef.com/START43C/problems/MAKEQUAL
 */
package codechef.contest.start.c_43;

import java.util.*;
import java.io.*;

class MakeEqual {
    static PrintWriter pw;

    void solve(int[] a) {
        boolean ok = false;
        for (int i = 0; i < 40; i++) {
            if (a[0] == a[1] && a[1] == a[2]) {
                ok = true;
                break;
            }
        }
    }

    /////////////////////////////////////////////////////////////////
    // WA https://www.codechef.com/viewsolution/66961809
    void solve1(int[] a) {
        Arrays.sort(a);
//        tr(a);
        for (int i = 1; i < 3; i++) {
            int d = a[i] - a[i - 1];
            if (d == 0) continue;
            if (!ok(d)) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    boolean ok(int x) {
        String s = Integer.toBinaryString(x);
        // tr("x", x, s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
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
        new MakeEqual().run();
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
