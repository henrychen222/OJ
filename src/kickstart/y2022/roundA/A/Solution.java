/**
 * 03/19/22 night
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e7021
 */
package kickstart.y2022.roundA.A;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted
    void solve(char[] I, char[] P) { // order also matters
        int n = I.length, m = P.length;
        int start = 0;
        for (char c : I) {
            boolean find = false;
            for (int i = start; i < m; i++) {
                if (P[i] == c) {
                    find = true;
                    start = i + 1;
                    break;
                }
            }
            if (!find) {
                pr("IMPOSSIBLE");
                return;
            }
        }
        pr(m - n);
    }

    // WA (AC Test Set 1)
    void solve2(char[] I, char[] P) {
        Map<Character, Integer> mi = counter(I), mp = counter(P);
        for (char c : mi.keySet()) {
            if (!mp.containsKey(c)) {
                pr("IMPOSSIBLE");
                return;
            } else {
                int occi = mi.get(c), occp = mp.get(c);
                if (occi > occp) {
                    pr("IMPOSSIBLE");
                    return;
                }
            }
        }
        // all chars in I occurs in P, and occI <= occP
        long res = 0;
        for (char c : mp.keySet()) {
            res += mp.get(c) - mi.getOrDefault(c, 0);
        }
        pr(res);
    }

    Map<Character, Integer> counter(char[] a) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    // WA (AC Test Set 1)
    void solve1(char[] I, char[] P) {
        long[] a = new long[128], b = new long[128];
        for (char c : I) a[c]++;
        for (char c : P) b[c]++;
        long res = 0;
        for (int i = 0; i < 128; i++) {
            if (b[i] < a[i]) {
                pr("IMPOSSIBLE");
                return;
            }
            res += b[i] - a[i];
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            char[] I = fs.next().toCharArray(), P = fs.next().toCharArray();
            solve(I, P);
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
        new Solution().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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