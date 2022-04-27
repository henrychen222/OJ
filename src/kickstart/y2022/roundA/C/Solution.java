// 03/19/22 night
package kickstart.y2022.roundA.C;

import java.util.*;
import java.io.*;

/**
 * Accepted
 * reference:Priyansh31dec
 */
public class Solution {
    static PrintWriter pw;
    String s;
    int n;
    Map<String, Integer> memo;

    void solve() {
        memo = new HashMap<>();
        int res = dfs("?????", 0);
        // tr(res);
        pr(res != 0 ? "POSSIBLE" : "IMPOSSIBLE");
    }

    int dfs(String pre, int pos) {
        // tr(pre, pos, n);
        if (pos == n) return 1;
        String ke = pos + " " + pre;
        if (memo.containsKey(ke)) return memo.get(ke);
        String s1 = pre.substring(1, 5) + '0', s2 = pre.substring(1, 5) + '1';
        // tr("s1", s1, "s2", s2);
        int res = 0;
        char c = s.charAt(pos);
        if (c == '?') {
            if (!isPalindrome(s1) && !isPalindrome(pre + '0')) {
                res += dfs(s1, pos + 1);
            }
            if (!isPalindrome(s2) && !isPalindrome(pre + '1')) {
                res += dfs(s2, pos + 1);
            }
        } else if (c == '1') {
            if (!isPalindrome(s2) && !isPalindrome(pre + "1")) {
                res += dfs(s2, pos + 1);
            }
        } else {
            if (!isPalindrome(s1) && !isPalindrome(pre + "0")) {
                res += dfs(s1, pos + 1);
            }
        }
        memo.put(ke, res);
        return res;
    }

    boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            n = fs.nextInt();
            s = fs.next();
            solve();
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