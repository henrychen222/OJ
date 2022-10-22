/**
 * 05/28/22 morning
 * https://atcoder.jp/contests/abc253/tasks/abc253_c
 */
package atcoder.abc.r253.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            int mark = fs.nextInt();
            if (mark == 1) {
                int x = fs.nextInt();
                addOneOrManyMap(m, x);
            } else if (mark == 2) {
                int x = fs.nextInt(), c = fs.nextInt();
                if (m.containsKey(x)) {
                    removeOneOrManyMap(m, x, Math.min(c, m.get(x)));
                }
            } else {
                pr(m.lastKey() - m.firstKey());
            }
        }
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}