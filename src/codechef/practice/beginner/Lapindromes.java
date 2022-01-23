/**
 * 01/06/21 evening
 * https://www.codechef.com/problems/LAPIN
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class Lapindromes {

    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/55949131
    void solve(String s) {
        int n = s.length();
        String l = "", r = "";
        if ((n & 1) == 1) {
            for (int i = 0, j = n - 1; i < n >> 1; i++, j--) {
                l += s.charAt(i);
                r += s.charAt(j);
            }
        } else {
            for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
                l += s.charAt(i);
                r += s.charAt(j);
            }
        }
        // tr(l, r);
        pr(check2(l, r) ? "YES" : "NO");
    }

    // Accepted --- https://www.codechef.com/viewsolution/55948768
    void solve1(String s) {
        int n = s.length();
        String l = "", r = "";
        if (n % 2 == 0) {
            l = s.substring(0, n / 2);
            r = s.substring(n / 2);
        } else {
            l = s.substring(0, n / 2);
            r = s.substring(n / 2 + 1);
        }
        // tr(l, r);
        pr(check2(l, r) ? "YES" : "NO");
    }

    boolean check(String l, String r) {
        char[] L = l.toCharArray(), R = r.toCharArray();
        Arrays.sort(L);
        Arrays.sort(R);
        // tr("sort", L, R);
        return new String(L).equals(new String(R));
    }

    // Accepted --- https://www.codechef.com/viewsolution/55948940
    boolean check2(String l, String r) {
        char[] L = l.toCharArray(), R = r.toCharArray();
        int[] a = new int[26], b = new int[26];
        for (char c : L) a[c - 'a']++;
        for (char c : R) b[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs.next());
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
        new Lapindromes().run();
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