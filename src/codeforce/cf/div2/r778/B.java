/**
 * 03/20/22 morning
 * https://codeforces.com/contest/1654/problem/B
 */
package codeforce.cf.div2.r778;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(String s) {
        int len = s.length();
        if (len == 1) {
            pr(s);
            return;
        }
        Map<Character, ArrayList<Integer>> m = counter_value_in_indexA_in(s);
        // tr(m);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
//            String rs = s.substring(i + 1);
//            if (!KMP(rs, c + "")) {
//                pr(s.substring(i));
//                return;
//            }
            List<Integer> a = m.get(c);
            if (i == a.get(a.size() - 1)) {
                pr(s.substring(i));
                return;
            }
        }
    }

    Map<Character, ArrayList<Integer>> counter_value_in_indexA_in(String s) {
        Map<Character, ArrayList<Integer>> m = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!m.containsKey(c)) m.put(c, new ArrayList<>());
            m.get(c).add(i);
        }
        return m;
    }

    // TLE
    void solve1(String s) {
        int len = s.length();
        if (len == 1) {
            pr(s);
            return;
        }
        // for (int t = 0; t < 1; t++) {
        while (true) {
            String pre = "", rest = s.substring(1);
            for (int i = 0; i < s.length(); i++) {
                pre += s.charAt(i);
                if (!KMP(rest, pre)) {
                    tr("pre", pre, "s", s, i, s.charAt(i));
                    s = s.substring(i);
                    break;
                }
            }
            if (s.length() == len || s.length() == 1) {
                break;
            } else {
                len = s.length();
            }
            tr("updated s", s);
        }
        pr(s);
    }

    boolean KMP(String s, String pattern) {
        int[] prefixTable = longestPrefix(s);
        int i = 0, j = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = prefixTable[j - 1];
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
            if (j == pattern.length()) return true;
        }
        return false;
    }

    int[] longestPrefix(String s) {
        int n = s.length(), l = 0; // l: max prefix
        int[] pre = new int[n];
        if (n == 0) return pre;
        pre[0] = 0;
        for (int i = 1; i < n; i++) {
            while (s.charAt(i) != s.charAt(l) && l > 0) {
                l = pre[l - 1];
            }
            if (s.charAt(l) == s.charAt(i)) l++;
            pre[i] = l;
        }
        return pre;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            solve(s);
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
        new B().run();
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