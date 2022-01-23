/**
 * 01/17/22 morning
 * https://www.codechef.com/problems/TICKETS5
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class Tickets {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/56553324
    // understand alternate wrong at first, thought must be  ABAB...  actually any order is alternate
    void solve(String s) {
        Set<Character> se = new HashSet<>();
        char[] a = s.toCharArray();
        for (char c : a) se.add(c);
        if (se.size() != 2) {
            pr("NO");
            return;
        }
        pr("YES");
    }

    // Partial Correct https://www.codechef.com/viewsolution/56553059
    void solve2(String s) {
        int n = s.length();
        char a = s.charAt(0), b = s.charAt(1);
        if (n == 2) {
            if (a == b) {
                pr("NO");
                return;
            }
        }
        for (int i = 2; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (c != a) {
                    pr("NO");
                    return;
                }
            } else {
                if (c != b) {
                    pr("NO");
                    return;
                }
            }
        }
        pr("YES");
    }

    // Partial Correct https://www.codechef.com/viewsolution/56552163
    void solve1(String s) {
        int n = s.length();
        String pre = null;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                pr("NO");
                return;
            }
            String alternate = i + 2 <= n ? s.substring(i, i + 2) : s.substring(i);
            // tr(alternate);
            if (pre != null && !alternate.equals(pre)) {
                pr("NO");
                return;
            }
            pre = alternate;
        }
        pr("YES");
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
        new Tickets().run();
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
