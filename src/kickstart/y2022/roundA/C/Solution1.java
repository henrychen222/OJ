/**
 * 03/19/22 night
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e762e
 */
package kickstart.y2022.roundA.C;

import java.util.*;
import java.io.*;

public class Solution1 {
    static PrintWriter pw;

    // WA
    void solve(int n, char[] s) {
        if (!ok(s)) {
            pr("IMPOSSIBLE");
            return;
        }
        int question = 0;
        for (char c : s) {
            if (c == '?') question++;
        }
        while (question > 0) {
            boolean change = false;
            for (int i = 0; i < n; i++) {
                int pi = n - 1 - i;
                if (s[i] == '?' && s[pi] != '?') {
                    // tr(i, pi, s[pi]);
                    s[i] = oppo(s[pi]);
                    change = true;
                    question--;
                }
            }
            if (!change) break;
        }
        // tr(s, ok(s));
        if (ok(s) && question == 0) {
            pr("POSSIBLE");
        } else {
            pr("IMPOSSIBLE");
        }
    }

    char oppo(char c) {
        return c == '0' ? '1' : '0';
    }

    boolean ok(char[] s) {
        int n = s.length;
        for (int i = 0; i + 5 <= n; i++) {
            char[] sub = Arrays.copyOfRange(s, i, i + 5);
            boolean question = false;
            for (char c : sub) {
                if (c == '?') question = true;
            }
            if (isPalindrome(sub) && !question) {
                // tr(sub);
                return false;
            }
        }
        return true;
    }

    boolean isPalindrome(char[] s) {
        int n = s.length, i = 0, j = n - 1;
        while (i < j) {
            if (s[i++] != s[j--]) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            solve(n, s);
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
        new Solution1().run();
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