/**
 * 03/26/22 morning
 * https://www.acwing.com/problem/content/4321/
 */
package acwing.r44.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.acwing.com/problem/content/submission/code_detail/12536952/
    // reference: https://www.acwing.com/solution/content/105009/
    void solve(char[] s) {
        int x = 0, y = 0, preX, preY; // x, y: 当前位置  preX, preY: 上一步位置
        Set<String> vis = new HashSet<>();
        for (char c : s) {
            preX = x;
            preY = y;
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            }
            String ke = x + " " + y;
            if (vis.contains(ke)) { // 走过的点一定不能再走, 不满足最短路径
                pr("NO");
                return;
            }
            vis.add((preX - 1) + " " + preY); // 上一步的上下左右都存起来，后来走到一定是绕路的
            vis.add((preX + 1) + " " + preY);
            vis.add(preX + " " + (preY - 1));
            vis.add(preX + " " + (preY + 1));
        }
        pr("YES");
    }

    // WA
    void solve1(char[] s) {
        int x = 0, y = 0;
        for (char c : s) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            }
        }
        // tr(x, y);
        pr(x == 0 && y == 0 ? "NO" : "YES");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray();
        solve(s);
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