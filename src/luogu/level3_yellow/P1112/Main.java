/**
 * 02/10/25 evening
 * https://www.luogu.com.cn/problem/P1112
 */
package luogu.level3_yellow.P1112;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // TLE https://www.luogu.com.cn/record/202564135
    void solve(int l, int r, int L, int R, int k) {
//        for (int x = L; x <= R; x++) {
//            int cnt = 0;
//            for (int base = l; base <= r; base++) {
//                String s = DecimalToAnyBase(x, base);
//                boolean check = isAlternate(s);
////                tr(x, s, "base", base, check);
//                if (check) {
//                    cnt++;
//                }
//            }
//            if (cnt == k) {
//                pr(x);
//            }
//        }

        StringBuilder cur = new StringBuilder();
        dfs(cur, l, r, L, R, k);
    }

    void dfs(StringBuilder cur, int l, int r, int L, int R, int k) {
        if (cur.length() > 8) return;
        for (char i = '0'; i <= '9'; i++) {
            cur.append(i);
            int x = Integer.parseInt(cur.toString()), cnt = 0;
//            tr("cur", cur);
            if (isAlternate(cur.toString())) {
                if (x >= L && x <= R) {
                     // tr(cur, x);
                    for (int base = l; base <= r; base++) {
                        String s = DecimalToAnyBase(x, base);
                        if (isAlternate(s)) cnt++;
                    }
                    if (cnt == k) {
                        pr(x);
                    }
                }
                dfs(cur, l, r, L, R, k);
            }
            cur.deleteCharAt(cur.length() - 1);
        }
    }

//    boolean isAlternate2(Deque<Character> q) {
//        int n = q.size();
//        if (n == 1) return true;
//        Set<Character> even = new HashSet<>(), odd = new HashSet<>();
//        int i = 0;
//        for (char x : q) {
//            if (i % 2 == 0) {
//                even.add(x);
//            } else {
//                odd.add(x);
//            }
//            i++;
//        }
//        return even.size() == 1 && odd.size() == 1 && even.iterator().next() == odd.iterator().next();
//    }

    boolean isAlternate(String s) {
        int n = s.length();
        if (n == 1) return true;
        Set<Character> even = new HashSet<>(), odd = new HashSet<>();
        for (int i = 0; i < n; i += 2) {
            even.add(s.charAt(i));
        }
        for (int i = 1; i < n; i += 2) {
            odd.add(s.charAt(i));
        }
//        tr(even, odd);
        return even.size() == 1 && odd.size() == 1 && s.charAt(0) != s.charAt(1);
    }

    String d = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String DecimalToAnyBase(int x, int ToBase) { // max base depends on d, base can be negative
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            int rem = x % ToBase;
            x /= ToBase;
            if (rem < 0) {
                rem += Math.abs(ToBase);
                x++;
            }
            res.insert(0, d.charAt(rem));
        }
        return res.toString();
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int l = Integer.parseInt(fs.next()), r = Integer.parseInt(fs.next()),
                L = Integer.parseInt(fs.next()), R = Integer.parseInt(fs.next()), k = Integer.parseInt(fs.next());
        solve(l, r, L, R, k);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
