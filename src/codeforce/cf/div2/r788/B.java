/**
 * 05/06/22 morning
 * https://codeforces.com/contest/1670/problem/B
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1670/submission/156128616
    // Accepted --- https://codeforces.com/contest/1670/submission/156129108 (my code version)
    // thinking correct, reference liouzhou_101
    void solve(int n, String ss, int k, char[] special) {
        char[] s = ss.toCharArray();
        // tr(n, s, k, special);
        Set<Character> se = new HashSet<>();
        for (char c : special) se.add(c);
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (se.contains(s[i])) {
//                if (ts.contains(i - 1)) {
//                    ts.add(i);
//                    ts.remove(i - 1);
//                } else {
//                    ts.add(i);
//                }
                ts.add(i);
            }
        }
        List<Integer> ia = new ArrayList<>(ts);
        // tr(ia);
        if (ia.size() == 0) {
            pr(0);
        } else if (ia.size() == 1) {
            pr(ia.get(0));
        } else {
            long res = 0;
            for (int i = 1; i < ia.size(); i++) {
                int L = ia.get(i - 1);
                int R = ia.get(i);
//                int diff = R - L - 1;
//                res += diff;
                int diff = R - L;
                res = Math.max(res, diff); // key point, get max  thinking wrong here at first
            }
            int first = ia.get(0), last = n - ia.get(ia.size() - 1) - 1;
            // tr("res", res);
            // res = res + first + last;
            // res += first;
            res = Math.max(res, first);
            pr(res);
        }
        // test(ss, se);
    }

    // TLE https://codeforces.com/contest/1670/submission/156126731
    void test(String s, Set<Character> se) {
        String pre = s;
        long res = 0;
//        for (int j = 0; j < 5; j++) {
        while (true) {
            Set<Integer> toRemove = new HashSet<>();
            for (int i = 0; i + 1 < s.length(); i++) {
                if (se.contains(s.charAt(i + 1))) {
                    toRemove.add(i);
                }
            }
            // tr("s", s, toRemove);
            String t = "";
            for (int i = 0; i < s.length(); i++) {
                if (!toRemove.contains(i)) {
                    t += s.charAt(i);
                }
            }
            // tr("t", t);
            s = t;
            if (s.equals(pre)) {
                break;
            } else {
                res++;
                pre = s;
            }
            // tr(s, "res", res);
        }
        tr("test res", res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            int k = fs.nextInt();
            char[] special = fs.readArray(k);
            solve(n, s, k, special);
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

        char[] readArray(int n) {
            char[] a = new char[n];
            for (int i = 0; i < n; i++) a[i] = next().charAt(0);
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}