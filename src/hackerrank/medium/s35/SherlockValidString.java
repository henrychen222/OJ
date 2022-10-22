/**
 * 08/26/22 night
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
package hackerrank.medium.s35;

import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class SherlockValidString {
    static PrintWriter pw;

    // abcdefghhgfedecbae NO
    void solve(char[] s) {
        Map<Character, Integer> m = counter(s);
        List<Integer> res = new ArrayList<>(m.values());
        Map<Integer, Integer> m2 = counter2(res);
        // tr(m, res, m2);
        for (int x : m2.keySet()) {
            addOneOrManyMap(m2, x - 1);
            removeOneOrManyMap(m2, x);
            // tr(m2);
            if (m2.size() == 1) {
                pr("YES");
                return;
            }
            // withdraw
            addOneOrManyMap(m2, x);
            removeOneOrManyMap(m2, x - 1);
        }
        pr("NO");
    }

    Map<Character, Integer> counter(char[] s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s) m.put(c, m.getOrDefault(c, 0) + 1);
        return m;
    }

    Map<Integer, Integer> counter2(List<Integer> a) {
        Map<Integer, Integer> m = new ConcurrentHashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    <T> void addOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.readLine().toCharArray();
        solve(s);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new SherlockValidString().run();
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

        String readLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
