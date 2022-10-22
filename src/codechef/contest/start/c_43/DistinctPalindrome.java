/**
 * 06/15/22 morning
 * https://www.codechef.com/START43C/problems/DISPAL
 */
package codechef.contest.start.c_43;

import java.util.*;
import java.io.*;

class DistinctPalindrome {
    static PrintWriter pw;

    /*
     3 1   aaa
     3 2   aba
     3 3  -1

     4 1   aaaa
     4 2   abba
     4 3   -1
     4 4   -1

     5 1   aaaaa
     5 2   aabaa
     5 3   abcba

     7 3   abc d cba
     */
    // Accepted
    // TLE using String https://www.codechef.com/viewsolution/66940523
    void solve(int n, int x) {
        int max = (n + 1) / 2, h = n / 2;
        if (x > max) {
            pr(-1);
            return;
        }
        char[] res = new char[n];
        char c = 'a';
//        String L = "", M = "";
        int i;
        for (i = 0; i < (n % 2 == 0 ? x : x - 1); i++, c++) {
            // L += c;
            res[i] = c;
            res[n - 1 - i] = c;
        }
//        L += repeat("a", h - L.length());
//        String R = fast_reverse(L);
        for (int k = i; k < h; k++) {
            res[k] = 'a';
            res[n - k - 1] = 'a';
        }
        if (n % 2 != 0) {
            // M += c;
            res[h] = c;
        }
        // String res = L + M + R;
        // tr(res, test(res, x));
        pr(new String(res));
    }

    String repeat(String c, int t) {
        String res = "";
        while (t-- > 0) res += c;
        return res;
    }

    String fast_reverse(String s) {
        char[] a = s.toCharArray();
        int n = a.length, h = n / 2;
        for (int i = 0; i < h; i++) {
            char tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
        return new String(a);
    }

    boolean test(String s, int x) {
        Set<Character> se = new HashSet<>();
        for (int i = 0; i < s.length(); i++) se.add(s.charAt(i));
        return isPalindrome(s) && se.size() == x;
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
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new DistinctPalindrome().run();
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
