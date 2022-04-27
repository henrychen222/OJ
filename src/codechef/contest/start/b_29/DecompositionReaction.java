/**
 * 03/09/22 morning
 * https://www.codechef.com/START29B/problems/DCP
 */
package codechef.contest.start.b_29;

import java.util.*;
import java.io.*;

// Accepted --- https://www.codechef.com/viewsolution/60042123
class DecompositionReaction {
    static PrintWriter pw;
    private final int mod = (int) (1e9 + 7);
    TreeMap<Integer, Long> m;
    int[] q;

    void solve(int compound, int[] equation) {
        int n = equation.length;
        long compoundAmount = m.getOrDefault(compound, 0L);
        for (int i = 1; i < n; i += 2) {
            int decompoundAmount = equation[i - 1], decompound = equation[i];
            long cnt = decompoundAmount * compoundAmount;
            cnt %= mod;
            // tr("cnt", cnt);
            addOneOrManyMap(m, decompound, cnt);
        }
        m.remove(compound);
    }

    <T> void addOneOrManyMap(TreeMap<T, Long> m, T x, long... args) {
        long cnt = args.length == 0 ? 1 : args[0];
        long newCnt = mod_add(m.getOrDefault(x, 0L), cnt);
        m.put(x, newCnt);
    }

    long mod_add(long x, long y) {
        x += y;
        if (x >= mod) x %= mod;
        return x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), M = fs.nextInt();
        q = fs.readArray(n);
        m = new TreeMap();
        for (int com = 1; com <= n; com++) m.put(com, (long) q[com - 1]);
//        tr("initial", m);
        for (int i = 0; i < M; i++) {
            int compound = fs.nextInt(), x = fs.nextInt();
            int[] equation = fs.readArray(2 * x);
            // tr("process", m, "compound", compound, "equation", equation);
            solve(compound, equation);
        }
        // tr("final", m);
        for (int com = 1; com <= n; com++) pr(m.getOrDefault(com, 0L));
    }

    /*
     {1=5, 2=10, 3=12, 4=2}
     {2=25, 3=12, 4=2}
     {2=25, 4=66}
     */

//    void sum() {
//        long res = 0;
//        for (long v : m.values()) res += v;
//        pr(res);
//    }

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
        new DecompositionReaction().run();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
