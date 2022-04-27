/**
 * 03/22/22 morning
 * https://codeforces.com/contest/1657/problem/C
 */
package codeforce.ecf.r125;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1657/submission/150537152
    // reference: um_nik  jiangly
    void solve(int n, String s) {
        int i, remove = 0;
        for (i = 0; i + 1 < n; ) {
            char c = s.charAt(i);
            if (c == '(') {
                remove++;
                i += 2;
            } else {
                int preI = i;
                i++;
                while (i < n && s.charAt(i) == '(') i++;
                if (i == n) {
                    i = preI;
                    break;
                }
                i++;
                remove++;
            }
        }
        pr(remove + " " + (n - i));
    }

    // TLE
    void solve1(int n, String s) {
        // test(n, s);
        int i, remove = 0;
        String pre = "";
        int preI = -1;
        for (i = 0; i < n; i++) {
            char c = s.charAt(i);
            pre += c;
            if (pre.length() >= 2) {
                if (isPalindrome(pre) || (c == ')' && validParentheses(pre))) {
                    remove++;
                    pre = "";
                    preI = i;
                }
            }
        }
        // tr(s, preI, i, "rest", s.substring(preI + 1));
        pr(remove + " " + (n - preI - 1));
    }

    void test(int n, String s) {
//        tr(validParentheses("(())()"), validParentheses("()"), validParentheses("(()(()))"));
//        tr(validParentheses(")("), validParentheses("(()"), validParentheses("(()))("));
        int cnt = 0;
        while (true) {
            String pre = "";
            boolean find = false;
            int i;
            for (i = 0; i < s.length(); i++) {
                pre += s.charAt(i);
                if (isGood(pre)) {
                    find = true;
                    break;
                }
            }
            if (!find) break;
            s = s.substring(i + 1);
            cnt++;
        }
        tr("test", s, cnt + " " + s.length());
    }

    boolean isGood(String s) {
        return validParentheses(s) || (s.length() >= 2 && isPalindrome(s));
    }

    boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    boolean validParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> m = Map.of('(', ')', '{', '}', '[', ']');
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (m.containsKey(c)) {
                st.push(c);
            } else {
                if (st.size() == 0) return false;
                char preL = st.pop();
                if (m.get(preL) != c) {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }

    boolean validParentheses2(String s) {
        int left = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    return false;
                }
            }
        }
        return left == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
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
        new C().run();
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