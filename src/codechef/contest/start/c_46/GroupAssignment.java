/**
 * 07/06/22 morning
 * https://www.codechef.com/START46C/problems/GRPASSN
 */
package codechef.contest.start.c_46;

import java.util.*;
import java.io.*;

class GroupAssignment {
    static PrintWriter pw;

    /*
     WA
     https://www.codechef.com/viewsolution/68322602
     https://www.codechef.com/viewsolution/68325022
     https://www.codechef.com/viewsolution/68384994
     */
    // Accepted
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a), arrange = new TreeMap<>();
        // tr("m", m, "arrange", arrange);
        int[] u = removeDuplicatedSorted(a);
        for (int x : u) {
            int occ = m.get(x);
            if (occ < x) {
                pr("NO");
                return;
            }
            while (occ >= x) {
                removeOneOrManyMap(m, x, x);
                addOneOrManyMap(arrange, x, x);
                occ -= x;
            }
        }
        // tr("m", m, "arrange", arrange);
        pr(m.size() == 0 ? "YES" : "NO");

//        if (m.size() == 1) {
//            int x = m.keySet().iterator().next();
//            if (n % x == 0) {
//                pr("YES");
//            } else {
//                pr("NO");
//            }
//            return;
//        }
//        for (int k : m.keySet()) {
//            if (k != m.get(k)) {
//                pr("NO");
//                return;
//            }
//        }
//        pr("YES");
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

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
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
        new GroupAssignment().run();
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
