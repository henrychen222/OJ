/**
 * 02/08/23 morning
 * https://www.codechef.com/COOK144C/problems/TAKENOTLESS
 */
package codechef.contest.cook.y2023.c_144;

import java.util.*;
import java.io.*;

class TakeNotLess {
    static PrintWriter pw;
    final String FIRST = "Marichka";
    final String SECOND = "Zenyk";

    /*
     1 2 2      first win
     1 1 2 2    second win
     1 2 2 2    first win
     */
    // Accepted
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        // only every occ is even, second win
        // maxOcc odd always first win, everyone pick max in turn
        for (int occ : m.values()) {
            if (occ % 2 != 0) {
                pr(FIRST);
                return;
            }
        }
        pr(SECOND);
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.merge(x, 1, Integer::sum);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new TakeNotLess().run();
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
