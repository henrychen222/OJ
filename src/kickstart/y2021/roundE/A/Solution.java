/**
 * 09/16/21 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000043585c/000000000085a152
 */
package kickstart.y2021.roundE.A;

import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    // reference: uwi
    // Accepted
    void solve(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[][] ai = new int[n][2];
        for (int i = 0; i < n; i++) {
            ai[i][0] = a[i];
            ai[i][1] = i;
        }
        Arrays.sort(ai, (x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[ai[(i + n / 2) % n][1]] = (char) ai[i][0];
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == a[i]) {
                pr("IMPOSSIBLE");
                return;
            }
        }
        pr(new String(res));
    }
    ///////////////////////////////////////////////////////////////////////////////

    boolean test(String res, String s) {
        int n = s.length();
        if (res.length() != n) return false;
        for (int i = 0; i < n; i++) {
            if (res.charAt(i) == s.charAt(i)) return false;
        }
        return true;
    }

    // WA
    void solve2(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a']++;
        // tr(cnt);
        String res = "";
        for (int i = 0; i < n; i++) {
            char no = s.charAt(i);
            if (i == n - 1) {
                // tr(cnt);
                boolean found = false;
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] == 0) continue;
                    char c = (char) ('a' + j);
                    tr(c);
                    if (c != no) {
                        res += c;
                        found = true;
                    }
                }
                if (!found) {
                    pr("IMPOSSIBLE");
                    return;
                }
            } else {
                boolean found = false;
                for (int j = i + 1; j < n; j++) {
                    char c = s.charAt(j);
                    if (c != no && cnt[c - 'a'] > 0) {
                        res += c;
                        cnt[c - 'a']--;
                        found = true;
                        break;
                    }
                }
                tr("res", res);
                if (!found) {
                    for (int j = 0; j < i; j++) {
                        char c = s.charAt(j);
                        if (c != no && cnt[c - 'a'] > 0) {
                            res += c;
                            cnt[c - 'a']--;
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    pr("IMPOSSIBLE");
                    return;
                }
            }
        }
        pr(res + " " + test(res, s));
    }

    // not work
    void solve1(String s) {
        int n = s.length();
        int[][] cnt = new int[26][2];
        for (int i = 0; i < 26; i++) cnt[i][0] = i;
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'a'][1]++;
        tr(cnt);
        String res = "";
        for (int i = 0; i < n; i++) {
            char no = s.charAt(i);
            tr("no", no);
            int[][] tmp = cnt.clone();
            Arrays.sort(tmp, (x, y) -> y[1] - x[1]); // not correct
            tr("tmp", tmp);
            boolean found = false;
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + tmp[j][0]);
                int occ = tmp[j][1];
                if (c != no && occ > 0) {
                    tr("use", c, occ);
                    res += c;
                    cnt[c - 'a'][1]--;
                    found = true;
                    break;
                }
            }
            tr("cnt", cnt);
            tr("res", res);
            if (!found) {
                pr("IMPOSSIBLE");
                return;
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
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
        new Solution().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
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