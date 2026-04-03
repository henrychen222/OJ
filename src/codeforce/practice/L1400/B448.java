/**
 * 06/13/24 evening
 * https://codeforces.com/problemset/problem/448/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B448 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/448/265695864
    void solve(char[] s, char[] t) {
        Map<Character, Integer> ms = counter(s), mt = counter(t);
        char[] sortS = Arrays.copyOf(s, s.length), sortT = Arrays.copyOf(t, t.length);
        if (canMakeByRemove(s, t)) {
            pr("automaton");
        } else if (canMakeBySwap(sortS, sortT)) {
            pr("array");
        } else if (canMakeBoth(ms, mt)) {
            pr("both");
        } else {
            pr("need tree");
        }
    }

    boolean canMakeBySwap(char[] s, char[] t) {
        Arrays.sort(s);
        Arrays.sort(t);
        return Arrays.equals(s, t);
    }

    // s -> t   => t is subsequence of s
    boolean canMakeByRemove(char[] s, char[] t) {
        return isSubsequence(s, t);
    }

    boolean isSubsequence(char[] s, char[] t) {
        int sn = s.length, tn = t.length, i = 0, j = 0;
        while (i < sn && j < tn) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == tn;
    }

    Map<Character, Integer> counter(char[] s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : s) m.merge(x, 1, Integer::sum);
        return m;
    }

    boolean canMakeBoth(Map<Character, Integer> s, Map<Character, Integer> t) {
        for (char c : t.keySet()) {
            if (s.getOrDefault(c, 0) < t.get(c)) {
                return false;
            }
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray(), t = fs.next().toCharArray();
        solve(s, t);
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
        new B448().run();
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
