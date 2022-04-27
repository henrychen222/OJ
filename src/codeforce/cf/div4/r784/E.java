/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/E
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

public class E {
    static PrintWriter pw;

    // Accepted
    void solve(int n, String[] a) {
        Map<String, List<Integer>> m = counter_value_in_indexA_in(a);
        // tr(n, a, m);
        long res = 0;
        for (int i = 0; i < n; i++) {
            String s = a[i];
            Set<String> pt = possibleT(s);
            for (String t : pt) {
                if (m.containsKey(t)) {
                    List<Integer> l = m.get(t);
                    int j = upper_bound(l, i);
                    // tr(s, t, l, j);
                    res += l.size() - j;
                }
            }
        }
        pr(res);
    }

    Set<String> possibleT(String s) {
        Set<String> se = new HashSet<>();
        for (char c1 = 'a'; c1 <= 'k'; c1++) {
            for (char c2 = 'a'; c2 <= 'k'; c2++) {
                String t = "" + c1 + c2;
                if (c1 == s.charAt(0) && c2 != s.charAt(1)) se.add(t);
                if (c1 != s.charAt(0) && c2 == s.charAt(1)) se.add(t);
            }
        }
        return se;
    }

    int upper_bound(List<Integer> a, int x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    Map<String, List<Integer>> counter_value_in_indexA_in(String[] a) {
        Map<String, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i + 1);
        }
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String[] a = fs.readArray(n);
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
        new E().run();
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

        String[] readArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = next();
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