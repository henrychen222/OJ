/**
 * 04/16/22 noon
 * https://www.codechef.com/LTIME107C/problems/PALINPAIN
 */
package codechef.contest.ltime.c_107;

import java.util.*;
import java.io.*;

class PalindromePain {
    static PrintWriter pw;

    /////////////////////////////////////////////////
    /*
     4 3
     aabbbaa
     abababa

     4 5
     aabbbbbaa
     babababab

     3 4
     bbaaabb
     bababab

     5 4
     bbaaaaabb
     ababababa
     */
    // WA https://www.codechef.com/viewsolution/63090387
    // WA https://www.codechef.com/viewsolution/63096733 (algorithm is correct, fuck print -1 and null null both)
    // Accepted https://www.codechef.com/viewsolution/63113090
    void solve(int x, int y) {
        if (x == 1 || y == 1) {
            pr(-1);
            return;
        }
        // tr(x, y);
        String res1 = null, res2 = null;
        boolean hasAnswer = true;
        if (x % 2 == 0) {
            if (y % 2 == 0) {
                res1 = repeat("a", x / 2) + repeat("b", y) + repeat("a", x / 2);
                res2 = repeat("b", y / 2) + repeat("a", x) + repeat("b", y / 2);
            } else {
                res1 = repeat("a", x / 2) + repeat("b", y) + repeat("a", x / 2);
//                if (x > y) {
//                    res2 = repeat("ab", y) + "a";
//                } else {
//                    res2 = repeat("ba", x) + "b";
//                }
                if (x < y) {
                    int h = (y - x + 1) / 2;
                    // tr("h111", h);
                    String LR = repeat("b", h);
                    res2 = LR + repeat("ab", x - 1) + "a" + LR;
                } else {
                    int h = (x - y + 1) / 2;
                    // tr("h222", h);
                    String LR = repeat("a", h);
                    res2 = LR + repeat("ba", y - 1) + "b" + LR;
                }
            }
        } else {
            if (y % 2 == 0) {
                res1 = repeat("b", y / 2) + repeat("a", x) + repeat("b", y / 2);
//                if (x < y) {
//                    res2 = repeat("ba", x) + "b";
//                } else {
//                    res2 = repeat("ab", y) + "a";
//                }
                if (x < y) {
                    int h = (y - x + 1) / 2;
                    // tr("h333", h);
                    String LR = repeat("b", h);
                    res2 = LR + repeat("ab", x - 1) + "a" + LR;
                } else {
                    int h = (x - y + 1) / 2;
                    // tr("h444", h);
                    String LR = repeat("a", h);
                    res2 = LR + repeat("ba", y - 1) + "b" + LR;
                }
            } else {
                hasAnswer = false;
                pr(-1);
            }
        }
        if (hasAnswer) {
            pr(res1);
            pr(res2);
//            tr(test(res1, x, y));
//            tr(test(res2, x, y));
        }
    }

    String repeat(String c, int t) {
        String res = "";
        while (t-- > 0) res += c;
        return res;
    }

    boolean test(String s, int x, int y) {
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        return cnt1 == x && cnt2 == y && isPalindrome(s);
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
        new PalindromePain().run();
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
