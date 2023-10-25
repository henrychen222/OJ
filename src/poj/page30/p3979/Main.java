/**
 * 03/29/23 evening
 * http://poj.org/problem?id=3979
 */
package poj.page30.p3979;

import java.util.*;
import java.io.*;

/*
  reference:
  https://leetcode.com/problems/fraction-addition-and-subtraction/
  http://poj.org/showmessage?message_id=352329 (debug test cases)
 */
// this problem is harder, needs to consider negative value
class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24064546
    // RE --- http://poj.org/showsource?solution_id=24064537 (Integer.parseInt NumberFormatException)
    // CE http://poj.org/showsource?solution_id=24064568 (no Deque in 1.5)
    void fractionAddition(String s) {
        List<String> a = new ArrayList<String>();
        int n = s.length(), start = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) continue;
            if (s.charAt(i) == '+' || s.charAt(i) == '-' && Character.isDigit(s.charAt(i - 1))) { // 有负数存在
                a.add(s.substring(start, i));
                start = i;
            }
        }
        a.add(s.substring(start));
        while (a.size() > 1) {
            String first = a.remove(a.size() - 1), second = a.remove(a.size() - 1);
            a.add(cal(first, second));
        }
        String res = a.get(0), ans = "";
        int idx = res.indexOf('-');
        if (idx == -1) {
            ans = res;
        } else {
            ans = "-" + res.substring(0, idx) + res.substring(idx + 1);
        }
        int L = safeConvertStringToInteger(ans.substring(0, ans.indexOf('/'))), R = safeConvertStringToInteger(ans.substring(ans.indexOf('/') + 1));
        if (L == 0) { // 分子为0
            pr(0);
        } else if (R == 1) { // 分母为1
            pr(L);
        } else {
            pr(ans);
        }
    }

    String cal(String x, String y) {
        int[] tmpx = findTopDown(x), tmpy = findTopDown(y);
        int topx = tmpx[0], downx = tmpx[1], topy = tmpy[0], downy = tmpy[1];
        int LCM = lcm(downx, downy);
        int sum = topx * (LCM / downx) + topy * (LCM / downy);
        int GCD = gcd(sum, LCM);
        return "" + sum / GCD + '/' + LCM / GCD;
    }

    int[] findTopDown(String s) {
        String[] a = s.split("/");
        int top = safeConvertStringToInteger(a[0]), down = safeConvertStringToInteger((a[1]));
        return new int[]{top, down};
    }

    int safeConvertStringToInteger(String s) {
        if (s == null || s.length() == 0) return 0;
        int neg = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                neg++;
            } else if (Character.isDigit(c)) {
                res += c;
            }
        }
        return neg % 2 == 0 ? Integer.parseInt(res) : -Integer.parseInt(res);
    }

    int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s;
        while ((s = fs.nextLine()) != null) fractionAddition(s);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new Main().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}