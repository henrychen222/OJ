/**
 * 03/31/22 morning
 * https://codeforces.com/contest/1660/problem/C
 */
package codeforce.cf.div3.r780;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1660/submission/151598255
    // reference: chinesedfan
    void solve(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] dp = new int[n];
        int[] prePos = new int[26];
        Arrays.fill(prePos, -1);
        prePos[a[0] - 'a'] = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            char c = a[i];
            int remove = dp[i - 1] + 1;
            int pos = prePos[c - 'a'];
            if (pos != -1) {
                int dis = i - pos - 1; // aabbdabdccc   bdab  (3, 6)  6 - 3 - 1 = 2  remove da
                int preMinRemove = pos >= 1 ? dp[pos - 1] + dis : dis;
                dp[i] = Math.min(remove, preMinRemove);
            } else {
                dp[i] = remove;
            }
            prePos[c - 'a'] = i;
            // tr(dp, pos);
        }
        pr(dp[n - 1]);
    }

    // WA
    void solve1(String s) {
        char[] a = s.toCharArray();
        List<char[]> d = cutMaxConsecutive(a);
        // debugArrayInList(d);
        List<Character> toRemove = new ArrayList<>();
        for (char[] e : d) {
            int len = e.length;
            if (len % 2 == 0) {
            } else {
                toRemove.add(e[0]);
            }
        }
        // tr(toRemove, toRemove.size());
        Set<Character> se = new HashSet<>(toRemove);
        // tr(se, se.size(), "s", s.length());
        int diff = s.length() - se.size();
        if (diff % 2 == 1) { // issue
            pr(Math.max(0, se.size() - 1));
        } else {
            pr(se.size());
        }
        // don't know
//        Map<Character, Integer> m = counter(toRemove);
//        String t = "";
//        for (char c : toRemove) {
//            if (m.get(c) == 1) continue;
//            t += c;
//        }
//        tr(t);
    }

    Map<Character, Integer> counter(List<Character> l) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : l) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    List<char[]> cutMaxConsecutive(char[] a) {
        List<char[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    void debugArrayInList(List<char[]> l) {
        char[][] res = new char[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
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
        new C().run();
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