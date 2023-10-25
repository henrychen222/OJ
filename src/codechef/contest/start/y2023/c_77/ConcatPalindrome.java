/**
 * 02/15/23 noon   02/15/22 afternoon complete
 * https://www.codechef.com/START77C/problems/CONCATPAL
 */
package codechef.contest.start.y2023.c_77;

import java.util.*;
import java.io.*;

class ConcatPalindrome {
    static PrintWriter pw;

    // Acceted --- https://www.codechef.com/viewsolution/89639428
    // reference: https://discuss.codechef.com/t/concatpal-editorial/105253/2
    void solve(int n, int m, char[] a, char[] b) {
        if (n >= m) {
            canFormPalindromeByRearrangeThenConcat(a, b);
        } else {
            canFormPalindromeByRearrangeThenConcat(b, a);
        }
    }

    /*
     1
     5 2
     accdd
     ab
     */
    void solve1(int n, int m, char[] a, char[] b) {
        int[] fa = new int[26], fb = new int[26];
        for (char c : a) fa[c - 'a']++;
        for (char c : b) fb[c - 'a']++;
//        tr(fa);
//        tr(fb);
        List<Integer> oddCnt = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if ((fa[i] + fb[i]) % 2 != 0) oddCnt.add(i);
        }
        if (oddCnt.size() > 1) {
            pr("NO");
            return;
        } else if (oddCnt.size() == 1) { // single one should be in middle index
            int len = n + m, middle = len >> 1, idx = oddCnt.get(0);
            // tr(oddCnt, middle, idx);
            if (middle < n) { // single char should in a
                if (fa[idx] == 0) {
                    pr("NO");
                    return;
                }
            } else {
                if (fb[idx] == 0) { // single char should in b
                    pr("NO");
                    return;
                }
            }
        }
        pr("YES");
    }

    void canFormPalindromeByRearrangeThenConcat(char[] a, char[] b) {
        assert a.length >= b.length;
        int[] fa = new int[26], fb = new int[26];
        for (char c : a) fa[c - 'a']++;
        for (char c : b) fb[c - 'a']++;
        int oddCnt = 0;
        boolean ok = true;
        for (int i = 0; i < 26; i++) {
            int diff = fa[i] - fb[i];
            if (diff % 2 != 0) oddCnt++;
            if (diff < 0) ok = false;
        }
        pr(oddCnt <= 1 && ok ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] d = fs.readArray(2);
            char[] a = fs.next().toCharArray(), b = fs.next().toCharArray();
            solve(d[0], d[1], a, b);
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
        new ConcatPalindrome().run();
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
