/**
 * 09/08/21 morning
 * https://codeforces.com/contest/1569/problem/B
 */
package codeforce.ecf.r113;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1569/submission/128283337
    // reference: cuiaoxiang
    void solve(int n, String s) {
        char[] a = s.toCharArray();
        char[][] g = new char[n][n];
        for (char[] e : g) Arrays.fill(e, 'X');
        // tr(g);
        for (int i = 0; i < n; i++) {
            if (a[i] == '1') {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    g[i][j] = g[j][i] = '=';
                }
            }
        }
        // tr(g);
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (a[i] == '2') {
                int j;
                for (j = 0; j < n; j++) {
                    if (i != j && g[i][j] == 'X') break;
                }
                if (j == n) {
                    ok = false;
                    break;
                }
                g[i][j] = '+';
                g[j][i] = '-';
            }
        }
        // tr(g);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && g[i][j] == 'X') g[i][j] = '=';
            }
        }
        if (!ok) {
            pr("NO");
            return;
        }
        pr("YES");
        output(g);
    }

    ////////////////////////////////////////////////////////////////////////////
    // don't know
    void solve1(int n, String s) {
        int one = 0, two = 0;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (a[i] == '1') {
                one++;
                st1.add(i);
            } else {
                two++;
                st2.add(i);
            }
        }
        if (n % 2 == 0 && one == two) {
            pr("NO");
            return;
        }
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            if (a[i] == '1') {
                int draw;
                if (!st1.isEmpty()) {
                    draw = st1.pop();
                } else {
                    draw = st2.pop();
                }
                if (i != draw) {
                    g[i][draw] = '=';
                    g[draw][i] = '=';
                }
            } else {
                int lose = st2.pop();
                if (i != lose) {
                    g[i][lose] = '+';
                    g[lose][i] = '-';
                }
            }
            tr(g);
        }
        // tr(g);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    g[i][j] = 'X';
                    continue;
                }
            }
        }
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
        new B().run();
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

    void output(char[][] g) {
        for (char[] a : g) {
            String tmp = "";
            for (char c : a) {
                tmp += c;
            }
            pr(tmp);
        }
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

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
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